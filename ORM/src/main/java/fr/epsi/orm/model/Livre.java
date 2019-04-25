package fr.epsi.orm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.security.PrivateKey;
import java.util.List;

@Entity
public class Livre extends Article{

    @Column
    private String ISBN;

    @ManyToMany(mappedBy = "livres")
    private List<Auteur> auteurs;

    public Livre(String titre, String ISBN) {
        super(titre);
        this.ISBN = ISBN;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public List<Auteur> getAuteurs() {
        return auteurs;
    }

    public void setAuteurs(List<Auteur> auteurs) {
        this.auteurs = auteurs;
    }
}
