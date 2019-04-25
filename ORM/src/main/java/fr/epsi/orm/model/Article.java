package fr.epsi.orm.model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String titre;

    @Column
    private float prix;

    public Article() {
        this.titre = null;
    }

    public Article(String titre) {
        this.titre = titre;
    }

    public long getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "titre='" + titre + '\'' +
                ", prix=" + prix ;
    }
}
