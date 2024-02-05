package org.example.DAOs;

import org.example.Models.Rolnik;
import org.example.Services.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class RolnikDAO {
    public Rolnik getRolnikById(Long id){
        StandardServiceRegistry registry = null;
        SessionFactory sessionFactory = null;

        try {
            registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            var rolnik = session.get(Rolnik.class, id);


            session.getTransaction().commit();
            session.close();
            return  rolnik;
//        }



//        try{
//            Session s = HibernateUtil.getSessionFactory().openSession();
//            s.beginTransaction();
//            System.out.println("otwarcie sesji w getrolnikbyid");
//            var rolnik = s.get(Rolnik.class, id);
//            s.getTransaction().commit();
////            s.close();
////            HibernateUtil.shutdown();
//            return rolnik;
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

            public void addRolnik(Rolnik rolnik){
                try {
                    Session s = HibernateUtil.getSessionFactory().openSession();
                    s.beginTransaction();

                    // Sprawdzenie, czy istnieje już rolnik o danym loginie
                    Query query = s.createQuery("FROM Rolnik WHERE osoba.login = :login");
                    query.setParameter("login", rolnik.getOsoba().getLogin());
                    Rolnik existingRolnik = (Rolnik) query.uniqueResult();

                    if (existingRolnik != null) {
                        // Rolnik o podanym loginie już istnieje, więc nie dodajemy nowego
                        System.out.println("Rolnik o loginie " + rolnik.getOsoba().getLogin() + " już istnieje.");
                    } else {
//                         Dodanie nowego rolnika
                        s.save(rolnik.getOsoba());
                        s.save(rolnik);
                        s.getTransaction().commit();
                        System.out.println("Dodano nowego rolnika: " + rolnik);
                    }

                    s.close();
                } catch (HibernateException e) {
                    throw new RuntimeException(e);
                }
    }

    public Rolnik getRolnikByLogin(String login) {
        try {
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
//                    String hql = "FROM Rolnik WHERE login = :login";
            Query<Rolnik> query = s.createQuery("from Rolnik where osoba.login = :login", Rolnik.class);
            query.setParameter("login", login);
            var rolnik = query.uniqueResult();
            s.getTransaction().commit();
            s.close();
            return rolnik;
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
}
