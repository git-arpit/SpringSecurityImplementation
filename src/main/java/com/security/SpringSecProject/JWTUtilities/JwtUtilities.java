package com.security.SpringSecProject.JWTUtilities;


import com.security.SpringSecProject.Models.UserModel;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtilities {

    private String SECRETKEY = "newSecretKeyNewSecretKeynewSecretKeysecretKeyNew";

    public String generateToken(UserModel user) {
        Map<String, String> claims = new HashMap<>();
        claims.put("eid", Integer.toString(user.getId()));
        return Jwts.builder()
                .subject(user.getUsername())
                .claims(claims)
                .header().add("typ", "JWT")
                .and()
                .issuedAt(new Date(System.currentTimeMillis()))
                .signWith(getSigningKey())
                .compact();
    }

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRETKEY.getBytes());
    }

    public String parseJwt(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser()
                .verifyWith((SecretKey) getSigningKey())
                .build().parseSignedClaims(token)
                .getPayload().getSubject();
    }
    public String getIdFromJwtToken(String token) {
        return Jwts.parser()
                .verifyWith((SecretKey) getSigningKey())
                .build().parseSignedClaims(token)
                .getPayload().get("eid", String.class);
    }


    public boolean validateToken(String jwt) {
        try {
            System.out.println("Inside Validate JWT");
            Jwts.parser().verifyWith((SecretKey) getSigningKey()).build().parseSignedClaims(jwt);
            return true;
        } catch (JwtException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return false;
    }
}
