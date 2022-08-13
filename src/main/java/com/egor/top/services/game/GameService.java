package com.egor.top.services.game;

import com.egor.top.models.CompanyModel;
import com.egor.top.models.GameModel;
import com.egor.top.models.TypeModel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import java.util.HashSet;
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

            TypeModel typeModel = session.bySimpleNaturalId(TypeModel.class).loadOptional(typeName).orElse(null);

            if (typeModel != null) {
                games = typeModel.getGames();
            } else {
                log.error("[GameTypeModel] with [name] {} not found!", typeName);
            }

            transaction.commit();
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return Set.copyOf(games);
    }

    public void deleteType(String typeName) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            TypeModel typeModel = session.bySimpleNaturalId(TypeModel.class).loadOptional(typeName).orElse(null);

            if (typeModel != null) {
                session.delete(typeModel);
            } else {
                log.error("No [GameTypeModel] with [name] {}", typeName);
            }

            transaction.commit();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public void deleteGame(String name) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            GameModel gameModel = session.bySimpleNaturalId(GameModel.class).loadOptional(name).orElse(null);

            if (gameModel != null) {
                session.remove(gameModel);
            } else {
                log.error("No [GameModel] with [name] {}", name);
            }

            transaction.commit();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public void deleteCompany(String name) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            CompanyModel companyModel = session.bySimpleNaturalId(CompanyModel.class).loadOptional(name).orElse(null);

            if (companyModel != null) {
                session.remove(companyModel);
            } else {
                log.error("No [GameCompanyModel] with [name] {}", name);
            }

            transaction.commit();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
