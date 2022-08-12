package com.egor.top.services.game;

import com.egor.top.models.GameModel;
import com.egor.top.models.GameTypeModel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@AllArgsConstructor
@Service
public class GameService {

    private final SessionFactory sessionFactory;


    public Set<GameModel> getGamesForType(String typeName) {

        Set<GameModel> games = new HashSet<>();

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            GameTypeModel gameTypeModel = session.bySimpleNaturalId(GameTypeModel.class).loadOptional(typeName).orElse(null);

            if (gameTypeModel != null) {
                games = gameTypeModel.getGames();
            } else {
                log.error("[GameTypeModel] with [name] {} not found!", typeName);
            }

            transaction.commit();
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return Set.copyOf(games);
    }

}
