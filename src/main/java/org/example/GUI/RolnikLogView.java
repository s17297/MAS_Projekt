package org.example.GUI;

import org.example.Controller.RolnikController;
import org.example.Models.Rolnik;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RolnikLogView extends JFrame {
    private Rolnik loggedUser;

    public RolnikLogView() {
        setTitle("Logowanie");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        RolnikController rolnikController = new RolnikController();

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel loginLabel = new JLabel("Login:");
        JTextField loginField = new JTextField(10);

        JButton loginButton = new JButton("Zaloguj");
        JButton zarejestrujButton = new JButton("Zarejestruj rolnika");

        zarejestrujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new CreateRolnikView();
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Tutaj pobierz użytkownika na podstawie loginu
                loggedUser = rolnikController.getRolnikByLogin(loginField.getText());
                if (loggedUser != null && loggedUser.getGospodarstwo() != null) {
                    dispose(); // Zamknięcie widoku logowania
                    new GospodarstwoView(loggedUser); // Otwarcie kolejnego widoku
                }else
                    if(loggedUser != null && loggedUser.getGospodarstwo() == null) {
                        dispose();
                    new CreateGospodarstwoView(loggedUser);
                }
                else {
                    JOptionPane.showMessageDialog(RolnikLogView.this, "Błąd logowania. Spróbuj ponownie.", "Błąd logowania", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(loginLabel);
        panel.add(loginField);
        panel.add(loginButton);
        panel.add(zarejestrujButton);
        panel.setLayout(new GridLayout(2, 2));
        add(panel);
        setVisible(true);
    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new MainView();
//            }
//        });
//    }
}

