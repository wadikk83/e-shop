package by.nekhviadovich.store.utils;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class JwtUtils {

    public static void main(String[] args) {
        final String password = "manager";
        System.out.println("Encode password " + password + " ->" + generatePassword(password));
        System.out.println(generateKey());
    }

    private static String generateKey() {
        return Encoders.BASE64.encode(Keys.secretKeyFor(SignatureAlgorithm.HS512).getEncoded());
    }

    private static String generatePassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}
