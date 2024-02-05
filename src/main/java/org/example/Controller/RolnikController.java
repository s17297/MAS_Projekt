package org.example.Controller;

import org.example.DAOs.RolnikDAO;
import org.example.Models.Rolnik;
import org.hibernate.Session;

import java.time.LocalDate;

public class RolnikController {

    public RolnikController(){}
    private RolnikDAO rolnikDAO = new RolnikDAO();

    public Rolnik getRolnikById(Long id){
        return rolnikDAO.getRolnikById(id);
    }

    public Rolnik getRolnikByLogin(String login){
        return rolnikDAO.getRolnikByLogin(login);
    }

    public void addRolnik(String login, String imie, String nazwisko, LocalDate dataUrodzenia, String adres, String telefon, String pesel, String email, String wyksztalcenie){
        Rolnik rolnik = Rolnik.dodajRolnika(login, imie, nazwisko, dataUrodzenia, adres, telefon, pesel, email, wyksztalcenie);
        rolnikDAO.addRolnik(rolnik);
    }

}
