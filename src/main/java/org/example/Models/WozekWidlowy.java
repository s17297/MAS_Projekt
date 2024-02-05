package org.example.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class WozekWidlowy extends Pojazd implements IWozekWidlowy {
    @Id
    @GeneratedValue
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;

    private static double minWysokoscPodnoszenia = 3.2;

    private double wysokoscPodnoszenia;


    public WozekWidlowy() {}

    public void setWysokoscPodnoszenia(double wysokoscPodnoszenia) {
        this.wysokoscPodnoszenia = wysokoscPodnoszenia;
    }

    public WozekWidlowy(String marka, String model, Enum naped, double wysokoscPodnoszenia, Gospodarstwo gospodarstwo) {
        super(marka, model, naped, gospodarstwo);
        this.wysokoscPodnoszenia = wysokoscPodnoszenia;
        gospodarstwo.getPojazdy().add(this);
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

//    public static WozekWidlowy dodajPojazd(Gospodarstwo gospodarstwo, String marka, String model, Enum naped, double wysokoscPodnoszenia){
//        WozekWidlowy wozekWidlowy = new WozekWidlowy(marka, model, naped, wysokoscPodnoszenia);
//        wozekWidlowy.setGospodarstwo(gospodarstwo);
//        gospodarstwo.getPojazdy().add(wozekWidlowy);
//        return wozekWidlowy;
//    }


    @Override
    public String toString() {
        return super.toString() +
                "wysokoscPodnoszenia=" + wysokoscPodnoszenia ;
    }
}
