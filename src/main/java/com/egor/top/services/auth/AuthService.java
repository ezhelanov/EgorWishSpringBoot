package com.egor.top.services.auth;

import com.egor.top.controllers.payload.request.LoginRequest;
import com.egor.top.controllers.payload.response.JwtResponse;
import org.springframework.http.ResponseEntity;

public interface AuthService {

    ResponseEntity<JwtResponse> authenticateUser(LoginRequest loginRequest);

}
