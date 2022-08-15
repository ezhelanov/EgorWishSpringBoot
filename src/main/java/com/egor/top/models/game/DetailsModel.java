package com.egor.top.models.game;

import com.egor.top.models.AbstractItemModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "details")
public class DetailsModel extends AbstractItemModel {

    @OneToOne
    @JoinColumn(name = "game_id", unique = true)
    private GameModel game;

    @Type(type = "text")
    private String description;


    public DetailsModel(String description) {
        this.description = description;
    }
}
