package com.travel.User.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.*;

@Service
public class JWTService {

    private final String secretKey = "this-is-a-very-longgggg-secret-key";
    private String key = "";
    private final String keyTest = "3H3umgLEmBwNmH3udkM3+l0xkcgahL8oI6cT4ayHe0I=";

    public JWTService() {
        try {
            key = Base64.getEncoder().encodeToString(secretKey.getBytes());
            System.out.println("Secret key: " + key);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //hàm này tạo token
    public String generateToken(String username, List<String> roles) {

        Map<String, Object> claims = new HashMap<>();
        claims.put("roles", roles);
        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000)) // thời gian tồn tại của token (cho 60 phút)
                .and()
                .signWith(getKey()) //ký token với secret key
                .compact();
    }

    private SecretKey getKey() {

        byte[] keyBytes = Decoders.BASE64.decode(keyTest);

        return Keys.hmacShaKeyFor(keyBytes);
    }

}
