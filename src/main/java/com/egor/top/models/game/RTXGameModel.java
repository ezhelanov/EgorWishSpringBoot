package com.egor.top.models.game;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@NoArgsConstructor
@Getter
@Setter
@Entity
@DiscriminatorValue("rtx")
public class RTXGameModel extends GameModel {

    @Column(name = "RTX_on")
    private boolean isRTXon;


    public RTXGameModel(String name, int year) {
        super(name, year);
    }

    public RTXGameModel(String name, int year, boolean isRTXon) {
        super(name, year);
        this.isRTXon = isRTXon;
    }
}
