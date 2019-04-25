package fr.epsi.orm.dao.Helper;

import fr.epsi.orm.exceptions.AlreadyExistsException;
import fr.epsi.orm.model.StyleMusical;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class StyleDao extends GenericDao {

    /**
     * Inserts a style.
     * @param style The style to persist.
     * @return The persisted style.
     * @throws AlreadyExistsException The style already exists.
     */
    public StyleMusical insertStyle(StyleMusical style) throws AlreadyExistsException{

        // Check if person already exists
        StyleMusical existing = findByNom(style.getNom());
        if (existing != null) {
            throw new AlreadyExistsException("A style with the name " + style.getNom() + ' ' + " already exists.");
        }

        this.insert(style);
        return (style);
    }

    /**
     * Find style by its surname.
     * @param nom
     * @return The matching Style.
     */
    public StyleMusical findByNom(String nom){
        TypedQuery<StyleMusical> query = getEntityManager().createQuery("from StyleMusical s where s.nom = :nom", StyleMusical.class);
        query.setParameter("nom", nom);

        try{
            return query.getSingleResult();
        }
        catch (NoResultException e){
            return null;
        }
    }

    /**
     * Find all styles.
     * @return list of all styles, otherwise null..
     */
    public List<StyleMusical> findAll() {
        TypedQuery<StyleMusical> query = getEntityManager().createQuery("from StyleMusical", StyleMusical.class);

        try{
            return query.getResultList();
        }
        catch (NoResultException e){
            return null;
        }
    }

    /**
     * update a musical style by its id.
     * @param id
     * @param style
     * @return The updated Musical Style.
     */
    public StyleMusical update(long id, String style) {
        StyleMusical styleMusical = getEntityManager().find(StyleMusical.class, id);

        styleMusical.setNom("Rap/RnB");

        getEntityManager().getTransaction().begin();
        getEntityManager().merge(styleMusical);
        getEntityManager().getTransaction().commit();

        return styleMusical;
    }

    /**
     * delete a musical style by its id.
     * @param id
     */
    public void delete(long id) {
        StyleMusical styleMusical = getEntityManager().find(StyleMusical.class, id);

        getEntityManager().getTransaction().begin();
        getEntityManager().remove(styleMusical);
        getEntityManager().getTransaction().commit();
    }
}
