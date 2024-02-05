package org.example.GUI;

import org.example.Models.Rolnik;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GospodarstwoView extends JFrame {
    private Rolnik user;

    public GospodarstwoView(Rolnik user) {
        this.user = user;

        setTitle("Gospodarstwo użytkownika: " + user.getOsoba().getLogin());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JLabel wlascicielLabel = new JLabel("Właściciel");
        JTextField wlascicielTextField = new JTextField(user.getOsoba().getImie() + " " + user.getOsoba().getNazwisko());
        wlascicielTextField.setEditable(false);

        JLabel nazwaGospodarstwaLabel = new JLabel("Nazwa gospodarstwa");
        JTextField nazwaGospodarstwaTextField = new JTextField(user.getGospodarstwo().getNazwa());
        nazwaGospodarstwaTextField.setEditable(false);

        JLabel nipLabel = new JLabel("NIP");
        JTextField nipTextField = new JTextField(user.getGospodarstwo().getNip());
        nipTextField.setEditable(false);



//        JButton polaButton = new JButton("Pola");
//        JButton pracownicyButton = new JButton("Pracownicy");
//        JButton pojazdyButton = new JButton("Pojazdy");
////        System.out.println("czy dodal sie zabieg????????????????????????????");
////        System.out.println(user.getGospodarstwo().getZabiegi().get(0).getPracownicyWZabiegu().get(0).getPracownik().getOsoba().getNazwisko());
//
//        pracownicyButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(!user.getGospodarstwo().getListaPracownikow().isEmpty()) {
//                    System.out.println("user is not empty");
//                    dispose();
//                    new PracownicyListView(user);
//                }else{
//                    System.out.println("user is empty");
//
//                    dispose();
//                    new CreateEmploymentView(user);
//                }
//
//            }
//        });
//
//        polaButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                dispose(); // Zamknięcie obecnego widoku
//                new PolaListView(user); // Otwarcie kolejnego widoku
//            }
//        });
//
//        pojazdyButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                dispose(); // Zamknięcie obecnego widoku
//                new PojazdyListView(user); // Otwarcie kolejnego widoku
//            }
//        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.add(wlascicielLabel);
        panel.add(wlascicielTextField);
        panel.add(nazwaGospodarstwaLabel);
        panel.add(nazwaGospodarstwaTextField);
        panel.add(nipLabel);
        panel.add(nipTextField);
//        panel.add(pracownicyButton);
//        panel.add(polaButton);
//        panel.add(pojazdyButton);

        Menu menu = new Menu(user, this);
        setJMenuBar(menu);
        add(panel);
        setVisible(true);
    }
}
