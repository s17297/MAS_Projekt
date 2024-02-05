package org.example.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Uprawa {
    @Id
    @GeneratedValue
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;

    private String roslina;

    private LocalDate dataRozpoczecia;

    private LocalDate dataZakonczenia;

    @ManyToOne
    private Pole pole;

    @OneToMany
    private List<Zabieg> zabiegi = new ArrayList<>();

    public Uprawa () {}

    private Uprawa(String roslina, LocalDate dataRozpoczecia) {
        this.roslina = roslina;
        this.dataRozpoczecia = dataRozpoczecia;
    }

    public Pole getPole() {
        return pole;
    }

    public void setPole(Pole pole) {
        this.pole = pole;
    }

    public List<Zabieg> getZabiegi() {
        return zabiegi;
    }

    public void setZabiegi(List<Zabieg> zabiegi) {
        this.zabiegi = zabiegi;
    }

    public String getRoslina() {
        return roslina;
    }

    public void setRoslina(String roslina) {
        this.roslina = roslina;
    }

    public LocalDate getDataRozpoczecia() {
        return dataRozpoczecia;
    }

    public void setDataRozpoczecia(LocalDate dataRozpoczecia) {
        this.dataRozpoczecia = dataRozpoczecia;
    }

    public LocalDate getDataZakonczenia() {
        return dataZakonczenia;
    }

    public void setDataZakonczenia(LocalDate dataZakonczenia) {
        this.dataZakonczenia = dataZakonczenia;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public static Uprawa dodajUprawe(String roslina, LocalDate dataRozpoczecia, Pole pole){
        Uprawa uprawa = new Uprawa(roslina, dataRozpoczecia);
        uprawa.setPole(pole);
        pole.dodajUprawe(uprawa);
        return uprawa;
    }

    @Override
    public String toString() {
        return  "roslina='" + roslina + '\'' +
                ", dataRozpoczecia=" + dataRozpoczecia +
                ", dataZakonczenia=" + dataZakonczenia +
                ", pole=" + pole.getNazwa()
                ;
    }
}
