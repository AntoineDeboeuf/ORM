package fr.epsi.orm.model;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("artiste")

public class Artiste extends Personne {

    @ManyToMany(mappedBy = "artistes")
    private List<Groupe> groupes;

    public Artiste() {
    }

    public Artiste(String nom, String prenom) {
        super(nom, prenom);
    }

    public List<Groupe> getGroupes() {
        return groupes;
    }

    public void setGroupes(List<Groupe> groupes) {
        this.groupes = groupes;
    }
    @Override
    public String toString() {
        return "Artiste{" +
                super.toString() +
                ", groupes=" + groupes +
                '}';
    }
}
