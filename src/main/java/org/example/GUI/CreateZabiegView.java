package org.example.GUI;

import org.example.Controller.ChemicznyController;
import org.example.Controller.GospodarstwoController;
import org.example.Controller.PomocniczyController;
import org.example.Controller.UprawowyController;
import org.example.Models.Pojazd;
import org.example.Models.Pracownik;
import org.example.Models.Rolnik;
import org.example.Models.Uprawa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;

public class CreateZabiegView extends JFrame {

    public CreateZabiegView(Rolnik rolnik, Uprawa uprawa){

        setTitle("Formularz zabiegu");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLayout(new GridLayout(4, 2));

        JPanel panel = new JPanel();

        JLabel rodzajZabieguLabel = new JLabel("Rodzaj zabiegu");

        String[] rodzajeZabiegow = {"Pomocniczy", "Chemiczny", "Uprawowy"};
        JComboBox<String> rodzajZabieguComboBox = new JComboBox<>(rodzajeZabiegow);

        JLabel dataWykonaniaLabel = new JLabel("Data wykonania");
        JTextField dataWykonaniaTextField = new JTextField();

        JLabel pracownicyLabel = new JLabel("Dostępni pracownicy");

        DefaultListModel<Pracownik> pracownicyListModel = new DefaultListModel<>();
        rolnik.getGospodarstwo().getListaPracownikow().forEach((keys, values) ->{
            pracownicyListModel.addElement(values);
        });
        JList<Pracownik> pracownicyList = new JList<>(pracownicyListModel);
        pracownicyList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane pracownicyScrollPane = new JScrollPane(pracownicyList);

        JLabel pojazdyLabel = new JLabel("Dostępne pojazdy");


        DefaultListModel<Pojazd> pojazdyListModel = new DefaultListModel<>();
        rolnik.getGospodarstwo().getPojazdy().forEach((Pojazd p) ->{
            pojazdyListModel.addElement(p);
        });

        JList<Pojazd> pojazdyList = new JList<>(pojazdyListModel);
        pojazdyList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane pojazdyScrollPane = new JScrollPane(pojazdyList);

        JLabel opisLabel = new JLabel("Opis");
        JTextArea opisTextArea = new JTextArea();

        JLabel preparatyLabel = new JLabel("preparaty");
        JTextField preparatTextField = new JTextField();
        DefaultListModel<String> preparatyListModel = new DefaultListModel<>();
        JList<String> preparatyList = new JList<>(preparatyListModel);
        JScrollPane preparatyScrollPane = new JScrollPane(preparatyList);

        JButton dodajPreparatButton = new JButton("Dodaj preparat do listy");

        dodajPreparatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                preparatyListModel.addElement(preparatTextField.getText());
                preparatTextField.setText("");
                preparatyScrollPane.repaint();
            }
        });

//        JPanel chemicznyPanel = new JPanel();
//        chemicznyPanel.add(preparatyLabel);
//        chemicznyPanel.add(preparatTextField);
//        chemicznyPanel.add(preparatyScrollPane);
//        chemicznyPanel.add(dodajPreparatButton);


        JButton dodajZabiegButton = new JButton("Zleć zabieg");
        dodajZabiegButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String wybranyRodzaj = (String) rodzajZabieguComboBox.getSelectedItem();
                if(wybranyRodzaj.equals("Chemiczny")){
                    preparatyList.setSelectionInterval(0, preparatyList.getModel().getSize() - 1);

                    ChemicznyController chemicznyController = new ChemicznyController();
                    chemicznyController.addChemiczny(pracownicyList.getSelectedValuesList(), pojazdyList.getSelectedValuesList(), rolnik.getGospodarstwo(), uprawa, LocalDate.parse(dataWykonaniaTextField.getText()), preparatyList.getSelectedValuesList());
                } else if (wybranyRodzaj.equals("Uprawowy")) {
                    UprawowyController uprawowyController = new UprawowyController();
                    uprawowyController.addUprawowy(pracownicyList.getSelectedValuesList(), pojazdyList.getSelectedValuesList(), rolnik.getGospodarstwo(), uprawa, LocalDate.parse(dataWykonaniaTextField.getText()), opisTextArea.getText());

                } else if (wybranyRodzaj.equals("Pomocniczy")) {
                    PomocniczyController pomocniczyController = new PomocniczyController();
                    pomocniczyController.addPomocniczy(pracownicyList.getSelectedValuesList(), pojazdyList.getSelectedValuesList(), rolnik.getGospodarstwo(), uprawa, LocalDate.parse(dataWykonaniaTextField.getText()));

                }

                };

        });

        rodzajZabieguComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String wybranyRodzaj = (String) rodzajZabieguComboBox.getSelectedItem();
                if(wybranyRodzaj.equals("Chemiczny")){
                    panel.remove(opisLabel);
                    panel.remove(opisTextArea);
                    panel.add(preparatyLabel);
                    panel.add(preparatTextField);
                    panel.add(preparatyScrollPane);
                    panel.add(dodajPreparatButton);
                    panel.setLayout(new GridLayout(7,2));
                } else if (wybranyRodzaj.equals("Uprawowy")) {
                    panel.remove(preparatyLabel);
                    panel.remove(preparatTextField);
                    panel.remove(preparatyScrollPane);
                    panel.remove(dodajPreparatButton);
                    panel.add(opisLabel);
                    panel.add(opisTextArea);
                    panel.setLayout(new GridLayout(6,2));

                } else if (wybranyRodzaj.equals("Pomocniczy")) {
                    panel.remove(preparatyLabel);
                    panel.remove(preparatTextField);
                    panel.remove(preparatyScrollPane);
                    panel.remove(dodajPreparatButton);
                    panel.remove(opisLabel);
                    panel.remove(opisTextArea);

                }
                revalidate();
            }
        });


        Menu menu = new Menu(rolnik, this);
        setJMenuBar(menu);
        add(panel);
        panel.setLayout(new GridLayout(5, 2));
        panel.add(rodzajZabieguLabel);
        panel.add(rodzajZabieguComboBox);
        panel.add(dataWykonaniaLabel);
        panel.add(dataWykonaniaTextField);
        panel.add(pracownicyLabel);
        panel.add(pracownicyScrollPane);
        panel.add(pojazdyLabel);
        panel.add(pojazdyScrollPane);
        panel.add(dodajZabiegButton);
        setVisible(true);

    }
}
