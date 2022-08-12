package com.egor.top.services.hibernate;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import static com.egor.top.dummies.Dummies.*;
import static java.util.Collections.addAll;

@Slf4j
public abstract class AbstractHibernationService {

    @Autowired
    protected SessionFactory sessionFactory;

    public void saveAllGames() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            GAME_MODEL_LIST.forEach(session::persist);
            transaction.commit();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public void saveAllTypes() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            GAME_TYPE_LIST.forEach(session::persist);
            transaction.commit();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public void fullInit() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            GAME_TYPE_LIST.forEach(session::persist);
            GAME_MODEL_LIST.forEach(session::persist);
            GAME_COMPANY_LIST.forEach(session::persist);

            addAll(GAME_MODEL_LIST.get(0).getTypes(), GAME_TYPE_LIST.get(2), GAME_TYPE_LIST.get(4));
            addAll(GAME_MODEL_LIST.get(1).getTypes(), GAME_TYPE_LIST.get(2), GAME_TYPE_LIST.get(4));
            addAll(GAME_MODEL_LIST.get(2).getTypes(), GAME_TYPE_LIST.get(2), GAME_TYPE_LIST.get(4));
            addAll(GAME_MODEL_LIST.get(3).getTypes(), GAME_TYPE_LIST.get(3), GAME_TYPE_LIST.get(4));
            addAll(GAME_MODEL_LIST.get(4).getTypes(), GAME_TYPE_LIST.get(5), GAME_TYPE_LIST.get(4));
            addAll(GAME_MODEL_LIST.get(5).getTypes(), GAME_TYPE_LIST.get(2), GAME_TYPE_LIST.get(4), GAME_TYPE_LIST.get(6));
            addAll(GAME_MODEL_LIST.get(6).getTypes(), GAME_TYPE_LIST.get(0), GAME_TYPE_LIST.get(1));
            addAll(GAME_MODEL_LIST.get(7).getTypes(), GAME_TYPE_LIST.get(0), GAME_TYPE_LIST.get(1), GAME_TYPE_LIST.get(4));
            addAll(GAME_MODEL_LIST.get(8).getTypes(), GAME_TYPE_LIST.get(2), GAME_TYPE_LIST.get(4));

            session.flush();

            GAME_MODEL_LIST.get(0).setCompany(GAME_COMPANY_LIST.get(3));
            GAME_MODEL_LIST.get(1).setCompany(GAME_COMPANY_LIST.get(1));
            GAME_MODEL_LIST.get(2).setCompany(GAME_COMPANY_LIST.get(0));
            GAME_MODEL_LIST.get(3).setCompany(GAME_COMPANY_LIST.get(2));
            GAME_MODEL_LIST.get(4).setCompany(GAME_COMPANY_LIST.get(1));
            GAME_MODEL_LIST.get(8).setCompany(GAME_COMPANY_LIST.get(1));
            GAME_MODEL_LIST.get(5).setCompany(GAME_COMPANY_LIST.get(0));
            GAME_MODEL_LIST.get(6).setCompany(GAME_COMPANY_LIST.get(3));
            GAME_MODEL_LIST.get(7).setCompany(GAME_COMPANY_LIST.get(2));

            transaction.commit();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

}
