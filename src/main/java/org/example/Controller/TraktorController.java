package org.example.Controller;

import org.example.DAOs.TraktorDAO;
import org.example.Models.Gospodarstwo;
import org.example.Models.Traktor;

public class TraktorController {
    public TraktorController() {
    }
    private TraktorDAO traktorDAO = new TraktorDAO();

    public void addTraktor(String marka, String model, Enum naped, String numerRejestracyjny, double moc, Gospodarstwo gospodarstwo){
        Traktor traktor = new Traktor(marka, model, naped, numerRejestracyjny, moc, gospodarstwo);
        traktorDAO.addTraktor(traktor, gospodarstwo);
    }

    public Traktor getTraktorById(Long id){
        return traktorDAO.getTraktorById(id);
    }

}
