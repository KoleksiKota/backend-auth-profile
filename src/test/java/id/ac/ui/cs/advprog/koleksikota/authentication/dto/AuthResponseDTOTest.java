package id.ac.ui.cs.advprog.koleksikota.authentication.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AuthResponseDTOTest {

    @Test
    public void testAuthResponseDTO() {
        String token = "testAccessToken";
        AuthResponseDTO authResponseDTO = new AuthResponseDTO(token);

        assertEquals(token, authResponseDTO.getAccessToken());
        assertEquals("Bearer ", authResponseDTO.getTokenType());
    }

    @Test
    public void testSetters() {
        AuthResponseDTO authResponseDTO = new AuthResponseDTO("initialToken");
        authResponseDTO.setAccessToken("newAccessToken");
        authResponseDTO.setTokenType("NewType ");

        assertEquals("newAccessToken", authResponseDTO.getAccessToken());
        assertEquals("NewType ", authResponseDTO.getTokenType());
    }

    @Test
    public void testEqualsAndHashCode() {
        AuthResponseDTO authResponseDTO1 = new AuthResponseDTO("token1");
        AuthResponseDTO authResponseDTO2 = new AuthResponseDTO("token1");
        AuthResponseDTO authResponseDTO3 = new AuthResponseDTO("token2");

        assertNotEquals(authResponseDTO1, null);
        assertEquals(authResponseDTO1, authResponseDTO1);
        assertNotEquals(authResponseDTO1, new Object());
        assertEquals(authResponseDTO1, authResponseDTO2);
        assertEquals(authResponseDTO1.hashCode(), authResponseDTO2.hashCode());
        assertNotEquals(authResponseDTO1, authResponseDTO3);
        assertNotEquals(authResponseDTO1.hashCode(), authResponseDTO3.hashCode());

        assertTrue(authResponseDTO1.equals(authResponseDTO2) && authResponseDTO2.equals(authResponseDTO1));
        AuthResponseDTO authResponseDTO4 = new AuthResponseDTO("token1");
        assertTrue(authResponseDTO1.equals(authResponseDTO2) && authResponseDTO2.equals(authResponseDTO4) && authResponseDTO1.equals(authResponseDTO4));
    }

    @Test
    public void testToString() {
        AuthResponseDTO authResponseDTO = new AuthResponseDTO("token");
        String expected = "AuthResponseDTO(accessToken=token, tokenType=Bearer )";
        assertEquals(expected, authResponseDTO.toString());
    }

    @Test
    public void testCanEqual() {
        AuthResponseDTO authResponseDTO1 = new AuthResponseDTO("token1");
        AuthResponseDTO authResponseDTO2 = new AuthResponseDTO("token1");

        assertTrue(authResponseDTO1.canEqual(authResponseDTO2));
        assertFalse(authResponseDTO1.canEqual(new Object()));
    }
}
