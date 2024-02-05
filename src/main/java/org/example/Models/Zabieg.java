package org.example.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public abstract class Zabieg {

    public enum statusy{ZLECONY, ANULOWANY, WTRAKCIEWYKONANIA, ZAKONCZONY}

    @Id
    @GeneratedValue
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;

    private LocalDate dataWykonania;

    private Enum status;

    @ManyToOne
    private Gospodarstwo gospodarstwo;

    @ManyToMany
    private List<Pojazd> pojazdyWZabiegu = new ArrayList<>();

    @OneToMany(mappedBy = "zabieg",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    private List<PracownikZabieg> pracownicyWZabiegu = new ArrayList<>();

    @ManyToOne
    private Uprawa uprawaWZabiegu;

    public Zabieg() {}

    public Zabieg(LocalDate dataWykonania) {
        this.dataWykonania = dataWykonania;
        this.status = statusy.ZLECONY;
    }
    public Gospodarstwo getGospodarstwo() {
        return gospodarstwo;
    }

    public void setGospodarstwo(Gospodarstwo gospodarstwo) {
        this.gospodarstwo = gospodarstwo;
    }

    public List<Pojazd> getPojazdyWZabiegu() {
        return pojazdyWZabiegu;
    }

    public void setPojazdyWZabiegu(List<Pojazd> pojazdyWZabiegu) {
        this.pojazdyWZabiegu = pojazdyWZabiegu;
    }

    public List<PracownikZabieg> getPracownicyWZabiegu() {
        return pracownicyWZabiegu;
    }

    public void setPracownicyWZabiegu(List<PracownikZabieg> pracownicyWZabiegu) {
        this.pracownicyWZabiegu = pracownicyWZabiegu;
    }

    public Uprawa getUprawaWZabiegu() {
        return uprawaWZabiegu;
    }

    public void setUprawaWZabiegu(Uprawa uprawaWZabiegu) {
        this.uprawaWZabiegu = uprawaWZabiegu;
    }


    public LocalDate getDataWykonania() {
        return dataWykonania;
    }

    public void setDataWykonania(LocalDate dataWykonania) {
        this.dataWykonania = dataWykonania;
    }

    public Enum getStatus() {
        return status;
    }

    public void setStatus(Enum status) {
        this.status = status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void dodajPracownika(PracownikZabieg pz){

        if(!getPracownicyWZabiegu().contains(pz)) {
            this.getPracownicyWZabiegu().add(pz);
        }
    }



//    public static Zabieg zlecZabieg(List<Pracownik> pracownicy, List<Pojazd> pojazdy, Gospodarstwo gospodarstwo, Uprawa uprawa, LocalDate dataWykonania){
//        Zabieg zabieg = new Zabieg(dataWykonania);
//        zabieg.setGospodarstwo(gospodarstwo);
//        gospodarstwo.getZabiegi().add(zabieg);
//        zabieg.setUprawaWZabiegu(uprawa);
//        zabieg.setPojazdyWZabiegu(pojazdy);
//        pojazdy.forEach((Pojazd p) ->{
//            p.dodajZabieg(zabieg);
//        });
//        pracownicy.forEach((Pracownik p)-> {
//            PracownikZabieg.dodajPracownikZabieg(p, zabieg);
//        });
//        return zabieg;
//    }
//Zmiana statusu zabiegu oraz nadanie daty od, do w tabeli asocjacyjnej pracownik zabieg uzaleznione od statusu
    public void zmienStatus(Enum status){
        if(status.equals(statusy.WTRAKCIEWYKONANIA)&& !this.status.equals(statusy.WTRAKCIEWYKONANIA)){
            this.getPracownicyWZabiegu().forEach((PracownikZabieg pz) -> {pz.setDataOd(LocalDate.now());});
            this.setStatus(status);
        }
        else if(status.equals(statusy.ZAKONCZONY)&& !this.status.equals(statusy.ZAKONCZONY)){
            this.getPracownicyWZabiegu().forEach((PracownikZabieg pz) -> {pz.setDataDo(LocalDate.now());});
            this.setStatus(status);
        }else{
            this.setStatus(status);
        }

    }

    public void help(Zabieg zabieg, List<Pracownik> pracownicy, List<Pojazd> pojazdy, Gospodarstwo gospodarstwo, Uprawa uprawa, LocalDate dataWykonania){
        zabieg.setGospodarstwo(gospodarstwo);
        gospodarstwo.getZabiegi().add(zabieg);
        zabieg.setUprawaWZabiegu(uprawa);
        uprawa.getZabiegi().add(zabieg);
        zabieg.setPojazdyWZabiegu(pojazdy);
        pojazdy.forEach((Pojazd p) ->{
            p.dodajZabieg(zabieg);
        });
        pracownicy.forEach((Pracownik p)-> {
            PracownikZabieg.dodajPracownikZabieg(p, zabieg);
        });
    }

}


