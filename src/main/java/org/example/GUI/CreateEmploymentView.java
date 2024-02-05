package org.example.GUI;

import org.example.Controller.GospodarstwoController;
import org.example.Models.Rolnik;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateEmploymentView extends JFrame{

    public CreateEmploymentView(Rolnik rolnik){
        System.out.println("create employment wywolany");
        setTitle("Zatrudnij Pracownika");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel pracownikLoginLabel = new JLabel("Login pracownika:");
        JTextField pracownikLoginField = new JTextField(10);

        JButton zatrudnijButton = new JButton("zatrudnij");

        zatrudnijButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GospodarstwoController gospodarstwoController = new GospodarstwoController();
                gospodarstwoController.zatrudnijPracownikaByLogin(pracownikLoginField.getText(), rolnik.getGospodarstwo());
                JOptionPane.showMessageDialog(null, "pracownik zatrudniony");
                dispose();
                new PracownicyListView(rolnik);
            }
        });
        Menu menu = new Menu(rolnik, this);
        setJMenuBar(menu);

        panel.add(pracownikLoginLabel, BorderLayout.WEST);
        panel.add(pracownikLoginField, BorderLayout.EAST);
        panel.add(zatrudnijButton, BorderLayout.SOUTH);
        add(panel);
        setVisible(true);


    }
}
