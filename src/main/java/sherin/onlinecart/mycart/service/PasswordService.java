package sherin.onlinecart.mycart.service;

import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {

    // Parameters: salt length, hash length, parallelism, memory (KB), iterations
    private final Argon2PasswordEncoder encoder = new Argon2PasswordEncoder(16, 32, 1, 65536, 3);

    public String hashPassword(String password) {
        return encoder.encode(password);
    }

    public boolean verifyPassword(String rawPassword, String encodedPassword) {
        return encoder.matches(rawPassword, encodedPassword);
    }
}
/*
 * saltLength = 16 → Random 16-byte salt for uniqueness.
 * hashLength = 32 → Generates a 32-byte hash.
 * parallelism = 1 → Single-threaded execution (increase for multi-threading).
 * memory = 65536 → Uses 64MB RAM (higher = better security).
 * iterations = 3 → Runs the algorithm 3 times (higher = slower but safer).
 */
