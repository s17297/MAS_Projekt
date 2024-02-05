package org.example.GUI;

import org.example.Controller.PracownikController;
import org.example.Controller.RolnikController;
import org.example.Models.Pracownik;
import org.example.Models.Rolnik;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PracownikLogView extends JFrame {
    private Pracownik loggedUser;

    public PracownikLogView() {
        setTitle("Logowanie");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        PracownikController pracownikController = new PracownikController();

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel loginLabel = new JLabel("Login:");
        JTextField loginField = new JTextField(10);

        JButton zarejestrujButton = new JButton("Zarejestruj pracownika");
        JButton loginButton = new JButton("Zaloguj");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Tutaj pobierz użytkownika na podstawie loginu
                loggedUser = pracownikController.getPracownikByLogin(loginField.getText());
                if (loggedUser != null) {
                    dispose(); // Zamknięcie widoku logowania
//                    new FieldsView(loggedUser); // Otwarcie kolejnego widoku
                } else {
                    JOptionPane.showMessageDialog(PracownikLogView.this, "Błąd logowania. Spróbuj ponownie.", "Błąd logowania", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        zarejestrujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new CreatePracownikView();
            }
        });

        panel.add(loginLabel, BorderLayout.WEST);
        panel.add(loginField, BorderLayout.CENTER);
        panel.add(loginButton, BorderLayout.SOUTH);
        panel.add(zarejestrujButton, BorderLayout.EAST);

        add(panel);
        setVisible(true);
    }
}
