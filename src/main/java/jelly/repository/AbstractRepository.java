package jelly.repository;

import jelly.config.EntityManagerCreator;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractRepository<T extends Serializable> {
    private Class<T> clazz;

    protected final void setClazz(final Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    public T findOne(final long id) {
        return EntityManagerCreator.create().find(clazz, id);
    }

    public List<T> findAll(String name) {
        return EntityManagerCreator.create().createNamedQuery(name, clazz).getResultList();
    }

    public void create(final T entity) {
        EntityManager em = EntityManagerCreator.create();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    public T update(final T entity) {
        EntityManager em = EntityManagerCreator.create();
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        return entity;
    }

    public void delete(final long entityId) {
        EntityManager em = EntityManagerCreator.create();
        em.getTransaction().begin();
        em.remove(em.getReference(clazz, entityId));
        em.getTransaction().commit();
    }
}
