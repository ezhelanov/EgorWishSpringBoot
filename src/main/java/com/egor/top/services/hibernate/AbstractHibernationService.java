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


    public void fullInit() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            GAMES.forEach(session::persist);

            addAll(GAMES.get(0).getTypes(), TYPES.get(2), TYPES.get(4), TYPES.get(0), TYPES.get(1));
            addAll(GAMES.get(1).getTypes(), TYPES.get(2), TYPES.get(4));
            addAll(GAMES.get(2).getTypes(), TYPES.get(2), TYPES.get(4));
            addAll(GAMES.get(3).getTypes(), TYPES.get(3), TYPES.get(4));
            addAll(GAMES.get(4).getTypes(), TYPES.get(5), TYPES.get(4));
            addAll(GAMES.get(5).getTypes(), TYPES.get(2), TYPES.get(4), TYPES.get(6));
            addAll(GAMES.get(6).getTypes(), TYPES.get(0), TYPES.get(1));
            addAll(GAMES.get(7).getTypes(), TYPES.get(0), TYPES.get(1), TYPES.get(4));
            addAll(GAMES.get(8).getTypes(), TYPES.get(2), TYPES.get(4));

            session.flush();

            GAMES.get(0).setCompany(COMPANIES.get(3));
            GAMES.get(1).setCompany(COMPANIES.get(1));
            GAMES.get(2).setCompany(COMPANIES.get(0));
            GAMES.get(3).setCompany(COMPANIES.get(2));
            GAMES.get(4).setCompany(COMPANIES.get(1));
            GAMES.get(8).setCompany(COMPANIES.get(1));
            GAMES.get(5).setCompany(COMPANIES.get(0));
            GAMES.get(6).setCompany(COMPANIES.get(3));
            GAMES.get(7).setCompany(COMPANIES.get(2));

            for (int i = 0; i < 3; i++) {
                GAMES.get(i).setDetails(DETAILS.get(i));
                DETAILS.get(i).setGame(GAMES.get(i));
            }

            transaction.commit();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

}
