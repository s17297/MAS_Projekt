package org.example.DAOs;

import org.example.Models.Gospodarstwo;
import org.example.Models.Pracownik;
import org.example.Models.Rolnik;
import org.example.Services.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Map;

public class GospodarstwoDAO {
    public void addGospodarstwo(Gospodarstwo gospodarstwo, Rolnik rolnik){
        try {
        Session s = HibernateUtil.getSessionFactory().openSession();
            System.out.println("otwarcie sesji w gospodarstwoDao addgospodarstwo");

        s.beginTransaction();
        s.save(gospodarstwo);
        s.update(rolnik);
        s.getTransaction().commit();
        s.close();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    public Gospodarstwo getGospodarstwoById(Long id){
        try {
            Session s = HibernateUtil.getSessionFactory().openSession();
            System.out.println("otwarcie sesji w gospodarstwodao get gospodarstwo by id");

//            s.close();
            return s.get(Gospodarstwo.class, id);
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    public void zatrudnijPracownika(Pracownik pracownik, Gospodarstwo gospodarstwo){
        try {
            Session s = HibernateUtil.getSessionFactory().openSession();
            System.out.println("otwarcie sesji w gospodarstwodao zatrudnijbypesesl");

            s.beginTransaction();
            s.update(gospodarstwo);
            s.update(pracownik);
            s.getTransaction().commit();
            s.close();
        } catch (HibernateException e) {
            throw new RuntimeException("Błąd podczas zatrudniania pracownika: " + e.getMessage(), e);
        }
    }

//    public List<Pracownik> getZatrudnieniPracownicy(Gospodarstwo gospodarstwo){
//        Session s = HibernateUtil.getSessionFactory().openSession();
//        Map<String, Pracownik> pracownicy = gospodarstwo.getListaPracownikow();
//        return s.get(Pracownik.class, gospodarstwo.getListaPracownikow().)
//    }
}
