package org.example.GUI;

import org.example.Models.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PojazdyListView extends JFrame {
    public PojazdyListView(Rolnik rolnik) {

        setTitle("Lista pojazdów uzytkownika " + rolnik.getOsoba().getLogin());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        JButton dodajPojazdButton = new JButton("dodaj pojazd");

        DefaultListModel<Pojazd> pojazdyListModel = new DefaultListModel<>();
        rolnik.getGospodarstwo().getPojazdy().forEach((Pojazd p) -> {
//            if(p instanceof Traktor){
//                System.out.println(p);
//                System.out.println("instance of traktor");
//                Traktor traktor = (Traktor) p;
//                System.out.println(traktor);
//                pojazdyListModel.addElement(p);
//            }else if(p instanceof WozekWidlowy){
//                System.out.println("instance of wozek");
//                WozekWidlowy wozekWidlowy = (WozekWidlowy) p;
//                    pojazdyListModel.addElement(wozekWidlowy);
//                }else if (p instanceof Ladowarka){
//                System.out.println("instance of ladowarka");
//                Ladowarka ladowarka = (Ladowarka) p;
//                    pojazdyListModel.addElement(ladowarka);
//                }
            pojazdyListModel.addElement(p);
        });

        dodajPojazdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new CreatePojazdView(rolnik);
            }
        });


        JList<Pojazd> pojazdyList = new JList<>(pojazdyListModel);
        pojazdyList.setVisibleRowCount(10); // Ustawia widoczną liczbę wierszy listy
        pojazdyList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Ustawia tryb wyboru na pojedynczy
        pojazdyList.setLayoutOrientation(JList.VERTICAL); // Ustawia orientację listy na pionową

        JScrollPane scrollPane = new JScrollPane(pojazdyList);

        Menu menu = new Menu(rolnik, this);
        setJMenuBar(menu);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
        add(panel);
        panel.add(scrollPane);
        panel.add(dodajPojazdButton);
        setVisible(true);

    }
}
