package org.example.Controller;

import org.example.DAOs.UprawaDAO;
import org.example.Models.Pole;
import org.example.Models.Uprawa;

import java.time.LocalDate;

public class UprawaController {
    public UprawaController() {
    }
    private UprawaDAO uprawaDAO = new UprawaDAO();

    public void addUprawa(String roslina, LocalDate dataRozpoczecia, Pole pole){
        Uprawa uprawa = Uprawa.dodajUprawe(roslina, dataRozpoczecia, pole);
        uprawaDAO.addUprawa(uprawa, pole);
    }

    public Uprawa getUprawaById(Long id){
        return uprawaDAO.getUprawaById(id);
    }
}
