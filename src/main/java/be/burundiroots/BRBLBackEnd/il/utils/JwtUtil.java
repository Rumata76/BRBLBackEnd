package be.burundiroots.BRBLBackEnd.il.utils;

import be.burundiroots.BRBLBackEnd.dl.entities.User;
import be.burundiroots.BRBLBackEnd.dl.enums.UserRole;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.List;

@Component
public class JwtUtil {

    private final JwtBuilder builder;
    private final JwtParser parser;

    public JwtUtil() {
        String secret = "Mâaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaat";
        SecretKey secretKey = new SecretKeySpec(secret.getBytes(),"HmacSHA256");
        builder = Jwts.builder().signWith(secretKey);
        parser = Jwts.parser().verifyWith(secretKey).build();
    }

    public String generateToken(User user) {
        int expiresAt = 86400000;
        return builder
                .subject(user.getUsername())
                .claim("id", user.getId())
                .claim("roles", user.getRoles())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()* expiresAt))
                .compact();
    }

    public Claims getClaims(String token) {
        return parser.parseSignedClaims(token).getPayload();
    }

    public String getEmail(String token) {
        return getClaims(token).getSubject();
    }

    public Long getUserId(String token) {
        return getClaims(token).get("id", Long.class);
    }

    public List<UserRole> getRoles(String token) {
        List<?> rawRoles = getClaims(token).get("roles", List.class);

        return rawRoles.stream()
                .map( r -> UserRole.valueOf(r.toString()))
                .toList();
    }

    public boolean isValid(String token) {
        Claims claims = getClaims(token);

        Date now = new Date();

        return now.after(claims.getIssuedAt()) && now.before(claims.getExpiration());
    }
}
