package com.egor.top.repos.game;

import com.egor.top.models.game.GameModel;
import com.egor.top.models.game.RTXGameModel;
import com.egor.top.repos.AbstractEntertainmentRepo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GameRepo extends AbstractEntertainmentRepo<GameModel> {

    @Query(value = "FROM RTXGameModel rtx")
    List<RTXGameModel> findAllRTXGames();

    @Query(value = "FROM GameModel g WHERE TYPE (g) = GameModel")
    List<GameModel> findAllGames();

    @Query(value = "FROM GameModel g WHERE TYPE (g) = :gameClass")
    <T extends GameModel> List<T> findAllByClass(
            @Param(value = "gameClass") Class<? extends GameModel> gameClass
    );
}
