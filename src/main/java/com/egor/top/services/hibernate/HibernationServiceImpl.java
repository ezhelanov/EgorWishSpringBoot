package com.egor.top.services.hibernate;

import com.egor.top.models.GameDetailsModel;
import com.egor.top.models.GameModel;
import com.egor.top.models.GameTypeModel;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.engine.spi.PersistenceContext;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.internal.SessionImpl;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HibernationServiceImpl extends AbstractHibernationService {

    public void cascadePersist() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            GameModel gameModel = session.bySimpleNaturalId(GameModel.class).load("Fallout 4");
            GameDetailsModel old = gameModel.getDetails();
            GameDetailsModel gameDetailsModel = new GameDetailsModel("Fallout 4 new");

            old.setGame(null);
            session.flush();

            gameModel.setDetails(gameDetailsModel);
            gameDetailsModel.setGame(gameModel);

            transaction.commit();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

}
