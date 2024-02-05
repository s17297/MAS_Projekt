package org.example.GUI;

import org.example.Controller.LadowarkaController;
import org.example.Controller.TraktorController;
import org.example.Controller.WozekWidlowyController;
import org.example.Models.Pojazd;
import org.example.Models.Rolnik;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CreatePojazdView extends JFrame {

    //            private JPanel wozekPanel;
//            private JPanel ladowarkaPanel;
    public CreatePojazdView(Rolnik rolnik) {


        setTitle("Formularz Pojazdu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLayout(new GridLayout(1, 1));
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();

        JLabel rodzajPojazduLabel = new JLabel("Rodzaj Pojazdu:");
        String[] rodzajePojazdow = {"Traktor", "Wózek widłowy", "Ładowarka"};
        JComboBox<String> rodzajPojazduComboBox = new JComboBox<>(rodzajePojazdow);
//                rodzajPojazduComboBox.setSelectedItem("Traktor");

//                traktorPanel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));

        JLabel modelLabel = new JLabel("Model");
        JTextField modelTextField = new JTextField();
        JLabel markaLabel = new JLabel("Marka");
        JTextField markaTextField = new JTextField();
        JLabel napedLabel = new JLabel("Napęd");
        JComboBox<Pojazd.napedy> napedComboBox = new JComboBox<>(Pojazd.napedy.values());

        JLabel numerRejestracyjnyLabel = new JLabel("Numer Rejestracyjny");
        JTextField numerRejestracyjnyTextField = new JTextField();

        JLabel mocLabel = new JLabel("Moc:");
        JTextField mocTextField = new JTextField();

        JLabel wysokoscPodnoszeniaLabel = new JLabel("Wysokosc podnoszenia");
        JTextField wysokoscPodnoszeniaTextField = new JTextField();

        JLabel zasiegTeleskopuLabel = new JLabel("Zasięg teleskopu");
        JTextField zasiegTeleskopuTextField = new JTextField();

        JButton dodajPojazdButton = new JButton("dodaj pojazd");

        panel.add(rodzajPojazduLabel);
        panel.add(rodzajPojazduComboBox);
        panel.add(modelLabel);
        panel.add(modelTextField);
        panel.add(markaLabel);
        panel.add(markaTextField);
        panel.add(napedLabel);
        panel.add(napedComboBox);
        panel.add(mocLabel);
        panel.add(mocTextField);
        panel.add(numerRejestracyjnyLabel);
        panel.add(numerRejestracyjnyTextField);
        panel.add(dodajPojazdButton, BorderLayout.SOUTH);


        rodzajPojazduComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String wybranyRodzaj = (String) rodzajPojazduComboBox.getSelectedItem();
                if (wybranyRodzaj.equals("Traktor")) {
                    panel.remove(zasiegTeleskopuLabel);
                    panel.remove(zasiegTeleskopuTextField);
                    panel.remove(wysokoscPodnoszeniaLabel);
                    panel.remove(wysokoscPodnoszeniaTextField);
//                            panel.repaint();
                    panel.add(mocLabel);
                    panel.add(mocTextField);
                    panel.add(numerRejestracyjnyLabel);
                    panel.add(numerRejestracyjnyTextField);
                    panel.setLayout(new GridLayout(7, 2));
//                            panel.repaint();

                } else if (wybranyRodzaj.equals("Ładowarka")) {
//                            panel.repaint();
                    panel.add(zasiegTeleskopuLabel);
                    panel.add(zasiegTeleskopuTextField);
                    panel.add(wysokoscPodnoszeniaLabel);
                    panel.add(wysokoscPodnoszeniaTextField);
                    panel.add(mocLabel);
                    panel.add(mocTextField);
                    panel.add(numerRejestracyjnyLabel);
                    panel.add(numerRejestracyjnyTextField);
                    panel.setLayout(new GridLayout(9, 2));
//                            panel.repaint();

                } else if (wybranyRodzaj.equals("Wózek widłowy")) {
                    panel.remove(mocLabel);
                    panel.remove(mocTextField);
                    panel.remove(numerRejestracyjnyLabel);
                    panel.remove(numerRejestracyjnyTextField);
                    panel.remove(zasiegTeleskopuLabel);
                    panel.remove(zasiegTeleskopuTextField);
//                            panel.repaint();
                    panel.add(wysokoscPodnoszeniaLabel);
                    panel.add(wysokoscPodnoszeniaTextField);
                    panel.setLayout(new GridLayout(6, 2));
//                            panel.repaint();

                }
                panel.revalidate();

            }
        });

        Menu menu = new Menu(rolnik, this);
        setJMenuBar(menu);

        add(panel);
        setVisible(true);


        dodajPojazdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String wybranyRodzaj = (String) rodzajPojazduComboBox.getSelectedItem();

                if (wybranyRodzaj.equals("Traktor")) {
                    TraktorController traktorController = new TraktorController();
                    traktorController.addTraktor(markaTextField.getText(), modelTextField.getText(), (Pojazd.napedy)napedComboBox.getSelectedItem(), numerRejestracyjnyTextField.getText(), Double.parseDouble(mocTextField.getText()), rolnik.getGospodarstwo());
                } else if (wybranyRodzaj.equals("Wózek widłowy")) {
                    WozekWidlowyController wozekWidlowyController = new WozekWidlowyController();
                    wozekWidlowyController.addWozekWidlowy(markaTextField.getText(), modelTextField.getText(), (Pojazd.napedy)napedComboBox.getSelectedItem(), Double.parseDouble(wysokoscPodnoszeniaTextField.getText()), rolnik.getGospodarstwo());
                } else if (wybranyRodzaj.equals("Ładowarka")) {
                    LadowarkaController ladowarkaController = new LadowarkaController();
                    ladowarkaController.addLadowarka(markaTextField.getText(), modelTextField.getText(), (Pojazd.napedy)napedComboBox.getSelectedItem(), numerRejestracyjnyTextField.getText(), Double.parseDouble(mocTextField.getText()), rolnik.getGospodarstwo(), Double.parseDouble(zasiegTeleskopuTextField.getText()), Double.parseDouble(wysokoscPodnoszeniaTextField.getText()));

                }
                dispose();
                new PojazdyListView(rolnik);
            }
        });


    }
}



