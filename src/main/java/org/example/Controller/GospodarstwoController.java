package org.example.Controller;

import org.example.DAOs.GospodarstwoDAO;
import org.example.Models.Gospodarstwo;
import org.example.Models.Pracownik;
import org.example.Models.Rolnik;

public class GospodarstwoController {

    private GospodarstwoDAO gospodarstwoDAO = new GospodarstwoDAO();
    public GospodarstwoController() {
    }

    public Gospodarstwo getGospodarstwoById(Long id){
        return gospodarstwoDAO.getGospodarstwoById(id);
    }

    public Gospodarstwo getGospodarstwoByRolnik(Rolnik rolnik){
        Long gospodarstwoId = rolnik.getGospodarstwo().getId();
        return gospodarstwoDAO.getGospodarstwoById(gospodarstwoId);
    }

    public void addGospodarstwo(String adres, String nip, String nazwa, Rolnik rolnik){
        Gospodarstwo gospodarstwo = Gospodarstwo.stworzGospodarstwo(adres, nip, nazwa, rolnik);
        gospodarstwoDAO.addGospodarstwo(gospodarstwo, rolnik);
    }

    public void zatrudnijPracownikaByPesel(String pesel, Gospodarstwo gospodarstwo){
        PracownikController pracownikController = new PracownikController();
        Pracownik pracownik = pracownikController.getPracownikByPesel(pesel);
        gospodarstwo.zatrudnijPracownika(pracownik);
//        pracownik.setGospodarstwo(gospodarstwo);
        gospodarstwoDAO.zatrudnijPracownika(pracownik, gospodarstwo);
    }

    public void zatrudnijPracownikaByLogin(String login, Gospodarstwo gospodarstwo){
        PracownikController pracownikController = new PracownikController();
        Pracownik pracownik = pracownikController.getPracownikByLogin(login);
        gospodarstwo.zatrudnijPracownika(pracownik);
//        pracownik.setGospodarstwo(gospodarstwo);
        gospodarstwoDAO.zatrudnijPracownika(pracownik, gospodarstwo);
    }

}
