package org.example.Controller;

import org.example.DAOs.UprawowyDAO;
import org.example.Models.*;

import java.time.LocalDate;
import java.util.List;

public class UprawowyController {

    private UprawowyDAO uprawowyDAO = new UprawowyDAO();
    public UprawowyController() {
    }

    public void addUprawowy(List<Pracownik> pracownicy, List<Pojazd> pojazdy, Gospodarstwo gospodarstwo, Uprawa uprawa, LocalDate dataWykonania, String opis){
        Uprawowy uprawowy = Uprawowy.zlecZabieg(pracownicy, pojazdy, gospodarstwo, uprawa, dataWykonania, opis);
        uprawowyDAO.addUprawowy(uprawowy, pracownicy, uprawa, pojazdy, gospodarstwo);
    }

}
