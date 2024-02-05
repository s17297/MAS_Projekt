package org.example;

import org.example.Controller.*;
//import org.example.GUI.LoginScreen;
import org.example.GUI.ChooseRoleView;
import org.example.GUI.RolnikLogView;

import javax.swing.*;

public class Main {
//        private JFrame jFrame=new JFrame();
//        private JPanel contentPane;
//    public Main(){
//            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            jFrame.setBounds(100, 100, 837, 426);
//            jFrame.setVisible(true);
//        }
    public static void main(String[] args) {
//
//new Main();
        SwingUtilities.invokeLater(ChooseRoleView::new);

        RolnikController rolnikController = new RolnikController();
        GospodarstwoController gospodarstwoController = new GospodarstwoController();
        PoleController poleController = new PoleController();
        UprawaController uprawaController = new UprawaController();
        TraktorController traktorController = new TraktorController();
        PracownikController pracownikController = new PracownikController();
        ChemicznyController chemicznyController = new ChemicznyController();

//        Rolnik rolnik = rolnikController.getRolnikByLogin("testUser");
//        System.out.println(rolnik.getOsoba().getNazwisko());
//        ChemicznyController chemicznyController = new ChemicznyController();
//        ArrayList<String> strings = new ArrayList<>();
//        strings.add("afalon");
//        Gospodarstwo g = gospodarstwoController.getGospodarstwoById((long)9);
//        PracownikController pracownikController = new PracownikController();
//        System.out.println(pracownikController.getPracownikById((long)14).getOsoba().getNazwisko());
//        poleController.addPole("pierwsze pole", "22a", 3222.2, rolnik.getGospodarstwo());
//        poleController.addPole("drugie pole", "22b", 4222.2, rolnik.getGospodarstwo());
//        poleController.addPole("trzecie pole", "22a", 2222.2, rolnik.getGospodarstwo());
//            var pole = poleController.getPoleById((long)4);
//        uprawaController.addUprawa("ziemniaki", LocalDate.now(), pole);
//        uprawaController.addUprawa("pszenica", LocalDate.now(), pole);
//        uprawaController.addUprawa("groch", LocalDate.now(), pole);
////        System.out.println(g.getListaPracownikow());

//        traktorController.addTraktor("same", "explorer", null, "wzy", 44.6, rolnik.getGospodarstwo());
//        chemicznyController.addChemiczny(null, null, g, null, null, strings);

//        rolnikController.addRolnik("testUser", "Adam", "Kowalski", LocalDate.now(), "kuklowka", "555222555", "pesel", "s@o2.pl", "wyzsze");
//        gospodarstwoController.addGospodarstwo("kuklowka 35", "nip", "ziemniaki jadalne niedzinski", rolnik);
//        poleController.addPole("pierwsze pole", "22a", 3222.2, rolnik.getGospodarstwo());
//        System.out.println(poleController.getPoleById(rolnik.getGospodarstwo().getPola().get(0).getId()));
//        System.out.println(poleController.getPoleById((long)107).getGospodarstwo().getRolnik().getOsoba().getImie());

//        Rolnik r = Rolnik.dodajRolnika("Adam", "Kowalski", LocalDate.now(), "kuklowka", "555222555", "pesel", "s@o2.pl", "wyzsze");
//        System.out.println(r.getImie());
//        RolnikController rolnikController = new RolnikController();

//        rolnikController.addRolnik(r);

//        Rolnik r2 = rolnikController.getRolnikById(r.getId());

//        System.out.println(r2.getImie());
//
//        Gospodarstwo g = Gospodarstwo.stworzGospodarstwo("kuklowka 35", "nip", "ziemniaki jadalne niedzinski", r2);
//
//        GospodarstwoController gospodarstwoController = new GospodarstwoController();
//
//        gospodarstwoController.addGospodarstwo(g);

//        gospodarstwoController.zatrudnijPracownikaByPesel("pesel122", g);
//
//        System.out.println(
//        gospodarstwoController.getGospodarstwoByRolnik(r2).getNip()
//        );
//
//        Pracownik pr = Pracownik.dodajPracownika("Maciej", "Niedzinski", LocalDate.now(), "adres", "telefon", "pesel122", "email", "umiejetnosci");
//
//        PracownikController pracownikController = new PracownikController();
//
//        pracownikController.addPracownik(pr);
//        System.out.println(pr.getOsoba().getImie());
//        System.out.println(pracownikController.getPracownikById(pr.getId()).getImie());




//        Session session = HibernateUtil.getSessionFactory().openSession();
//        RolnikController rolnikController = new RolnikController(session);
//        System.out.println("Hello world!");
////        Rolnik rr = new Rolnik("sss");
//        RolnikDAO rolnikDAO = new RolnikDAO();
//        rolnikDAO.addRolnik(r);
//        System.out.println(rolnikController.getRolnikById(Long.valueOf(2)).getWyksztalcenie());
//        HibernateUtil.getSessionFactory();
//        Pole p =  Pole.dodajPole("wiesio", "2b", 22.3, g);
////        Gospodarstwo g1 = Gospodarstwo.stworzGospodarstwo("kuklowka 35", "nip", "ziemniaki jadalne niedzinski", null);
//        g.getPola().forEach((Pole s) ->{
//            System.out.println(s.getNazwa());
//        });
//        g.zatrudnijPracownika(pr);
//        List<Pracownik> pracowniks = new ArrayList<>();
//        pracowniks.add(pr);
//        Pojazd pojazd = new Traktor();
//        List<Pojazd> pojazds = new ArrayList<>();
//        pojazds.add(pojazd);
//        List<String> preparats = new ArrayList<>();
//        preparats.add("Afalon");
//        Uprawa u = new Uprawa();
//        Chemiczny z = Chemiczny.zlecZabieg(pracowniks, pojazds, g, u, LocalDate.now(),preparats);
//        System.out.println(z.getStatus()+ " " + z.getPreparaty().get(0));
//        z.zmienStatus(Zabieg.statusy.WTRAKCIEWYKONANIA);
//        System.out.println(z.getStatus()+ " " + z.getPreparaty().get(0));
//    }

//    public static void main(String[] args) {
//        RolnikDAO rolnikDAO = new RolnikDAO();
//        Rolnik rolnik = rolnikDAO.getRolnikById(1);
//        SwingUtilities.invokeLater(LoginScreen::new);
    }
}





