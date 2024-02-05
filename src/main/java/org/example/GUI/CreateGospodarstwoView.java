package org.example.GUI;

import org.example.Controller.GospodarstwoController;
import org.example.Controller.UprawaController;
import org.example.Models.Pole;
import org.example.Models.Rolnik;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class CreateGospodarstwoView extends JFrame {

        private Rolnik user;

        public CreateGospodarstwoView(Rolnik user) {
            this.user = user;

            setTitle("Dodaj Gospodarstwo: " + user.getOsoba().getLogin());
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(400, 300);
            setLocationRelativeTo(null);

            JLabel adresLabel = new JLabel("adres:");
            JTextField adresField = new JTextField(20);

            JLabel nipLabel = new JLabel("nip:");
            JTextField nipField = new JTextField(20);

            JLabel nazwaLabel = new JLabel("nazwa");
            JTextField nazwaField = new JTextField(20);

            JButton dodajButton = new JButton("Dodaj");
            dodajButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String adres = adresField.getText();
                    String nip = nipField.getText();
                    String nazwa = nazwaField.getText();


                    GospodarstwoController gospodarstwoController = new GospodarstwoController();
                    gospodarstwoController.addGospodarstwo(adres, nip, nazwa, user);
//                Uprawa newUprawa = new Uprawa(roslina, dataRozpoczecia);
//                newUprawa.setDataZakonczenia(dataZakonczenia);
//                pole.dodajUprawe(newUprawa);

                    JOptionPane.showMessageDialog(null, "Gospodarstwo zostało utworzone");

                    dispose(); // Zamknięcie obecnego widoku
                    new GospodarstwoView(user);
                }
            });

            JPanel panel = new JPanel(new GridLayout(4, 2));
            panel.add(adresLabel);
            panel.add(adresField);
            panel.add(nipLabel);
            panel.add(nipField);
            panel.add(nazwaLabel);
            panel.add(nazwaField);
            panel.add(dodajButton);

            add(panel);
            setVisible(true);
        }
    }


