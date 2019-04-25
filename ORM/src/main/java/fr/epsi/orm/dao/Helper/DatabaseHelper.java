package fr.epsi.orm.dao.Helper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseHelper {
    private static final String PERSISTENCE_UNIT_NAME = "MediathequePU";

    private static EntityManagerFactory entityManagerFactory;

    public static EntityManager createEntityManager() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return entityManagerFactory.createEntityManager();
    }

    public static void beginTransaction(EntityManager entityManager) {
        entityManager.getTransaction().begin();
    }

    public static void commitTransactionAndClose(EntityManager entityManager) {
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static void rollbackTransactionAndClose(EntityManager entityManager) {
        entityManager.getTransaction().rollback();
        entityManager.close();
    }

    public static void closeEntityManagerFactory() {
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }
}

