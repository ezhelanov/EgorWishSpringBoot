package com.egor.top.services.auth;

import com.egor.top.controllers.payload.request.LoginRequest;
import com.egor.top.controllers.payload.response.JwtResponse;
import com.egor.top.security.jwt.JwtService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Slf4j
@Component
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public ResponseEntity<JwtResponse> authenticateUser(LoginRequest loginRequest) {

        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );
        } catch (AuthenticationException e) {
            LOG.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }

        String jwt = jwtService.generateJwt(authentication);

        return null;

    }
}
