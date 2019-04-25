package fr.epsi.orm.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("realisateur")
public class Realisateur extends Personne{

    public Realisateur() {
        super();
    }

    public Realisateur(String nom, String prenom) {
        super(nom, prenom);
    }
    @Override
    public String toString() {
        return "Realisateur{" +
                super.toString() +
                "}";
    }
}
