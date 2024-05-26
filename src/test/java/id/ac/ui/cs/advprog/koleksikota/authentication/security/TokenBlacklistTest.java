package id.ac.ui.cs.advprog.koleksikota.authentication.security;

import id.ac.ui.cs.advprog.koleksikota.authentication.security.TokenBlacklist;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TokenBlacklistTest {

    private TokenBlacklist tokenBlacklist;

    @BeforeEach
    void setUp() {
        tokenBlacklist = new TokenBlacklist();
    }

    @Test
    void addToken_TokenIsAdded() {
        // Arrange
        String token = "testToken";

        // Act
        tokenBlacklist.add(token);

        // Assert
        assertTrue(tokenBlacklist.contains(token));
    }

    @Test
    void contains_NonExistentToken_ReturnsFalse() {
        // Arrange
        String token = "nonExistentToken";

        // Act & Assert
        assertFalse(tokenBlacklist.contains(token));
    }
}