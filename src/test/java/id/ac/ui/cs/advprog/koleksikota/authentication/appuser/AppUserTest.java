package id.ac.ui.cs.advprog.koleksikota.authentication.appuser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class AppUserTest {

    private AppUser appUser;

    @BeforeEach
    void setUp() {
        appUser = new AppUser("John", "Doe", "john.doe@example.com", "password", AppUserRole.USER);
    }

    @Test
    void testGetAuthorities() {
        Collection<? extends SimpleGrantedAuthority> authorities = appUser.getAuthorities();
        assertEquals(1, authorities.size());
        assertTrue(authorities.contains(new SimpleGrantedAuthority(AppUserRole.USER.name())));
    }

    @Test
    void testGetPassword() {
        assertEquals("password", appUser.getPassword());
    }

    @Test
    void testGetUsername() {
        assertEquals("john.doe@example.com", appUser.getUsername());
    }

    @Test
    void testGetFirstName() {
        assertEquals("John", appUser.getFirstName());
    }

    @Test
    void testGetLastName() {
        assertEquals("Doe", appUser.getLastName());
    }

    @Test
    void testIsAccountNonExpired() {
        assertTrue(appUser.isAccountNonExpired());
    }

    @Test
    void testIsAccountNonLocked() {
        assertTrue(appUser.isAccountNonLocked());
    }

    @Test
    void testIsCredentialsNonExpired() {
        assertTrue(appUser.isCredentialsNonExpired());
    }

    @Test
    void testIsEnabled() {
        assertFalse(appUser.isEnabled());
    }
}
