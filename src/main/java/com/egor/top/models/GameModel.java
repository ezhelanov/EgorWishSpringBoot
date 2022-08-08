package com.egor.top.models;

import com.egor.top.mappedsuperclasses.AbstractEntertainmentModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "games")
public class GameModel extends AbstractEntertainmentModel {

    @ManyToMany
    @JoinTable(
            name = "game2gametype",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "gametype_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"game_id", "gametype_id"})
    )
    private Set<GameTypeModel> types;

    public GameModel(String name) { super(name); }
}
