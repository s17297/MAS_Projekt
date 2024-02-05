package org.example.Controller;

import org.example.DAOs.PomocniczyDAO;
import org.example.Models.*;

import java.time.LocalDate;
import java.util.List;

public class PomocniczyController {

    private PomocniczyDAO pomocniczyDAO = new PomocniczyDAO();
    public PomocniczyController() {
    }

    public void addPomocniczy(List<Pracownik> pracownicy, List<Pojazd> pojazdy, Gospodarstwo gospodarstwo, Uprawa uprawa, LocalDate dataWykonania){
        Pomocniczy pomocniczy = Pomocniczy.zlecZabieg(pracownicy, pojazdy, gospodarstwo, uprawa, dataWykonania);
        pomocniczyDAO.addPomocniczy(pomocniczy, pracownicy, uprawa, pojazdy, gospodarstwo);
    }

//    public Pomocniczy getPomocniczyById(id)

}
