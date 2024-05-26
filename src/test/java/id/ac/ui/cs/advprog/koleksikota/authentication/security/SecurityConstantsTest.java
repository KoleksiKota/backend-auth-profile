package id.ac.ui.cs.advprog.koleksikota.authentication.security;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class SecurityConstantsTest {

    @Test
    void testJwtExpiration() {
        // Check if the JWT_EXPIRATION constant has the correct value
        assertEquals(700000, SecurityConstants.JWT_EXPIRATION);
    }

    @Test
    void testJwtExpirationExists() throws NoSuchFieldException {
        // Check if the JWT_EXPIRATION constant exists
        Field field = SecurityConstants.class.getDeclaredField("JWT_EXPIRATION");
        assertNotNull(field);
        assertTrue(java.lang.reflect.Modifier.isStatic(field.getModifiers()));
        assertTrue(java.lang.reflect.Modifier.isFinal(field.getModifiers()));
    }
}
