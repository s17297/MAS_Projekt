package org.example.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pole {
    @Id
    @GeneratedValue
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;

    private String nazwa;

    private String numerDzialki;

    private double powierzchnia;

    @OneToMany
    private List<Uprawa> uprawy = new ArrayList<>();

    @ManyToOne
    private Gospodarstwo gospodarstwo;

    public Pole () {}
    private Pole(String nazwa, String numerDzialki, double powierzchnia) {
        this.nazwa = nazwa;
        this.numerDzialki = numerDzialki;
        this.powierzchnia = powierzchnia;
    }

    public List<Uprawa> getUprawy() {
        return uprawy;
    }

    public void setUprawy(List<Uprawa> uprawy) {
        this.uprawy = uprawy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNumerDzialki() {
        return numerDzialki;
    }

    public void setNumerDzialki(String numerDzialki) {
        this.numerDzialki = numerDzialki;
    }

    public double getPowierzchnia() {
        return powierzchnia;
    }

    public void setPowierzchnia(double powierzchnia) {
        this.powierzchnia = powierzchnia;
    }

    public Gospodarstwo getGospodarstwo() {
        return gospodarstwo;
    }

    public void setGospodarstwo(Gospodarstwo gospodarstwo) {
        this.gospodarstwo = gospodarstwo;
    }

    public static Pole dodajPole(String nazwa, String numerDzialki, double powierzchnia, Gospodarstwo gospodarstwo){
        Pole pole = new Pole(nazwa, numerDzialki, powierzchnia);
        pole.setGospodarstwo(gospodarstwo);
        gospodarstwo.getPola().add(pole);
        return pole;
    }

    public void dodajUprawe(Uprawa uprawa){
        if(!getUprawy().contains(uprawa)){
            getUprawy().add(uprawa);
        }
    }

    @Override
    public String toString() {
        return
                "nazwa='" + nazwa + '\'' +
                ", numerDzialki='" + numerDzialki + '\'' +
                ", powierzchnia=" + powierzchnia ;

    }
}
