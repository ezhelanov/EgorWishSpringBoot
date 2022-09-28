package com.egor.top.security.jwt;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class JwtUtils {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration.ms}")
    private long jwtExpirationMs;


    public String generateJwt(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        Date now = new Date();

        return Jwts.builder()
                .setSubject((userDetails.getUsername()))
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getUserNameFromJwt(String jwt) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(jwt).getBody().getSubject();
    }

    public boolean isValidJwt(String jwt) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(jwt);
            return true;
        } catch (SignatureException e) {
            LOG.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            LOG.error("Invalid JWT: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            LOG.error("JWT is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            LOG.error("JWT is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            LOG.error("JWT claims string is empty: {}", e.getMessage());
        }
        return false;
    }

}
