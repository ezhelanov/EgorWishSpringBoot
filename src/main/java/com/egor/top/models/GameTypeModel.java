package com.egor.top.models;

import com.egor.top.mappedsuperclasses.AbstractEntertainmentModel;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Entity
@Table(name = "gametypes")
public class GameTypeModel extends AbstractEntertainmentModel {

    @ManyToMany(mappedBy = "types", cascade = CascadeType.ALL)
    private Set<GameModel> games = new HashSet<>();


    public Set<GameModel> getGames() {
        return Collections.unmodifiableSet(games);
    }

    public GameTypeModel(String name) { super(name); }
}
