package com.egor.top.dummies;

import com.egor.top.models.GameCompanyModel;
import com.egor.top.models.GameDetailsModel;
import com.egor.top.models.GameModel;
import com.egor.top.models.GameTypeModel;

import java.util.List;

public interface Dummies {

    List<GameTypeModel> TYPES = List.of(
            new GameTypeModel("Survival"),
            new GameTypeModel("Horror"),
            new GameTypeModel("RPG"),
            new GameTypeModel("MMO"),
            new GameTypeModel("Shooter"),
            new GameTypeModel("Meat Shooter"),
            new GameTypeModel("Stealth"),
            new GameTypeModel("Simulator")
    );

    List<GameModel> GAMES = List.of(
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

    List<GameCompanyModel> COMPANIES = List.of(
            new GameCompanyModel("Volition"),
            new GameCompanyModel("Bethesda"),
            new GameCompanyModel("Crytek"),
            new GameCompanyModel("GSC")
    );

    List<GameDetailsModel> DETAILS = List.of(
            new GameDetailsModel("""
                    S.T.A.L.K.E.R.: Зов Припяти — компьютерная игра в жанре FPS с элементами ролевой игры и survival horror от украинской компании GSC Game World, 
                    сиквел игры «S.T.A.L.K.E.R.: Тень Чернобыля». 
                    Выход игры состоялся 2 октября 2009 года.
                    """),
            new GameDetailsModel("""
                    Fallout 4 — компьютерная игра в жанре Action RPG, разработанная Bethesda Game Studios и изданная Bethesda Softworks. 
                    Является частью серии Fallout. Игра была выпущена 10 ноября 2015 года на Windows, PlayStation 4 и Xbox One. 
                    Локализатор на территории России и СНГ — компания СофтКлаб.
                    """),
            new GameDetailsModel("""
                    Saints Row IV — мультиплатформенная компьютерная игра в жанре приключенческого боевика с элементами открытого мира, разработанная компанией Volition.
                    Релиз состоялся 23 августа 2013 года на PC, PlayStation 3 и Xbox 360. 
                    30 января 2015 года состоялся релиз игры на PlayStation 4 и Xbox One со всеми вышедшими к игре DLC.
                    """)
    );

}
