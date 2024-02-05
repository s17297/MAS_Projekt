package org.example.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Entity
public class Gospodarstwo {
    @Id
    @GeneratedValue
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;

    private String adres;

    private String nip;

    private String nazwa;
    @OneToMany
    private Map<String, Pracownik> listaPracownikow = new TreeMap<>();

    @OneToOne(orphanRemoval = true)
    private Rolnik rolnik;

    @OneToMany
    private List<Zabieg> zabiegi = new ArrayList<>();

    @OneToMany
    private List<Pole> pola = new ArrayList<>();

    @OneToMany
    private List<Pojazd> pojazdy = new ArrayList<>();

public Gospodarstwo() {}

    private Gospodarstwo(String adres, String nip, String nazwa) {
        this.adres = adres;
        this.nip = nip;
        this.nazwa = nazwa;
    }



    public List<Pojazd> getPojazdy() {
        return pojazdy;
    }

    public void setPojazdy(List<Pojazd> pojazdy) {
        this.pojazdy = pojazdy;
    }

    public List<Pole> getPola() {
        return pola;
    }

    public void setPola(List<Pole> pola) {
        this.pola = pola;
    }

    public Map<String, Pracownik> getListaPracownikow() {
        return listaPracownikow;
    }

    public void setListaPracownikow(Map<String, Pracownik> listaPracownikow) {
        this.listaPracownikow = listaPracownikow;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Rolnik getRolnik() {
        return rolnik;
    }

    public void setRolnik(Rolnik rolnik) {
        this.rolnik = rolnik;
    }

    public List<Zabieg> getZabiegi() {
        return zabiegi;
    }

    public void setZabiegi(List<Zabieg> zabiegi) {
        this.zabiegi = zabiegi;
    }

    public static Gospodarstwo stworzGospodarstwo(String adres, String nip, String nazwa, Rolnik rolnik){
        Gospodarstwo gospodarstwo = new Gospodarstwo(adres, nip, nazwa);
        gospodarstwo.setRolnik(rolnik);
        rolnik.setGospodarstwo(gospodarstwo);
        return gospodarstwo;
    }

    public void zatrudnijPracownika(Pracownik pracownik){
//    if(listaPracownikow != null)
        if(!listaPracownikow.containsKey(pracownik.getOsoba().getPesel())){
            listaPracownikow.put(pracownik.getOsoba().getPesel(), pracownik);
            pracownik.setGospodarstwo(this);
        }
    }

//    public void dodajZabieg
}
