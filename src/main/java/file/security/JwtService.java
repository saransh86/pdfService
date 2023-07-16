package file.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class JwtService{

    @Value("${token.signing.key}")
    private String jwtSigningKey;

    public Jws<Claims> validateToken(String token){
        String secret = Base64.getEncoder().encodeToString(jwtSigningKey.getBytes());
        Jws<Claims> jwtToken = Jwts.parserBuilder()
                .setSigningKey(secret)
                .build()
                .parseClaimsJws(token);
        return jwtToken;
    }

}
