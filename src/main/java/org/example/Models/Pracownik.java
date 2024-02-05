package org.example.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pracownik extends Osoba {
    @Id
    @GeneratedValue
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;

    @OneToOne
    private Osoba osoba;

    private String umiejetnosci;

    @ManyToOne
    private Gospodarstwo gospodarstwo;

    @OneToMany
    private List<PracownikZabieg> zabiegi = new ArrayList<>();

    public Pracownik() {}

    private Pracownik(String umiejetnosci) {
        this.umiejetnosci = umiejetnosci;
    }

    public List<PracownikZabieg> getZabiegi() {
        return zabiegi;
    }

    public void setZabiegi(List<PracownikZabieg> zabiegi) {
        this.zabiegi = zabiegi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUmiejetnosci() {
        return umiejetnosci;
    }

    public void setUmiejetnosci(String umiejetnosci) {
        this.umiejetnosci = umiejetnosci;
    }

    public Gospodarstwo getGospodarstwo() {
        return gospodarstwo;
    }

    public void setGospodarstwo(Gospodarstwo gospodarstwo) {
        this.gospodarstwo = gospodarstwo;
    }

    public Osoba getOsoba() {
        return osoba;
    }

    public void setOsoba(Osoba osoba) {
        this.osoba = osoba;
    }

    @Override
    public String getImie() {
        return osoba.getImie();
    }

    public static Pracownik dodajPracownika(String login, String imie, String nazwisko, LocalDate dataUrodzenia, String adres, String telefon, String pesel, String email, String umiejetnosci){
        Osoba osoba = new Osoba(login, imie, nazwisko, dataUrodzenia, adres, telefon, pesel, email);
        Pracownik pracownik = new Pracownik(umiejetnosci);
        osoba.setPracownik(pracownik);
        pracownik.setOsoba(osoba);
        return pracownik;
    }

    public static Pracownik dodajPracownika(Osoba osoba, String umiejetnosci){
        Pracownik pracownik = new Pracownik(umiejetnosci);
        osoba.setPracownik(pracownik);
        pracownik.setOsoba(osoba);
        return pracownik;
    }

    public void dodajZabieg(PracownikZabieg pz){
        if(!getZabiegi().contains(pz)) {
            this.zabiegi.add(pz);
        }
    }
    @Override
    public String toString() {
//        super.toString();
        return "Pracownik:" +
                ", login='" + getOsoba().getLogin() + '\'' +
                ", imie='" + getOsoba().getImie() + '\'' +
                ", nazwisko='" + getOsoba().getNazwisko() + '\'' +
                ", dataUrodzenia=" + getOsoba().getDataUrodzenia() +
                ", adres='" + getOsoba().getAdres() + '\'' +
                ", telefon='" + getOsoba().getTelefon() + '\'' +
                ", pesel='" + getOsoba().getPesel() + '\'' +
                ", email='" + getOsoba().getEmail() + '\'' +
//                ", dataUtworzeniaKonta=" + getOsoba().getDataUtworzeniaKonta() +
                // Dodaj dodatkowe pola z klasy Pracownik
                ", umiejetnosci='" + getUmiejetnosci() + '\''
                ;
    }
}
