package com.egor.top.models;

import com.egor.top.mappedsuperclasses.AbstractEntertainmentModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "gametypes")
@AttributeOverrides({
        @AttributeOverride(name = "name", column = @Column(length = 15, nullable = false, updatable = false))
})
public class GameTypeModel extends AbstractEntertainmentModel {

    @ManyToMany(mappedBy = "types", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
    private Set<GameModel> games = new HashSet<>();


    public GameTypeModel(String name) { super(name); }
}
