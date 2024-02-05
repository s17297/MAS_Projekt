package org.example.DAOs;

import org.example.Models.Gospodarstwo;
import org.example.Models.Ladowarka;
import org.example.Services.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class LadowarkaDAO {
    public LadowarkaDAO() {
    }

    public void addLadowarka(Ladowarka ladowarka, Gospodarstwo gospodarstwo) {
        try {
            Session s = HibernateUtil.getSessionFactory().openSession();

            s.beginTransaction();
            s.save(ladowarka);
            s.update(gospodarstwo);
            s.getTransaction().commit();
            s.close();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    public Ladowarka getLadowarkaById(Long id) {
        try {
            Session s = HibernateUtil.getSessionFactory().openSession();
            return s.get(Ladowarka.class, id);
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
}
