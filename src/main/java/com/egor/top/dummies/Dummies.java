package com.egor.top.dummies;

import com.egor.top.models.GameCompanyModel;
import com.egor.top.models.GameModel;
import com.egor.top.models.GameTypeModel;

import java.util.List;

public interface Dummies {

    List<GameTypeModel> GAME_TYPE_LIST = List.of(
            new GameTypeModel("Survival"),
            new GameTypeModel("Horror"),
            new GameTypeModel("RPG"),
            new GameTypeModel("MMO"),
            new GameTypeModel("Shooter"),
            new GameTypeModel("Meat Shooter"),
            new GameTypeModel("Stealth"),
            new GameTypeModel("Simulator")
    );

    List<GameModel> GAME_MODEL_LIST = List.of(
            new GameModel("S.T.A.L.K.E.R. Call Of Pripyat", 2009),
            new GameModel("Fallout 4", 2015),
            new GameModel("Saints Row 4", 2011),
            new GameModel("Crysis Wars", 2009),
            new GameModel("DOOM", 2016),
            new GameModel("RDR 2", 2020),
            new GameModel("The Forest", 2017),
            new GameModel("7 Days To Die", 2011),
            new GameModel("Rage", 2011)
    );

    List<GameCompanyModel> GAME_COMPANY_LIST = List.of(
            new GameCompanyModel("Volition"),
            new GameCompanyModel("Bethesda"),
            new GameCompanyModel("Crytek"),
            new GameCompanyModel("GSC")
    );

}
