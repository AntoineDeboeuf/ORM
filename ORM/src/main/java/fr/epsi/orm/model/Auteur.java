package fr.epsi.orm.model;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("auteur")
public class Auteur extends Personne{

    @ManyToMany
    private List<Livre> livres;

    public Auteur() {
    }

    public Auteur(String nom, String prenom) {
        super(nom, prenom);
    }

    public List<Livre> getLivres() {
        return livres;
    }

    public void setLivres(List<Livre> livres) {
        this.livres = livres;
    }

    @Override
    public String toString() {
        return "Auteur{" +
                super.toString() +
                "livres=" + livres +
                '}';
    }
}
