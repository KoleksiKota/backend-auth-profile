package id.ac.ui.cs.advprog.koleksikota.authentication.security;

import id.ac.ui.cs.advprog.koleksikota.authentication.security.JWTGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class JWTGeneratorTest {

    @Mock
    private Authentication authentication;

    @InjectMocks
    private JWTGenerator jwtGenerator;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGenerateToken() {
        when(authentication.getName()).thenReturn("testUser");

        String token = jwtGenerator.generateToken(authentication);

        assertNotNull(token);
        assertTrue(token.length() > 0);
    }

    @Test
    void testGetUsernameFromJWT() {
        String token = jwtGenerator.generateToken(authentication);

        assertNotNull(token);
        assertTrue(token.length() > 0);
    }


    @Test
    void testValidateToken() {
        String token = jwtGenerator.generateToken(authentication);

        boolean isValid = jwtGenerator.validateToken(token);

        assertTrue(isValid);
    }

    @Test
    void testValidateInvalidToken() {
        String invalidToken = "invalidToken";

        AuthenticationCredentialsNotFoundException exception = assertThrows(
                AuthenticationCredentialsNotFoundException.class,
                () -> jwtGenerator.validateToken(invalidToken)
        );

        assertEquals("JWT was expired or incorrect", exception.getMessage());
    }
}
