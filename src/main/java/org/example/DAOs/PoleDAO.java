package org.example.DAOs;

import org.example.Models.Gospodarstwo;
import org.example.Models.Pole;
import org.example.Services.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class PoleDAO {
    public PoleDAO() {
    }

    public void addPole(Pole pole, Gospodarstwo gospodarstwo) {
        try {

        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
//        s.saveOrUpdate(gospodarstwo);
        s.update(gospodarstwo);
        s.save(pole);
        s.getTransaction().commit();
        s.close();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
    public Pole getPoleById(Long id){
        try {
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            var pole = s.get(Pole.class, id);
            s.getTransaction().commit();
            s.close();
            return pole;
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
}
