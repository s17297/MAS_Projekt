package org.example.Controller;

import org.example.DAOs.PracownikDAO;
import org.example.Models.Pracownik;
import org.example.Models.Rolnik;

import java.time.LocalDate;

public class PracownikController {
    private PracownikDAO pracownikDAO = new PracownikDAO();

    public PracownikController() {
    }

    public Pracownik getPracownikById(Long id){
        return pracownikDAO.getPracownikById(id);
    }

    public Pracownik getPracownikByPesel(String pesel){
        return pracownikDAO.getPracownikByPesel(pesel);
    }

    public void addPracownik(String login, String imie, String nazwisko, LocalDate dataUrodzenia, String adres, String telefon, String pesel, String email, String umiejetnosci){
        Pracownik pracownik = Pracownik.dodajPracownika(login, imie, nazwisko, dataUrodzenia, adres, telefon, pesel, email, umiejetnosci);
        pracownikDAO.addPracownik(pracownik);
    }

    public Pracownik getPracownikByLogin(String login) {
        return pracownikDAO.getPracownikByLogin(login);
    }
}
