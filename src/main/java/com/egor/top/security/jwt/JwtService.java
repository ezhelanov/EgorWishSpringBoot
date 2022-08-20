package com.egor.top.security.jwt;

import org.springframework.security.core.Authentication;

public interface JwtService {

    String generateJwt(Authentication authentication);

    String getUserNameFromJwt(String jwt);

    boolean isValidJwt(String jwt);
}
