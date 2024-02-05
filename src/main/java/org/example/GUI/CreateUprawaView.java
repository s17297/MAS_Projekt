package org.example.GUI;

import org.example.Controller.UprawaController;
import org.example.Models.Pole;
import org.example.Models.Rolnik;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

class CreateUprawaView extends JFrame {
    private Rolnik user;
    private Pole pole;

    public CreateUprawaView(Rolnik user, Pole pole) {
        this.user = user;
        this.pole = pole;

        setTitle("Dodaj uprawę do pola: " + pole.getNazwa());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JLabel roslinaLabel = new JLabel("Roślina:");
        JTextField roslinaField = new JTextField(20);

        JLabel dataRozpoczeciaLabel = new JLabel("Data rozpoczęcia (RRRR-MM-DD):");
        JTextField dataRozpoczeciaField = new JTextField(20);

        JLabel dataZakonczeniaLabel = new JLabel("Data zakończenia (opcjonalna, RRRR-MM-DD):");
        JTextField dataZakonczeniaField = new JTextField(20);

        JButton dodajButton = new JButton("Dodaj");
        dodajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String roslina = roslinaField.getText();
                LocalDate dataRozpoczecia = LocalDate.parse(dataRozpoczeciaField.getText());
                LocalDate dataZakonczenia = null;
                if (!dataZakonczeniaField.getText().isEmpty()) {
                    dataZakonczenia = LocalDate.parse(dataZakonczeniaField.getText());
                }

                UprawaController uprawaController = new UprawaController();
                uprawaController.addUprawa(roslina, dataRozpoczecia, pole);
//                Uprawa newUprawa = new Uprawa(roslina, dataRozpoczecia);
//                newUprawa.setDataZakonczenia(dataZakonczenia);
//                pole.dodajUprawe(newUprawa);

                JOptionPane.showMessageDialog(null, "Nowa uprawa została dodana");

                dispose(); // Zamknięcie obecnego widoku
                new UprawyListView(user, pole); // Przejście do widoku listy upraw
            }
        });

        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(roslinaLabel);
        panel.add(roslinaField);
        panel.add(dataRozpoczeciaLabel);
        panel.add(dataRozpoczeciaField);
        panel.add(dataZakonczeniaLabel);
        panel.add(dataZakonczeniaField);
        panel.add(dodajButton);

        Menu menu = new Menu(user, this);
        setJMenuBar(menu);
        add(panel);
        setVisible(true);
    }
}
