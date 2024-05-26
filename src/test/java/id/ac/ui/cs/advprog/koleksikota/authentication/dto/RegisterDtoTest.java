package id.ac.ui.cs.advprog.koleksikota.authentication.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RegisterDtoTest {

    @Test
    public void testRegisterDto() {
        RegisterDto registerDto = new RegisterDto();
        registerDto.setUsername("testUser");
        registerDto.setPassword("testPass");

        assertEquals("testUser", registerDto.getUsername());
        assertEquals("testPass", registerDto.getPassword());
    }

    @Test
    public void testEqualsAndHashCode() {
        RegisterDto registerDto1 = new RegisterDto();
        registerDto1.setUsername("user1");
        registerDto1.setPassword("pass1");

        RegisterDto registerDto2 = new RegisterDto();
        registerDto2.setUsername("user1");
        registerDto2.setPassword("pass1");

        RegisterDto registerDto3 = new RegisterDto();
        registerDto3.setUsername("user2");
        registerDto3.setPassword("pass2");

        // Null handling
        assertNotEquals(registerDto1, null);
        // Self comparison
        assertEquals(registerDto1, registerDto1);
        // Different types
        assertNotEquals(registerDto1, new Object());
        // Consistency
        assertEquals(registerDto1, registerDto2);
        assertEquals(registerDto1.hashCode(), registerDto2.hashCode());
        assertNotEquals(registerDto1, registerDto3);
        assertNotEquals(registerDto1.hashCode(), registerDto3.hashCode());

        // Symmetry
        assertTrue(registerDto1.equals(registerDto2) && registerDto2.equals(registerDto1));
        // Transitivity
        RegisterDto registerDto4 = new RegisterDto();
        registerDto4.setUsername("user1");
        registerDto4.setPassword("pass1");
        assertTrue(registerDto1.equals(registerDto2) && registerDto2.equals(registerDto4) && registerDto1.equals(registerDto4));
    }

    @Test
    public void testToString() {
        RegisterDto registerDto = new RegisterDto();
        registerDto.setUsername("testUser");
        registerDto.setPassword("testPass");

        String expected = "RegisterDto(username=testUser, password=testPass)";
        assertEquals(expected, registerDto.toString());
    }

    @Test
    public void testCanEqual() {
        RegisterDto registerDto1 = new RegisterDto();
        RegisterDto registerDto2 = new RegisterDto();

        assertTrue(registerDto1.canEqual(registerDto2));
        assertFalse(registerDto1.canEqual(new Object()));
    }
}
