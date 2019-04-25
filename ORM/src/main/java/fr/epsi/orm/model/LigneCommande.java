package fr.epsi.orm.model;

import javax.persistence.*;

@Entity
public class LigneCommande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "article")
    private Article article;

    @Column
    private int quantite;

    public LigneCommande() {
    }

    public LigneCommande(Article article, int quantite) {
        this.article = article;
        this.quantite = quantite;
    }

    public long getId() {
        return id;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
