package fr.epsi.orm.dao.Helper;

import fr.epsi.orm.model.Personne;

import javax.persistence.EntityManager;
import java.util.List;

public class GenericDao {

    private EntityManager entityManager;

    public GenericDao() {
        this.entityManager = DatabaseHelper.createEntityManager();
    }

    protected EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = DatabaseHelper.createEntityManager();
        }
        return entityManager;
    }

    protected void insert(Object object){
        entityManager = getEntityManager();
        DatabaseHelper.beginTransaction(entityManager);
        entityManager.persist(object);
        DatabaseHelper.commitTransactionAndClose(entityManager);
    }
}
