package id.ac.ui.cs.advprog.koleksikota.authentication.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginDtoTest {

    @Test
    public void testLoginDto() {
        LoginDto loginDto = new LoginDto();
        loginDto.setUsername("testUser");
        loginDto.setPassword("testPass");

        assertEquals("testUser", loginDto.getUsername());
        assertEquals("testPass", loginDto.getPassword());
    }

    @Test
    public void testEqualsAndHashCode() {
        LoginDto loginDto1 = new LoginDto();
        loginDto1.setUsername("user1");
        loginDto1.setPassword("pass1");

        LoginDto loginDto2 = new LoginDto();
        loginDto2.setUsername("user1");
        loginDto2.setPassword("pass1");

        LoginDto loginDto3 = new LoginDto();
        loginDto3.setUsername("user2");
        loginDto3.setPassword("pass2");

        // Null handling
        assertNotEquals(loginDto1, null);
        // Self comparison
        assertEquals(loginDto1, loginDto1);
        // Different types
        assertNotEquals(loginDto1, new Object());
        // Consistency
        assertEquals(loginDto1, loginDto2);
        assertEquals(loginDto1.hashCode(), loginDto2.hashCode());
        assertNotEquals(loginDto1, loginDto3);
        assertNotEquals(loginDto1.hashCode(), loginDto3.hashCode());

        // Symmetry
        assertTrue(loginDto1.equals(loginDto2) && loginDto2.equals(loginDto1));
        // Transitivity
        LoginDto loginDto4 = new LoginDto();
        loginDto4.setUsername("user1");
        loginDto4.setPassword("pass1");
        assertTrue(loginDto1.equals(loginDto2) && loginDto2.equals(loginDto4) && loginDto1.equals(loginDto4));
    }

    @Test
    public void testToString() {
        LoginDto loginDto = new LoginDto();
        loginDto.setUsername("testUser");
        loginDto.setPassword("testPass");

        String expected = "LoginDto(username=testUser, password=testPass)";
        assertEquals(expected, loginDto.toString());
    }

    @Test
    public void testCanEqual() {
        LoginDto loginDto1 = new LoginDto();
        LoginDto loginDto2 = new LoginDto();

        assertTrue(loginDto1.canEqual(loginDto2));
        assertFalse(loginDto1.canEqual(new Object()));
    }
}
