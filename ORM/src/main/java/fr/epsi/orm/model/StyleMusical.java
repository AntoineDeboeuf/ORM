package fr.epsi.orm.model;

import javax.persistence.*;

@Entity
public class StyleMusical {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String nom;

    public StyleMusical() {
    }

    public StyleMusical(String nom) {
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

    @Override
    public String toString() {
        return "StyleMusical{" +
                "nom='" + nom + '\'' +
                '}';
    }
}
