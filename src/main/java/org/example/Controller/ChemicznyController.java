package org.example.Controller;

import org.example.DAOs.ChemicznyDAO;
import org.example.Models.*;

import java.time.LocalDate;
import java.util.List;

public class ChemicznyController {

    private ChemicznyDAO chemicznyDAO = new ChemicznyDAO();
    public ChemicznyController() {
    }

    public void addChemiczny(List<Pracownik> pracownicy, List<Pojazd> pojazdy, Gospodarstwo gospodarstwo, Uprawa uprawa, LocalDate dataWykonania, List<String> preparaty){
        Chemiczny chemiczny = Chemiczny.zlecZabieg(pracownicy, pojazdy, gospodarstwo, uprawa, dataWykonania, preparaty);
        chemicznyDAO.addChemiczny(chemiczny, pracownicy, uprawa, pojazdy, gospodarstwo);
    }

}
