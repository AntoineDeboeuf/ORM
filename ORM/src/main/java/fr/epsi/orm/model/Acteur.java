package fr.epsi.orm.model;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("acteur")
public class Acteur extends Personne{

    @ManyToMany
    private List<DVD> dvds;

    public Acteur() {
    }

    public Acteur(String nom, String prenom) {
        super(nom, prenom);
    }

    public List<DVD> getDvds() {
        return dvds;
    }

    public void setDvds(List<DVD> dvds) {
        this.dvds = dvds;
    }

    public void addDvd(DVD dvd){
        dvds.add(dvd);
    }

    @Override
    public String toString() {
        return "Acteur{" +
                super.toString() +
                "dvds=" + dvds +
                '}';
    }
}
