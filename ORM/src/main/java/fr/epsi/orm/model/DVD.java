package fr.epsi.orm.model;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
public class DVD extends Article{

    @ManyToOne
    private Categorie categorie;

    @ManyToOne
    private Realisateur realisateur;

    @ManyToMany(mappedBy = "dvds")
    private List<Acteur> acteurs;

    public DVD(String titre, Categorie categorie) {
        super(titre);
        this.categorie = categorie;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Realisateur getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(Realisateur realisateur) {
        this.realisateur = realisateur;
    }

    public List<Acteur> getActeurs() {
        return acteurs;
    }

    public void setActeurs(List<Acteur> acteurs) {
        this.acteurs = acteurs;
    }
}
