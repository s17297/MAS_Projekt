package org.example.Models;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
public class Osoba {
    @Id
    @GeneratedValue
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;

    @Column(unique = true)
    private String login;

    private String imie;

    private String nazwisko;

    private LocalDate dataUrodzenia;

    private String adres;

    private String telefon;

    private String pesel;

    private String email;

    private LocalDate dataUtworzeniaKonta;

    @OneToOne(orphanRemoval = true)
    @Nullable
    private Rolnik rolnik = null;

    @OneToOne
    @Nullable
    private Pracownik pracownik = null;

    public Osoba() {

    }

    public Osoba(String login, String imie, String nazwisko, LocalDate dataUrodzenia, String adres, String telefon, String pesel, String email) {
        this.login=login;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = dataUrodzenia;
        this.adres = adres;
        this.telefon = telefon;
        this.pesel = pesel;
        this.email = email;
        this.dataUtworzeniaKonta = LocalDate.now();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Transient
    public int getWiek(){
        return Period.between(getDataUrodzenia(), LocalDate.now()).getYears();
    }

    public Rolnik getRolnik() {
        return rolnik;
    }

    public void setRolnik(Rolnik rolnik) {
        this.rolnik = rolnik;
    }

    public Pracownik getPracownik() {
        return pracownik;
    }

    public void setPracownik(Pracownik pracownik) {
        this.pracownik = pracownik;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public LocalDate getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(LocalDate dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataUtworzeniaKonta() {
        return dataUtworzeniaKonta;
    }

    public void setDataUtworzeniaKonta(LocalDate dataUtworzeniaKonta) {
        this.dataUtworzeniaKonta = dataUtworzeniaKonta;
    }

    @Override
    public String toString() {
        return
                ", login='" + login + '\'' +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", dataUrodzenia=" + dataUrodzenia +
                ", adres='" + adres + '\'' +
                ", telefon='" + telefon + '\'' +
                ", pesel='" + pesel + '\'' +
                ", email='" + email + '\'' +
                ", dataUtworzeniaKonta=" + dataUtworzeniaKonta +
                ", pracownik=" + pracownik;
    }

}
