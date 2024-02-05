package org.example.GUI;

import org.example.Models.Pole;
import org.example.Models.Rolnik;
import org.example.Models.Uprawa;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class UprawyListView extends JFrame {
    private Rolnik user;
    private Pole pole;

    public UprawyListView(Rolnik user, Pole pole) {
        this.user = user;
        this.pole = pole;

        setTitle("Lista upraw dla pola: " + pole.getNazwa());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        DefaultListModel<Uprawa> uprawyListModel = new DefaultListModel<>();
        for (Uprawa uprawa : pole.getUprawy()) {
            uprawyListModel.addElement(uprawa);
        }

        JList<Uprawa> uprawyList = new JList<>(uprawyListModel);
        uprawyList.setVisibleRowCount(10); // Ustawia widoczną liczbę wierszy listy
        uprawyList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Ustawia tryb wyboru na pojedynczy
        uprawyList.setLayoutOrientation(JList.VERTICAL); // Ustawia orientację listy na pionową

        JButton dodajButton = new JButton("Dodaj Uprawe");
        dodajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new CreateUprawaView(user, pole);
            }
        });

        JButton dodajZabiegButton = new JButton("Zleć zabieg");
        dodajZabiegButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new CreateZabiegView(user, uprawyList.getSelectedValue());
            }
        });

        JScrollPane scrollPane = new JScrollPane(uprawyList);

        JPanel panel = new JPanel();
        panel.add(scrollPane);
        panel.add(dodajButton);
        panel.add(dodajZabiegButton);

        Menu menu = new Menu(user, this);
        setJMenuBar(menu);
        add(panel);
        setVisible(true);
    }
}
