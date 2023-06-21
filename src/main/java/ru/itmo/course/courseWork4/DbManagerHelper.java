package ru.itmo.course.courseWork4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class DbManagerHelper<T> {
    private final SessionFactory sessionFactory;
    private final Class<T> entityClass;

    public DbManagerHelper(SessionFactory sessionFactory,
                           Class<T> entityClass){
        this.sessionFactory = sessionFactory;
        this.entityClass = entityClass;
    }

    public void addEntity(T entity){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        session.close();
    }

    public void updateEntity(T entity) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteEntity(long entityId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        T entity = session.get(entityClass, entityId);
        if (entity != null) {
            session.delete(entity);
        }
        session.getTransaction().commit();
        session.close();
    }

    public T getEntityById(long entityId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        T entity = session.get(entityClass, entityId);
        session.getTransaction().commit();
        session.close();
        return entity;
    }

    public List<T> getAllEntities() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<T> entities = session.createQuery("FROM " + entityClass.getSimpleName(), entityClass).list();
        session.getTransaction().commit();
        session.close();
        return entities;
    }
}
