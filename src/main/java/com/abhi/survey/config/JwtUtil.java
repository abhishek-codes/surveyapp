package com.abhi.survey.config;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

    private String SECRET_KEY = "Survey_Secret_key";

    public String createToken(UserDetails userDetails){
        Map<String,Object> claims = new HashMap<>();
        return Jwts.builder().setClaims(claims)
            .setSubject(userDetails.getUsername())
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis()+ 1000 * 60 * 60 * 24 * 7))
            .signWith(SignatureAlgorithm.HS256, this.SECRET_KEY).compact();
    }

    public Authentication validateToken(String token){
        Claims claims = Jwts.parser().setSigningKey(this.SECRET_KEY).parseClaimsJws(token).getBody();
        if(claims.getExpiration().before(new Date())){
            return null;
        }
        String username = claims.getSubject();
        return new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());
    }

}
