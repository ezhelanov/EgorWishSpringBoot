package com.egor.top.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class GamesSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests()
                .antMatchers("/games/authenticated/**").authenticated()
                .and()
                .httpBasic()
                .and()
                .logout().logoutSuccessUrl("/games");

    }
}
