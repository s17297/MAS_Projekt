package org.example.GUI;

import org.example.Controller.PoleController;
import org.example.Models.Rolnik;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CreatePoleView extends JFrame {
    private Rolnik user;

    public CreatePoleView(Rolnik user) {
        this.user = user;

        setTitle("Tworzenie nowego pola");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JLabel nameLabel = new JLabel("Nazwa:");
        JTextField nameField = new JTextField(20);

        JLabel numerLabel = new JLabel("Numer działki:");
        JTextField numerField = new JTextField(20);

        JLabel powierzchniaLabel = new JLabel("Powierzchnia:");
        JTextField powierzchniaField = new JTextField(20);



        JButton createButton = new JButton("Utwórz");
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nazwa = nameField.getText();
                String numer = numerField.getText();
                double powierzchnia = Double.parseDouble(powierzchniaField.getText());

//                Pole newPole = Pole.dodajPole(nazwa, numer, powierzchnia, user.getGospodarstwo());
//                user.getGospodarstwo().getPola().add(newPole);
                PoleController poleController = new PoleController();
                poleController.addPole(nazwa, numer, powierzchnia, user.getGospodarstwo());

                JOptionPane.showMessageDialog(null, "Nowe pole zostało utworzone");

                dispose(); // Zamknięcie obecnego widoku
                new PolaListView(user); // Powrót do widoku listy pól
            }
        });

        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(numerLabel);
        panel.add(numerField);
        panel.add(powierzchniaLabel);
        panel.add(powierzchniaField);
        panel.add(createButton);

        Menu menu = new Menu(user, this);
        setJMenuBar(menu);
        add(panel);
        setVisible(true);
    }
}
