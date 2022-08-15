package com.egor.top.services.hibernate;

import com.egor.top.models.game.DetailsModel;
import com.egor.top.models.game.GameModel;
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

            GameModel gameModel = session.bySimpleNaturalId(GameModel.class).load("Fallout 4");
            DetailsModel neW = new DetailsModel("Fallout new");

            gameModel.setDetails(neW);
            neW.setGame(gameModel);

            transaction.commit();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

}
