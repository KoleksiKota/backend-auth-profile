package id.ac.ui.cs.advprog.koleksikota.authentication;

import id.ac.ui.cs.advprog.koleksikota.authentication.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomUserDetailsTest {

    private User mockUser;
    private CustomUserDetails userDetails;

    @BeforeEach
    public void setUp() {
        mockUser = Mockito.mock(User.class);
        userDetails = new CustomUserDetails(mockUser);
    }

    @Test
    public void testGetAuthorities() {
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        assertTrue(authorities.isEmpty());
    }

    @Test
    public void testGetPassword() {
        Mockito.when(mockUser.getPassword()).thenReturn("password");
        assertEquals("password", userDetails.getPassword());
    }

    @Test
    public void testGetUsername() {
        Mockito.when(mockUser.getEmail()).thenReturn("email");
        assertEquals("email", userDetails.getUsername());
    }

    @Test
    public void testIsAccountNonExpired() {
        assertTrue(userDetails.isAccountNonExpired());
    }

    @Test
    public void testIsAccountNonLocked() {
        assertTrue(userDetails.isAccountNonLocked());
    }

    @Test
    public void testIsCredentialsNonExpired() {
        assertTrue(userDetails.isCredentialsNonExpired());
    }

    @Test
    public void testIsEnabled() {
        assertTrue(userDetails.isEnabled());
    }

    @Test
    public void testGetFullName() {
        Mockito.when(mockUser.getFirstName()).thenReturn("First");
        Mockito.when(mockUser.getLastName()).thenReturn("Last");
        assertEquals("First Last", userDetails.getFullName());
    }
}
