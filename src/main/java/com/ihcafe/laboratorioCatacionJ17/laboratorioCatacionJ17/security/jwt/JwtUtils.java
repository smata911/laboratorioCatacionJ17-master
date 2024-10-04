package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.function.Function;

@Component
@Slf4j
public class JwtUtils {
    @Value("${jwt.secret.key}")
    private String secretKey;

    @Value("${jwt.time.expiration}")
    private String timeExpiration;

    //create token

    public String generateAccesToken(String userName){
        return Jwts.builder()
                .setSubject(userName)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+     Long.parseLong(timeExpiration)))
                .signWith(getSignatureKey(), SignatureAlgorithm.HS256)
                .compact();
    }
//validation token access
    public  boolean isTokenValid(String token){
        try {//no veo correcto usar el tri para determinar si es valido o no el token
            Jwts.parserBuilder()
                    .setSigningKey(getSignatureKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            return true;
        }catch (Exception e){
            log.error("token invalidado".concat(e.getMessage()));
            return false;
        }

    }
    //obtener username token
    public String getUserName(String token){
        return getClaiM(token,Claims::getSubject);
    }
//obtner un solo claim
    public <T>T  getClaiM(String token, Function<Claims,T> claimsTFunction ){
        Claims claims=extractAllClams(token);
        return claimsTFunction.apply(claims);

    }
//obtener todos los claims del token
    public Claims extractAllClams(String token){
        return   Jwts.parserBuilder()
                .setSigningKey(getSignatureKey())
                .build()
                .parseClaimsJws(token)
                .getBody();

    }
    //get signa token
    public Key getSignatureKey(){
        byte[] keyBytes= Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
