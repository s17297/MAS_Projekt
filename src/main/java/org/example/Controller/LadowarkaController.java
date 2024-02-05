package org.example.Controller;

import org.example.DAOs.LadowarkaDAO;
import org.example.Models.Gospodarstwo;
import org.example.Models.Ladowarka;

public class LadowarkaController {

    private LadowarkaDAO ladowarkaDAO = new LadowarkaDAO();
    public LadowarkaController() {
    }

    public void addLadowarka(String marka, String model, Enum naped, String numerRejestracyjny, double moc, Gospodarstwo gospodarstwo, double zasiegTeleskopu, double wysokoscPodnoszenia){
        Ladowarka ladowarka = new Ladowarka(marka, model, naped, numerRejestracyjny, moc, gospodarstwo, zasiegTeleskopu, wysokoscPodnoszenia);
        ladowarkaDAO.addLadowarka(ladowarka, gospodarstwo);
    }

    public Ladowarka getLadowarkaById(Long id){
        return ladowarkaDAO.getLadowarkaById(id);
    }

}
