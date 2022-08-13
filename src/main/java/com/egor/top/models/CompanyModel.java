package com.egor.top.models;

import com.egor.top.models.mappedsuperclasses.AbstractEntertainmentModel;
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
@Table(name = "companies")
@AttributeOverrides({
        @AttributeOverride(
                name = "name",
                column = @Column(length = 20, nullable = false, updatable = false)
        )
})
public class CompanyModel extends AbstractEntertainmentModel {

    @OneToMany(mappedBy = "company", cascade = CascadeType.REMOVE)
    private Set<GameModel> games = new HashSet<>();


    public CompanyModel(String name) {
        super(name);
    }
}
