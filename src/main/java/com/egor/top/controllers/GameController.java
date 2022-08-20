package com.egor.top.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/games")
public class GameController {

    @GetMapping
    public String hello() {
        return "Hello";
    }

    @GetMapping("/authenticated")
    public String security() {
        return "Security";
    }

}
