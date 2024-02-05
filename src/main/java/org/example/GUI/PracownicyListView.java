package org.example.GUI;

import org.example.Models.Pracownik;
import org.example.Models.Rolnik;
import org.example.Models.Uprawa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class PracownicyListView extends JFrame {

    public PracownicyListView(Rolnik rolnik){
        setTitle("Lista pracowników");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        DefaultListModel<Pracownik> pracownicyListModel = new DefaultListModel<>();

        // Pobierz mapę pracowników
        Map<String, Pracownik> pracownicyMapa = rolnik.getGospodarstwo().getListaPracownikow();

        // Iteruj przez mapę i dodaj pracowników do modelu listy
        for (Map.Entry<String, Pracownik> entry : pracownicyMapa.entrySet()) {
            Pracownik pracownik = entry.getValue();
            pracownicyListModel.addElement(pracownik);
        }

        JList<Pracownik> pracownicyList = new JList<>(pracownicyListModel);
        pracownicyList.setVisibleRowCount(10); // Ustawia widoczną liczbę wierszy listy
        pracownicyList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Ustawia tryb wyboru na pojedynczy
        pracownicyList.setLayoutOrientation(JList.VERTICAL); // Ustawia orientację listy na pionową

        JButton zatrudnijPracownikaButton = new JButton("Zatrudnij pracownika");
        zatrudnijPracownikaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new CreateEmploymentView(rolnik);
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
            panel.add(pracownicyList);
            panel.add(zatrudnijPracownikaButton);
        Menu menu = new Menu(rolnik, this);
        setJMenuBar(menu);
            add(panel);
            setVisible(true);

//        JList<String> uprawyList = new JList<>(uprawyListModel);

//        uprawyList.setVisibleRowCount(10); // Ustawia widoczną liczbę wierszy listy
//        uprawyList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Ustawia tryb wyboru na pojedynczy
//        uprawyList.setLayoutOrientation(JList.VERTICAL); // Ustawia orientację listy na pionową


    }

}
