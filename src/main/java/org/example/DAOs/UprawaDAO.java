package org.example.DAOs;

import org.example.Models.Pole;
import org.example.Models.Uprawa;
import org.example.Services.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class UprawaDAO {
    public UprawaDAO() {
    }

    public void addUprawa(Uprawa uprawa, Pole pole) {
        try {
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            s.save(uprawa);
            s.update(pole);
            s.getTransaction().commit();
            s.close();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }


    public Uprawa getUprawaById(Long id) {
        try {
            Session s = HibernateUtil.getSessionFactory().openSession();
//            s.close();
            return s.get(Uprawa.class, id);
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
}
