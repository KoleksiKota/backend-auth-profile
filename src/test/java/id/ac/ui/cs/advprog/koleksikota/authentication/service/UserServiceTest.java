package id.ac.ui.cs.advprog.koleksikota.authentication.service;

import id.ac.ui.cs.advprog.koleksikota.authentication.model.User;
import id.ac.ui.cs.advprog.koleksikota.authentication.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    public void testUserRegistration() {
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password");

        when(userRepository.save(any())).thenReturn(user);
        when(bCryptPasswordEncoder.encode(any())).thenReturn("encryptedPassword");

        User registeredUser = userService.register(user);

        assertEquals(user.getEmail(), registeredUser.getEmail());
        verify(userRepository, times(1)).save(any());
    }
}
