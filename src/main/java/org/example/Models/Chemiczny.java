package org.example.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Chemiczny extends Zabieg{
    @Id
    @GeneratedValue
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;

    @ElementCollection
    private List<String> preparaty = new ArrayList<>();

    public Chemiczny() {}

    private Chemiczny(LocalDate dataWykonania, List<String> preparaty) {
        super(dataWykonania);
        this.preparaty = preparaty;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getPreparaty() {
        return preparaty;
    }

    public void setPreparaty(List<String> preparaty) {
        this.preparaty = preparaty;
    }
    public static Chemiczny zlecZabieg(List<Pracownik> pracownicy, List<Pojazd> pojazdy, Gospodarstwo gospodarstwo, Uprawa uprawa, LocalDate dataWykonania, List<String> preparaty){
        Chemiczny zabieg = new Chemiczny(dataWykonania, preparaty);
        zabieg.help(zabieg, pracownicy, pojazdy, gospodarstwo, uprawa, dataWykonania);
        return zabieg;
    }
}
