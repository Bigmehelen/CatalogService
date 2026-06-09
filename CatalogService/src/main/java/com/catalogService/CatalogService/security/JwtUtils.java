package com.catalogService.CatalogService.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import java.security.Key;
import java.security.SecureRandom;
import java.util.Base64;

@Component
public class JwtUtils {

    private Key key;

    @Value("${jwt.secret:}")
    private String jwtSecret;

    @PostConstruct
    public void init() {
        if (jwtSecret == null || jwtSecret.trim().isEmpty()) {
            SecureRandom secureRandom = new SecureRandom();
            byte[] keyBytes = new byte[64];
            secureRandom.nextBytes(keyBytes);
            this.key = Keys.hmacShaKeyFor(keyBytes);
        } else {
            byte[] keyBytes;
            try {
                keyBytes = Base64.getDecoder().decode(jwtSecret.trim());
                if (keyBytes.length < 32) {
                    keyBytes = jwtSecret.getBytes();
                }
            } catch (IllegalArgumentException e) {
                keyBytes = jwtSecret.getBytes();
            }
            this.key = Keys.hmacShaKeyFor(keyBytes);
        }
    }

    public String getUserIdFromToken(String token) {
        return getClaimsFromToken(token).get("userId", String.class);
    }

    public String getRoleFromToken(String token) {
        return getClaimsFromToken(token).get("role", String.class);
    }

    public boolean validateToken(String token) {
        try {
            getClaimsFromToken(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private Claims getClaimsFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
