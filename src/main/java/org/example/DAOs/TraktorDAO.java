package org.example.DAOs;

import org.example.Models.Gospodarstwo;
import org.example.Models.Traktor;
import org.example.Services.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class TraktorDAO {
    public TraktorDAO() {
    }

    public void addTraktor(Traktor traktor, Gospodarstwo gospodarstwo) {
        try {
            Session s = HibernateUtil.getSessionFactory().openSession();
            System.out.println("otwarcie sesji w traktorDao addtraktor");
            s.beginTransaction();
            s.save(traktor);
            s.update(gospodarstwo);
            s.getTransaction().commit();
            s.close();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
    public Traktor getTraktorById(Long id) {
        try {
            Session s = HibernateUtil.getSessionFactory().openSession();
//            s.close();
            return s.get(Traktor.class, id);
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
}
