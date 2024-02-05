package org.example.GUI;

import org.example.Controller.GospodarstwoController;
import org.example.Controller.RolnikController;
import org.example.Models.Rolnik;
import org.hibernate.HibernateException;

import javax.persistence.PersistenceException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class CreateRolnikView extends JFrame {



    public CreateRolnikView() {

        setTitle("Zarejestruj Rolnika: ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JLabel loginLabel = new JLabel("login:");
        JTextField loginField = new JTextField(20);

        JLabel imieLabel = new JLabel("imie:");
        JTextField imieField = new JTextField(20);

        JLabel nazwiskoLabel = new JLabel("nazwisko");
        JTextField nazwiskoField = new JTextField(20);

        JLabel dataUrodzeniaLabel = new JLabel("data urodzenia");
        JTextField dataUrodzeniaField = new JTextField(20);

        JLabel adresZamieszkaniaLabel = new JLabel("adres zamieszniaka");
        JTextField adresZamieszkaniaField = new JTextField(20);

        JLabel telefonLabel = new JLabel("telefon");
        JTextField telefonField = new JTextField(20);

        JLabel peselLabel = new JLabel("pesel");
        JTextField peselField = new JTextField(20);

        JLabel emailLabel = new JLabel("email");
        JTextField emailField = new JTextField(20);

        JLabel wyksztalcenieLabel = new JLabel("wyksztalcenie");
        JTextField wyksztalcenieField = new JTextField(20);



        JButton dodajButton = new JButton("Dodaj");
        dodajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = loginField.getText();
                String imie = imieField.getText();
                String nazwisko = nazwiskoField.getText();
                LocalDate dataUrodzenia = LocalDate.parse(dataUrodzeniaField.getText());
                String adresZamieszkania = adresZamieszkaniaField.getText();
                String telefon = telefonField.getText();
                String pesel = peselField.getText();
                String email = emailField.getText();
                String wyksztalcenie = wyksztalcenieField.getText();


                RolnikController rolnikController = new RolnikController();
                try {
                rolnikController.addRolnik(login, imie, nazwisko, dataUrodzenia, adresZamieszkania, telefon,pesel, email, wyksztalcenie);
                JOptionPane.showMessageDialog(null, "Rolnik zostal utworzony");
                dispose(); // Zamknięcie obecnego widoku
                new RolnikLogView();

                }catch (PersistenceException ex){
                    SwingUtilities.invokeLater(() -> {
                        JOptionPane.showMessageDialog(null, "Błąd podczas tworzenia rolnika", "Błąd", JOptionPane.ERROR_MESSAGE);
                    });
//                    ex.printStackTrace();
                }
//                Uprawa newUprawa = new Uprawa(roslina, dataRozpoczecia);
//                newUprawa.setDataZakonczenia(dataZakonczenia);
//                pole.dodajUprawe(newUprawa);


            }
        });

        JPanel panel = new JPanel(new GridLayout(10, 2));
        panel.add(loginLabel);
        panel.add(loginField);
        panel.add(imieLabel);
        panel.add(imieField);
        panel.add(nazwiskoLabel);
        panel.add(nazwiskoField);
        panel.add(dataUrodzeniaLabel);
        panel.add(dataUrodzeniaField);
        panel.add(adresZamieszkaniaLabel);
        panel.add(adresZamieszkaniaField);
        panel.add(telefonLabel);
        panel.add(telefonField);
        panel.add(peselLabel);
        panel.add(peselField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(wyksztalcenieLabel);
        panel.add(wyksztalcenieField);
        panel.add(dodajButton);

        add(panel);
        setVisible(true);
    }
}
