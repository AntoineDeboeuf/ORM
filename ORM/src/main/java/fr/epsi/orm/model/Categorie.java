package fr.epsi.orm.model;

import javax.persistence.*;

@Entity
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String nom;

    public Categorie() {
        this.nom = null;
    }

    public Categorie(String nom) {
        this.nom = nom;
    }

    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
