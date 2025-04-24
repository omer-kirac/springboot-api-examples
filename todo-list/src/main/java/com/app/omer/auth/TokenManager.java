package com.app.omer.auth;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.Signature;
import java.util.Date;

@Service
public class TokenManager {

    private static final String SECRET_KEY = "secretKey";
    private static final int EXPIRATION = 3600;

    public String generateToken(String username) {

        return Jwts.builder()
                .setSubject(username)
                .setIssuer("secretKey.com")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public boolean validateToken(String token) {
        if (getUsername(token) == null  && isExpired(token)) {
            return true;
        }
        return false;
    }

    public String getUsername(String token) {
        Claims claims = getClaims(token);
        return claims.getSubject();

    }

    public boolean isExpired(String token) {
        Claims claims = getClaims(token);
        return claims.getExpiration().before(new Date(System.currentTimeMillis()));
    }

    private Claims getClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }


}
