package be.burundiroots.BRBLBackEnd.il.configs;

import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

@Component
public class JwtConfig {

    private String secret = "Maââââââââââââââââââââââââât";
    public int expireAt = 86400000;
    public SecretKey secretKey = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
}
