package com.egor.top;

import com.egor.top.services.hibernate.HibernationService;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@AllArgsConstructor
public class TopApplication {

    private final HibernationService hibernationService;

    public static void main(String[] args) {
        SpringApplication.run(TopApplication.class, args);
    }

    @PostConstruct
    public void initDatabase(){
        hibernationService.createRoles();
    }

}
