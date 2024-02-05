package org.example.GUI;

import org.example.Models.Pole;
import org.example.Models.Rolnik;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

class PolaListView extends JFrame {
    private Rolnik user;

    public PolaListView(Rolnik user) {
        this.user = user;

        setTitle("Lista pól użytkownika: " + user.getOsoba().getLogin());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        List<Pole> pola = user.getGospodarstwo().getPola();

        if (pola.isEmpty()) {
            // Jeśli lista pól jest pusta, przejdź do widoku tworzenia pola
            dispose(); // Zamknięcie obecnego widoku
            new CreatePoleView(user); // Otwarcie widoku tworzenia pola
        } else {
            // Jeśli lista pól nie jest pusta, wyświetl listę pól użytkownika
            DefaultListModel<Pole> fieldsListModel = new DefaultListModel<>();
            JList<Pole> fieldsList = new JList<>(fieldsListModel);
            JScrollPane scrollPane = new JScrollPane(fieldsList);

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(2, 1));
            panel.add(scrollPane);

//            JMenuBar menuBar = new JMenuBar();
//            JMenuItem toGospodarstwo = new JMenuItem("gospodarstwo");
//            menuBar.add(toGospodarstwo);
//
//            toGospodarstwo.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    dispose();
//                    new GospodarstwoView(user);
//                }
//            });

            for (Pole pole : pola) {
                fieldsListModel.addElement(pole);
            }

            fieldsList.addListSelectionListener(e -> {

                    Pole selectedPole = fieldsList.getSelectedValue();

                        if (selectedPole.getUprawy().isEmpty()) {
                            // Jeśli pole nie posiada upraw, przejdź do widoku tworzenia uprawy dla tego pola
                            dispose(); // Zamknięcie obecnego widoku
                            new CreateUprawaView(user, selectedPole); // Otwarcie widoku tworzenia uprawy dla wybranego pola
                        } else {
                            // Jeśli pole posiada uprawy, wyświetl listę upraw
                            dispose(); // Zamknięcie obecnego widoku
                            new UprawyListView(user, selectedPole); // Otwarcie widoku "upraw"
                        }

            });

            JButton dodajPoleButton = new JButton("Dodaj pole");
            dodajPoleButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new CreatePoleView(user);
                }
            });
            panel.add(dodajPoleButton);
            Menu menu = new Menu(user, this);
            setJMenuBar(menu);
            add(panel);
            setVisible(true);
        }
    }
}
