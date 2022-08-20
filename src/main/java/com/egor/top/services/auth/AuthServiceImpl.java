package com.egor.top.services.auth;

import com.egor.top.controllers.payload.request.LoginRequest;
import com.egor.top.controllers.payload.response.JwtResponse;
import com.egor.top.models.security.JwtModel;
import com.egor.top.models.security.UserModel;
import com.egor.top.repos.security.JwtRepo;
import com.egor.top.repos.security.UserRepo;
import com.egor.top.security.UserDetailsImpl;
import com.egor.top.security.jwt.JwtService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Slf4j
@Component
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepo userRepo;
    private final JwtRepo jwtRepo;

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

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtService.generateJwt(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        UserModel userModel = userRepo.getByName(userDetails.getUsername());
        JwtModel jwtModel = jwtRepo.getByUser(userModel);

        if (jwtModel == null) {
            jwtModel = new JwtModel(jwt, userModel);
        } else {
            jwtModel.setJwt(jwt);
        }
        jwtRepo.save(jwtModel);

        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(
                JwtResponse.builder()
                        .userName(authentication.getName())
                        .jwt(jwt)
                        .userRoles(roles)
                        .build()
        );
    }

    private void createOrUpdateJwtForUser(UserModel userModel, Authentication authentication) {


    }
}
