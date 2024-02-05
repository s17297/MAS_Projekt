package org.example.Controller;

import org.example.DAOs.WozekWidlowyDAO;
import org.example.Models.Gospodarstwo;
import org.example.Models.WozekWidlowy;

public class WozekWidlowyController {

    private WozekWidlowyDAO wozekWidlowyDAO = new WozekWidlowyDAO();
    public WozekWidlowyController() {
    }

    public void addWozekWidlowy(String marka, String model, Enum naped, double wysokoscPodnoszenia, Gospodarstwo gospodarstwo){
        WozekWidlowy wozekWidlowy = new WozekWidlowy(marka, model, naped, wysokoscPodnoszenia, gospodarstwo);
        wozekWidlowyDAO.addWozekWidlowy(wozekWidlowy, gospodarstwo);
    }

    public WozekWidlowy getWozekWidlowyById(Long id){
        return wozekWidlowyDAO.getWozekWidlowyById(id);
    }

}
