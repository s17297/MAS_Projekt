package org.example.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public abstract class Pojazd {

    public enum napedy{FOURBYFOUR, FWD, RWD}

    @Id
    @GeneratedValue
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;

    private String marka;

    private String model;

    private Enum naped;

    @ManyToMany
    private List<Zabieg> zabiegi = new ArrayList<>();

    @ManyToOne
    private Gospodarstwo gospodarstwo;

    public Pojazd() {}

    public Pojazd(String marka, String model, Enum naped, Gospodarstwo gospodarstwo) {
        this.gospodarstwo = gospodarstwo;
        this.marka = marka;
        this.model = model;
        this.naped = naped;
    }

    public Gospodarstwo getGospodarstwo() {
        return gospodarstwo;
    }

    public void setGospodarstwo(Gospodarstwo gospodarstwo) {
        this.gospodarstwo = gospodarstwo;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Enum getNaped() {
        return naped;
    }

    public void setNaped(Enum naped) {
        this.naped = naped;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Zabieg> getZabiegi() {
        return zabiegi;
    }

    public void setZabiegi(List<Zabieg> zabiegi) {
        this.zabiegi = zabiegi;
    }

    public void dodajZabieg(Zabieg zabieg) {
        if (!this.getZabiegi().contains(zabieg)) {
            this.getZabiegi().add(zabieg);
        }
    }

    @Override
    public String toString() {
        return  "marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                ", naped=" + naped + '\'';

    }
}
