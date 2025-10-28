package be.burundiroots.BRBLBackEnd.il.utils;

import be.burundiroots.BRBLBackEnd.dl.entities.User;
import be.burundiroots.BRBLBackEnd.dl.enums.UserRole;
import be.burundiroots.BRBLBackEnd.il.configs.JwtConfig;
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
    private final JwtConfig config;

    public JwtUtil(JwtConfig config){
        this.config = config;
        builder = Jwts.builder().signWith(config.secretKey);
        parser = Jwts.parser().verifyWith(config.secretKey).build();
    }

    public String generateToken(User user) {

        return builder
                .subject(user.getEmail())
                .claim("id", user.getId())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()* config.expireAt))
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
