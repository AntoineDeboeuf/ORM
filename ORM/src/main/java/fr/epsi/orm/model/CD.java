package fr.epsi.orm.model;

import javax.persistence.*;

@Entity
public class CD extends Article{

    @ManyToOne
    private StyleMusical style;

    @OneToOne
    @JoinColumn(name = "artiste")
    private Artiste artiste;

    @OneToOne
    @JoinColumn(name = "groupe")
    private Groupe groupe;

    public CD(){ super(); }

    public CD(String titre) {
        super(titre);
    }

    public CD(String titre, StyleMusical style) {
        super(titre);
        this.style = style;
    }

    public CD(String titre, StyleMusical style, Artiste artiste) {
        super(titre);
        this.style = style;
        this.artiste = artiste;
    }

    public CD(String titre, StyleMusical style, Groupe groupe) {
        super(titre);
        this.style = style;
        this.groupe = groupe;
    }

    public StyleMusical getStyle() {
        return style;
    }

    public void setStyle(StyleMusical style) {
        this.style = style;
    }

    public Artiste getArtiste() {
        return artiste;
    }

    public void setArtiste(Artiste artiste) {
        this.artiste = artiste;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    @Override
    public String toString() {
        return "CD{" +
                super.toString()+
                ", style=" + style +
                ", artiste=" + artiste +
                ", groupe=" + groupe +
                '}';
    }
}
