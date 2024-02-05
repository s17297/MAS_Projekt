package org.example.Models;

import com.sun.istack.Nullable;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Rolnik extends Osoba{

    @Id
    @GeneratedValue
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;

    private String wyksztalcenie;
    @OneToOne(orphanRemoval = true)
    @Nullable
    private Osoba osoba = null;

    @OneToOne(orphanRemoval = true)
    @Nullable
    private Gospodarstwo gospodarstwo = null;

    public Rolnik() {}

    private Rolnik(String wyksztalcenie) {

        this.wyksztalcenie = wyksztalcenie;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getImie() {
        return osoba.getImie();
    }

    public Osoba getOsoba() {
        return osoba;
    }

    public void setOsoba(Osoba osoba) {
        this.osoba = osoba;
    }


    public String getWyksztalcenie() {
        return wyksztalcenie;
    }

    public void setWyksztalcenie(String wyksztalcenie) {
        this.wyksztalcenie = wyksztalcenie;
    }

    public Gospodarstwo getGospodarstwo() {
        return gospodarstwo;
    }

    public void setGospodarstwo(Gospodarstwo gospodarstwo) {
        this.gospodarstwo = gospodarstwo;
    }

    public static Rolnik dodajRolnika(String login, String imie, String nazwisko, LocalDate dataUrodzenia, String adres, String telefon, String pesel, String email, String wyksztalcenie){
        Osoba osoba = new Osoba(login, imie, nazwisko, dataUrodzenia, adres, telefon, pesel, email);
        Rolnik rolnik = new Rolnik(wyksztalcenie);
        osoba.setRolnik(rolnik);
        rolnik.setOsoba(osoba);

        return rolnik;
    }
    public static Rolnik dodajRolnika(Osoba osoba, String wyksztalcenie){
        Rolnik rolnik = new Rolnik(wyksztalcenie);
        osoba.setRolnik(rolnik);
        rolnik.setOsoba(osoba);

        return rolnik;
    }

}
