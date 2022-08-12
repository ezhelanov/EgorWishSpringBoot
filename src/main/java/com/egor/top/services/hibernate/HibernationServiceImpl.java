package com.egor.top.services.hibernate;

import com.egor.top.models.GameModel;
import com.egor.top.models.GameTypeModel;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HibernationServiceImpl extends AbstractHibernationService {

    public void cascadePersist() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            GameTypeModel gameTypeModel = new GameTypeModel("1-st person");
            GameModel gameModel = new GameModel("Doom 3", 2007);

            gameTypeModel.getGames().add(gameModel);

            session.persist(gameTypeModel); // [type, game] transient -> persistent

            gameModel.getTypes().add(gameTypeModel);

            transaction.commit();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

}
