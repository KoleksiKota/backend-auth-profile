package id.ac.ui.cs.advprog.koleksikota.authentication;

import id.ac.ui.cs.advprog.koleksikota.authentication.model.User;
import id.ac.ui.cs.advprog.koleksikota.authentication.repository.UserRepository;
import id.ac.ui.cs.advprog.koleksikota.authentication.service.CustomUserDetailsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class CustomUserDetailsServiceTest {

    private UserRepository mockUserRepo;
    private CustomUserDetailsService userDetailsService;

    @BeforeEach
    public void setUp() {
        mockUserRepo = Mockito.mock(UserRepository.class);
        userDetailsService = new CustomUserDetailsService();
        ReflectionTestUtils.setField(userDetailsService, "userRepo", mockUserRepo);
    }

    @Test
    public void testLoadUserByUsername_UserExists() {
        User mockUser = new User();
        mockUser.setEmail("test@example.com");
        mockUser.setPassword("password");

        when(mockUserRepo.findByEmail("test@example.com")).thenReturn(mockUser);

        UserDetails userDetails = userDetailsService.loadUserByUsername("test@example.com");

        assertEquals(mockUser.getEmail(), userDetails.getUsername());
        assertEquals(mockUser.getPassword(), userDetails.getPassword());
    }

    @Test
    public void testLoadUserByUsername_UserDoesNotExist() {
        when(mockUserRepo.findByEmail("test@example.com")).thenReturn(null);

        assertThrows(UsernameNotFoundException.class, () -> {
            userDetailsService.loadUserByUsername("test@example.com");
        });
    }
}
