package jelly.repository;

import jelly.config.EntityManagerCreator;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractRepository<T extends Serializable> {
    private Class<T> clazz;

    protected final void setClazz(final Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    public T findOne(final long id) {
        EntityManager em = EntityManagerCreator.create();
        try {
            return em.find(clazz, id);
        }
        finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    public List<T> query(String name) {
        EntityManager em = EntityManagerCreator.create();
        try {
            return em.createNamedQuery(name, clazz).getResultList();
        }
        finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    public void create(final T entity) {
        EntityManager em = EntityManagerCreator.create();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(entity);
            transaction.commit();
        }
        finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    public T update(final T entity) {
        EntityManager em = EntityManagerCreator.create();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(entity);
            transaction.commit();
        }
        finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            if (em.isOpen()) {
                em.close();
            }
        }
        return entity;
    }

    public void delete(final long entityId) {
        EntityManager em = EntityManagerCreator.create();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.remove(em.getReference(clazz, entityId));
            transaction.commit();
        }
        finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            if (em.isOpen()) {
                em.close();
            }
        }
    }
}
