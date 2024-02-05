package org.example.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ladowarka extends Traktor implements IWozekWidlowy {
    @Id
    @GeneratedValue
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;

    private double zasiegTeleskopu;

    private double wysokoscPodnoszenia;
    private static double minWysokoscPodnoszenia = 3.2;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Ladowarka () {}

    public Ladowarka(String marka, String model, Enum naped, String numerRejestracyjny, double moc, Gospodarstwo gospodarstwo, double zasiegTeleskopu, double wysokoscPodnoszenia) {
        super(marka, model, naped, numerRejestracyjny, moc, gospodarstwo);
        this.zasiegTeleskopu = zasiegTeleskopu;
        this.wysokoscPodnoszenia = wysokoscPodnoszenia;
        gospodarstwo.getPojazdy().add(this);
    }

    @Override
    public double getWysokoscPodnoszenia() {
        return 0;
    }

//    @Override
//    public void dodajPojazd() {
//
//    }

    @Override
    public void usunPojazd() {

    }

    @Override
    public void wyswietlPojazdy() {

    }

}
