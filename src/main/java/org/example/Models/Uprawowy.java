package org.example.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Uprawowy extends Zabieg{
    @Id
    @GeneratedValue
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;

    private String opis;

    public Uprawowy() {}

    public Uprawowy(LocalDate dataWykonania, String opis) {
        super(dataWykonania);
        this.opis = opis;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
    public static Uprawowy zlecZabieg(List<Pracownik> pracownicy, List<Pojazd> pojazdy, Gospodarstwo gospodarstwo, Uprawa uprawa, LocalDate dataWykonania, String opis){
        Uprawowy zabieg = new Uprawowy(dataWykonania, opis);
        zabieg.help(zabieg, pracownicy, pojazdy, gospodarstwo, uprawa, dataWykonania);
        return zabieg;
    }
}
