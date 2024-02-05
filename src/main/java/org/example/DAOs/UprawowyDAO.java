package org.example.DAOs;

import org.example.Models.*;
import org.example.Services.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class UprawowyDAO {
    public UprawowyDAO() {
    }

    public void addUprawowy(Uprawowy uprawowy, List<Pracownik> pracownicy, Uprawa uprawa, List<Pojazd> pojazdy, Gospodarstwo gospodarstwo) {
        try {
            Session s = HibernateUtil.getSessionFactory().openSession();

            s.beginTransaction();
            s.save(uprawowy);
            uprawowy.getPracownicyWZabiegu().forEach((PracownikZabieg pz) ->{s.save(pz);});
            pracownicy.forEach((Pracownik p) ->{s.update(p);});
            pojazdy.forEach((Pojazd p) ->{s.update(p);});
            s.update(uprawa);
            s.update(gospodarstwo);
            s.getTransaction().commit();
            HibernateUtil.shutdown();

        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
}
