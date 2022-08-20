package com.egor.top.controllers.payload.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class JwtResponse {

    private static final String BEARER = "Bearer";


    private String jwt;

    private int userId;

    private String userName;

    private List<String> userRoles;

}
