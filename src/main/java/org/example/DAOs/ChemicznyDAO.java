package org.example.DAOs;

import org.example.Models.*;
import org.example.Services.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class ChemicznyDAO {
    public ChemicznyDAO() {
    }

    public void addChemiczny(Chemiczny chemiczny, List<Pracownik> pracownicy, Uprawa uprawa, List<Pojazd> pojazdy, Gospodarstwo gospodarstwo) {
        try {
            Session s = HibernateUtil.getSessionFactory().openSession();

            s.beginTransaction();
            s.save(chemiczny);
            chemiczny.getPracownicyWZabiegu().forEach((PracownikZabieg pz) ->{s.save(pz);});
            pracownicy.forEach((Pracownik p) ->{s.update(p);});
            pojazdy.forEach((Pojazd p) ->{s.update(p);});
            s.update(uprawa);
            s.update(gospodarstwo);
//            s.save(chemiczny.getPreparaty());
//            chemiczny.getPreparaty().forEach((String p) -> { s.save(p); });
            s.getTransaction().commit();
            s.close();

        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
}
