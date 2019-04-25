package fr.epsi.orm.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Groupe {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String nom;

    @ManyToMany
    private List<Artiste> artistes;

    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Artiste> getArtistes() {
        return artistes;
    }

    public void setArtistes(List<Artiste> artistes) {
        this.artistes = artistes;
    }

    public void addArtiste(Artiste artiste){
        this.artistes.add(artiste);
    }

    @Override
    public String toString() {
        return "Groupe{" +
                "nom='" + nom + '\'' +
                ", artistes=" + artistes +
                '}';
    }
}
