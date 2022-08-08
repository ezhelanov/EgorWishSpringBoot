package com.egor.top;

import com.egor.top.models.GameTypeModel;
import com.egor.top.repos.GameRepo;
import com.egor.top.repos.GameTypeRepo;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
@AllArgsConstructor
public class TopApplication {

    private final GameRepo gameRepo;
    private final GameTypeRepo gameTypeRepo;

    public static void main(String[] args) {
        SpringApplication.run(TopApplication.class, args);
    }

    @PostConstruct
    public void f(){
        gameTypeRepo.saveAll(List.of(
                new GameTypeModel("Survival"),
                new GameTypeModel("3-person view"),
                new GameTypeModel("1-person view"),
                new GameTypeModel("Horror"),
                new GameTypeModel("RPG"),
                new GameTypeModel("MMO"),
                new GameTypeModel("Shooter"),
                new GameTypeModel("Meat Shooter")
        ));
    }

}
