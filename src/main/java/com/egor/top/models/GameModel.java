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
@AttributeOverrides({
        @AttributeOverride(name = "name", column = @Column(length = 50, nullable = false, updatable = false))
})
public class GameModel extends AbstractEntertainmentModel {

    @ManyToMany
    @JoinTable(
            name = "game2gametype",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "gametype_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = { "game_id", "gametype_id" })
    )
    private Set<GameTypeModel> types = new HashSet<>();

    private int year;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private GameCompanyModel company;

    public GameModel(String name, int year) {
        super(name);
        this.year = year;
    }
}
