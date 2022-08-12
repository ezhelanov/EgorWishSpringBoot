package com.egor.top.services.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import static com.egor.top.dummies.Dummies.GAME_MODEL_LIST;
import static com.egor.top.dummies.Dummies.GAME_TYPE_MODEL_LIST;

public abstract class AbstractHibernateService {

    @Autowired
    protected SessionFactory sessionFactory;

    public void saveAllGames() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            GAME_MODEL_LIST.forEach(session::persist);
            transaction.commit();
        }
    }

    public void saveAllGameTypes() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            GAME_TYPE_MODEL_LIST.forEach(session::persist);
            transaction.commit();
        }
    }

}
