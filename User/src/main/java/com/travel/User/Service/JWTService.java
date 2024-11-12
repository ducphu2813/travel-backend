package com.travel.User.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.security.SecureRandom;

@Service
public class JWTService {

    private String secretKey1 = "this-is-a-very-longgggg-secret-key";
    private String secretKey2 = "this-is-a-very-long-secret-key";

    private byte[] seed1 = secretKey1.getBytes();
    private byte[] seed2 = secretKey2.getBytes();

    public JWTService() {
        try {

            // Tạo SecureRandom cho mỗi seed
            SecureRandom secureRandom1 = new SecureRandom(seed1);
            SecureRandom secureRandom2 = new SecureRandom(seed2);

            // tạo KeyGenerator cho HmacSHA256 với seed 1
            KeyGenerator keyGen1 = KeyGenerator.getInstance("HmacSHA256");
            keyGen1.init(256, secureRandom1);  // 256 là kích thước của key

            // tạo KeyGenerator cho HmacSHA256 với seed 2
            KeyGenerator keyGen2 = KeyGenerator.getInstance("HmacSHA256");
            keyGen2.init(256, secureRandom2);  // 256 là kích thước của key

            // tạo secret key thứ nhất
            SecretKey sk1 = keyGen1.generateKey();
            secretKey1 = Base64.getEncoder().encodeToString(sk1.getEncoded());

            // tạo secret key thứ hai
            SecretKey sk2 = keyGen2.generateKey();
            secretKey2 = Base64.getEncoder().encodeToString(sk2.getEncoded());

            System.out.println("Secret key1: " + secretKey1);
            System.out.println("Secret key2: " + secretKey2);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    //hàm nya2 tạo token
    public String generateToken(String username) {

        Map<String, Object> claims = new HashMap<>();

        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 60 * 60 * 30000)) // thời gian tồn tại của token
                .and()
                .signWith(getKey()) //ký token với secret key
                .compact();
    }

    private SecretKey getKey() {

        byte[] keyBytes = Decoders.BASE64.decode(secretKey1);

        return Keys.hmacShaKeyFor(keyBytes);
    }

//    private SecretKey getKey2() {
//
//        byte[] keyBytes = Decoders.BASE64.decode(secretKey2);
//
//        return Keys.hmacShaKeyFor(keyBytes);
//    }

    public String extractUsername(String token) {
        // extract username from token
        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {

        return Jwts.parser()
                .verifyWith(getKey()) //này là phần quan trọng nhất, nó sẽ verify token với secret key
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String userName = extractUsername(token);
        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
}
