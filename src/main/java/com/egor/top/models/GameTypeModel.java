package com.egor.top.models;

import com.egor.top.mappedsuperclasses.AbstractEntertainmentModel;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Entity
@Table(name = "gametypes")
public class GameTypeModel extends AbstractEntertainmentModel {

    @ManyToMany(mappedBy = "types", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    private Set<GameModel> games = new HashSet<>();


    public Set<GameModel> getGames() {
        return Collections.unmodifiableSet(games);
    }

    public void addGames(List<GameModel> gameModels) {
        this.games.addAll(gameModels);
        for (GameModel gameModel : gameModels) gameModel.getTypes().add(this);
    }

    public GameTypeModel(String name) { super(name); }
}
