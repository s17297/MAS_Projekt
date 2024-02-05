package org.example.GUI;

import org.example.Models.Rolnik;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JMenuBar {
    JMenu menu = new JMenu("Menu");
    public Menu(Rolnik user, JFrame frame) {
        JMenuItem gospodarstwoMenuItem = new JMenuItem("Gospodarstwo");
        gospodarstwoMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Tu umieść kod akcji dla elementu "Gospodarstwo"
                frame.dispose();
                new GospodarstwoView(user);
            }
        });

        JMenuItem polaMenuItem = new JMenuItem("Pola");
        polaMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Tu umieść kod akcji dla elementu "Pola"
                frame.dispose();
                new PolaListView(user);
            }
        });

        JMenuItem pracownicyMenuItem = new JMenuItem("Pracownicy");
        pracownicyMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Tu umieść kod akcji dla elementu "Pracownicy"
                if(!user.getGospodarstwo().getListaPracownikow().isEmpty()) {
                    frame.dispose();
                    new PracownicyListView(user);
                }else{
                    frame.dispose();
                    new CreateEmploymentView(user);
                }
            }
        });

        JMenuItem pojazdyMenuItem = new JMenuItem("Pojazdy");
        pojazdyMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!user.getGospodarstwo().getPojazdy().isEmpty()){
                    frame.dispose();
                    new PojazdyListView(user);
                }else {
                    frame.dispose();
                    new CreatePojazdView(user);
                }

            }
        });

//        JMenu menu = new JMenu("Menu");
        menu.add(gospodarstwoMenuItem);
        menu.add(polaMenuItem);
        menu.add(pracownicyMenuItem);
        menu.add(pojazdyMenuItem);
        add(menu);
    }
}
