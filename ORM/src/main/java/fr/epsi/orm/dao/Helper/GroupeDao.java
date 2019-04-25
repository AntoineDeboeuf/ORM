package fr.epsi.orm.dao.Helper;

import fr.epsi.orm.exceptions.AlreadyExistsException;
import fr.epsi.orm.model.Groupe;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class GroupeDao extends GenericDao {

    /**
     * Inserts a groupe.
     *
     * @param groupe The group to persist.
     * @return The persisted group.
     * @throws AlreadyExistsException The group already exists.
     */
    public Groupe insertStyle(Groupe groupe) throws AlreadyExistsException {

        // Check if person already exists
        Groupe existing = findByNom(groupe.getNom());
        if (existing != null) {
            throw new AlreadyExistsException("A groupe with the name " + groupe.getNom() + ' ' + " already exists.");
        }

        this.insert(groupe);
        return (groupe);
    }

    public Groupe findByNom(String nom) {
        TypedQuery<Groupe> query = getEntityManager().createQuery("from Groupe g where g.nom = :nom", Groupe.class);
        query.setParameter("nom", nom);

        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    /**
     * Find all groupes.
     * @return list of Groupe, otherwise null.
     */
    public List<Groupe> findAll() {
        TypedQuery<Groupe> query = getEntityManager().createQuery("from Groupe", Groupe.class);
        try{
            return query.getResultList();
        }
        catch (NoResultException e){
            return null;
        }
    }

    /**
     * update a groupe by its id.
     * @param id
     * @param nom
     * @return The updated groupe.
     */
    public Groupe update(long id, String nom) {
        Groupe groupe = getEntityManager().find(Groupe.class, id);

        groupe.setNom(nom);

        getEntityManager().getTransaction().begin();
        getEntityManager().merge(groupe);
        getEntityManager().getTransaction().commit();

        return groupe;
    }

    /**
     * delete a groupe by its id.
     * @param id
     */
    public void delete(long id) {
        Groupe groupe = getEntityManager().find(Groupe.class, id);

        getEntityManager().getTransaction().begin();
        getEntityManager().remove(groupe);
        getEntityManager().getTransaction().commit();
    }
}
