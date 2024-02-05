package org.example.GUI;

import org.example.Controller.RolnikController;
import org.example.Models.Rolnik;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseRoleView extends JFrame {

    public ChooseRoleView() {
        setTitle("Wybór roli");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JButton rolnikButton = new JButton("Rolnik");
        rolnikButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    dispose(); // Zamknięcie widoku logowania
                    new RolnikLogView(); // Otwarcie kolejnego widoku

            }
        });
        JButton pracownikButton = new JButton("Pracownik");
        pracownikButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Zamknięcie widoku logowania
                new PracownikLogView(); // Otwarcie kolejnego widoku

            }
        });


        panel.add(rolnikButton);
        panel.add(pracownikButton);
        panel.setLayout(new GridLayout(1, 2));
        panel.setSize(200, 100);

        add(panel);
        setVisible(true);
    }
}
