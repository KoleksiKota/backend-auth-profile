package id.ac.ui.cs.advprog.koleksikota.authentication;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class AuthenticationApplicationTest {

    @Test
    public void testMainMethod() {
        assertDoesNotThrow(() -> AuthenticationApplication.main(new String[]{}));
    }
}
