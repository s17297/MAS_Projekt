package org.example.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Pomocniczy extends Zabieg{

    @Id
    @GeneratedValue
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;

    public Pomocniczy(){}

    public Pomocniczy(LocalDate dataWykonania) {
        super(dataWykonania);
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
    public static Pomocniczy zlecZabieg(List<Pracownik> pracownicy, List<Pojazd> pojazdy, Gospodarstwo gospodarstwo, Uprawa uprawa, LocalDate dataWykonania){
        Pomocniczy zabieg = new Pomocniczy(dataWykonania);
        zabieg.help(zabieg, pracownicy, pojazdy, gospodarstwo, uprawa, dataWykonania);
        return zabieg;
    }
}
