package org.example.DAOs;

import org.example.Models.Osoba;
import org.example.Models.Pracownik;
import org.example.Models.Rolnik;
import org.example.Services.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class PracownikDAO {
    public void addPracownik(Pracownik pracownik){
        try {
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            s.save(pracownik.getOsoba());
            s.save(pracownik);
            s.getTransaction().commit();
            s.close();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    public Pracownik getPracownikById(Long id){
        Session s = HibernateUtil.getSessionFactory().openSession();
        Pracownik pracownik = s.get(Pracownik.class, id);
        s.close();
        return pracownik;

    }

    public Pracownik getPracownikByPesel(String pesel){
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query<Pracownik> query = s.createQuery("FROM Pracownik WHERE osoba.pesel = :pesel", Pracownik.class);
        Pracownik pracownik = query.getSingleResult();
        s.close();
        return pracownik;
    }

    public Pracownik getPracownikByLogin(String login) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query<Pracownik> query = s.createQuery("from Pracownik where osoba.login = :login", Pracownik.class);
        query.setParameter("login", login);
        Pracownik pracownik = query.getSingleResult();
        s.close();
        return pracownik;
    }

//    public Pracownik getPracownikById(Long id){
//        Session s = HibernateUtil.getSessionFactory().openSession();
//        Pracownik pracownik = s.get(Pracownik.class, id);
//        Osoba osoba = s.get(Osoba.class, pracownik.getOsoba().getId());
//        pracownik.setOsoba(osoba);
//        return pracownik;
//    }
}
