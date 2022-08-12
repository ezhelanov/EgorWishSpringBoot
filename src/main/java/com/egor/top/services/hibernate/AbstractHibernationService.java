package com.egor.top.services.hibernate;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;

import static com.egor.top.dummies.Dummies.GAME_MODEL_LIST;
import static com.egor.top.dummies.Dummies.GAME_TYPE_LIST;

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

            Collections.addAll(GAME_MODEL_LIST.get(0).getTypes(),
                    GAME_TYPE_LIST.get(2), GAME_TYPE_LIST.get(4)
            );
            Collections.addAll(GAME_MODEL_LIST.get(1).getTypes(),
                    GAME_TYPE_LIST.get(2), GAME_TYPE_LIST.get(4)
            );
            Collections.addAll(GAME_MODEL_LIST.get(2).getTypes(),
                    GAME_TYPE_LIST.get(2), GAME_TYPE_LIST.get(4)
            );
            Collections.addAll(GAME_MODEL_LIST.get(3).getTypes(),
                    GAME_TYPE_LIST.get(3), GAME_TYPE_LIST.get(4)
            );
            Collections.addAll(GAME_MODEL_LIST.get(4).getTypes(),
                    GAME_TYPE_LIST.get(5), GAME_TYPE_LIST.get(4)
            );
            Collections.addAll(GAME_MODEL_LIST.get(5).getTypes(),
                    GAME_TYPE_LIST.get(2), GAME_TYPE_LIST.get(4), GAME_TYPE_LIST.get(6)
            );
            Collections.addAll(GAME_MODEL_LIST.get(6).getTypes(),
                    GAME_TYPE_LIST.get(0), GAME_TYPE_LIST.get(1)
            );
            Collections.addAll(GAME_MODEL_LIST.get(7).getTypes(),
                    GAME_TYPE_LIST.get(0), GAME_TYPE_LIST.get(1), GAME_TYPE_LIST.get(4)
            );
            Collections.addAll(GAME_MODEL_LIST.get(8).getTypes(),
                    GAME_TYPE_LIST.get(2), GAME_TYPE_LIST.get(4)
            );

            transaction.commit();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

}
