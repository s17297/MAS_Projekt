package org.example.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PracownikZabieg {

    @Id
    @GeneratedValue
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;

    private LocalDate dataOd;

    private LocalDate dataDo;

    @ManyToOne
    private Pracownik pracownik;

    @ManyToOne
    private Zabieg zabieg;

    public PracownikZabieg() {
    }

    private PracownikZabieg(Pracownik pracownik, Zabieg zabieg) {
        this.pracownik = pracownik;
        this.zabieg = zabieg;
    }

    public LocalDate getDataOd() {
        return dataOd;
    }

    public void setDataOd(LocalDate dataOd) {
        this.dataOd = dataOd;
    }

    public LocalDate getDataDo() {
        return dataDo;
    }

    public void setDataDo(LocalDate dataDo) {
        this.dataDo = dataDo;
    }

    public Pracownik getPracownik() {
        return pracownik;
    }

    public void setPracownik(Pracownik pracownik) {
        this.pracownik = pracownik;
    }

    public Zabieg getZabieg() {
        return zabieg;
    }

    public void setZabieg(Zabieg zabieg) {
        this.zabieg = zabieg;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public static void dodajPracownikZabieg(Pracownik pracownik, Zabieg zabieg){
        PracownikZabieg pz = new PracownikZabieg(pracownik, zabieg);
        pracownik.dodajZabieg(pz);
        zabieg.dodajPracownika(pz);
    }
}
