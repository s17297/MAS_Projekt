package org.example.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Traktor extends Pojazd {
    @Id
    @GeneratedValue
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;

    private String numerRejestracyjny;

    private double moc;


    public Traktor() {}

    public Traktor(String marka, String model, Enum naped, String numerRejestracyjny, double moc, Gospodarstwo gospodarstwo) {
        super(marka, model, naped, gospodarstwo);
        this.numerRejestracyjny = numerRejestracyjny;
        this.moc = moc;
        gospodarstwo.getPojazdy().add(this);
    }


    public String getNumerRejestracyjny() {
        return numerRejestracyjny;
    }

    public void setNumerRejestracyjny(String numerRejestracyjny) {
        this.numerRejestracyjny = numerRejestracyjny;
    }

    public double getMoc() {
        return moc;
    }

    public void setMoc(double moc) {
        this.moc = moc;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

//    public static Traktor dodajPojazd(Gospodarstwo gospodarstwo, String marka, String model, Enum naped, String numerRejestracyjny, double moc){
//        Traktor pojazd = new Traktor(marka, model, naped, numerRejestracyjny, moc);
//        gospodarstwo.getPojazdy().add(pojazd);
//        pojazd.setGospodarstwo(gospodarstwo);
//        return pojazd;
//    }


    @Override
    public String toString() {
        return super.toString()+
                "numerRejestracyjny='" + numerRejestracyjny + '\'' +
                ", moc=" + moc
                ;
    }
}
