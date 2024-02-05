package org.example.Controller;

import org.example.DAOs.GospodarstwoDAO;
import org.example.DAOs.PoleDAO;
import org.example.Models.Gospodarstwo;
import org.example.Models.Pole;

public class PoleController {

    private PoleDAO poleDAO = new PoleDAO();
    public PoleController() {
    }
    public void addPole(String nazwa, String numerDzialki, double powierzchnia, Gospodarstwo gospodarstwo){
        Pole pole = Pole.dodajPole(nazwa, numerDzialki, powierzchnia, gospodarstwo);
        poleDAO.addPole(pole, gospodarstwo);
    }

    public Pole getPoleById(Long id){
        return poleDAO.getPoleById(id);
    }
}
