package org.example.DAOs;

import org.example.Models.Gospodarstwo;
import org.example.Models.WozekWidlowy;
import org.example.Services.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class WozekWidlowyDAO {
    public WozekWidlowyDAO() {
    }

    public void addWozekWidlowy(WozekWidlowy wozekWidlowy, Gospodarstwo gospodarstwo) {
        try {
            Session s = HibernateUtil.getSessionFactory().openSession();
            System.out.println("otwarcie sesji w wozekwidlowydao");

            s.beginTransaction();
            s.save(wozekWidlowy);
            s.update(gospodarstwo);
            s.getTransaction().commit();
            s.close();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    public WozekWidlowy getWozekWidlowyById(Long id) {
        try {
            Session s = HibernateUtil.getSessionFactory().openSession();
            var wozekWidlowy = s.get(WozekWidlowy.class, id);
            HibernateUtil.shutdown();
            return wozekWidlowy;
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
}
