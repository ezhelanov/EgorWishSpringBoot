package com.egor.top;

import com.egor.top.repos.game.GameRepo;
import com.egor.top.repos.game.GameTypeRepo;
import com.egor.top.services.game.GameService;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@AllArgsConstructor
public class TopApplication {

    private final HibernationServiceImpl hibernationServiceImpl;
    private final GameRepo gameRepo;
    private final GameTypeRepo gameTypeRepo;
    private final GameService gameService;

    public static void main(String[] args) {
        SpringApplication.run(TopApplication.class, args);
    }

    @PostConstruct
    public void f(){


      //hibernationServiceImpl.fullInit();
        //hibernationServiceImpl.cascadePersist();
    }

}
