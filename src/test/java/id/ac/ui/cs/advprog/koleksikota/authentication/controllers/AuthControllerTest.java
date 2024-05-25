package id.ac.ui.cs.advprog.koleksikota.authentication.controllers;

import id.ac.ui.cs.advprog.koleksikota.authentication.dto.AuthResponseDTO;
import id.ac.ui.cs.advprog.koleksikota.authentication.dto.LoginDto;
import id.ac.ui.cs.advprog.koleksikota.authentication.dto.RegisterDto;
import id.ac.ui.cs.advprog.koleksikota.authentication.models.Role;
import id.ac.ui.cs.advprog.koleksikota.authentication.models.UserEntity;
import id.ac.ui.cs.advprog.koleksikota.authentication.repository.RoleRepository;
import id.ac.ui.cs.advprog.koleksikota.authentication.repository.UserRepository;
import id.ac.ui.cs.advprog.koleksikota.authentication.security.JWTGenerator;
import id.ac.ui.cs.advprog.koleksikota.authentication.security.TokenBlacklist;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class AuthControllerTest {

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private JWTGenerator jwtGenerator;

    @Mock
    private TokenBlacklist tokenBlacklist;

    @InjectMocks
    private AuthController authController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testLogin() {
        LoginDto loginDto = new LoginDto();
        loginDto.setUsername("testuser");
        loginDto.setPassword("password");

        Authentication authentication = mock(Authentication.class);
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class))).thenReturn(authentication);
        when(jwtGenerator.generateToken(authentication)).thenReturn("mocked-token");

        ResponseEntity<AuthResponseDTO> response = authController.login(loginDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("mocked-token", response.getBody().getAccessToken());
    }

    @Test
    void testRegister() {
        RegisterDto registerDto = new RegisterDto();
        registerDto.setUsername("newuser");
        registerDto.setPassword("newpassword");

        when(userRepository.existsByUsername("newuser")).thenReturn(false);
        when(roleRepository.findByName("USER")).thenReturn(Optional.of(new Role()));
        when(passwordEncoder.encode("newpassword")).thenReturn("encodedpassword");

        ResponseEntity<String> response = authController.register(registerDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("User registered success", response.getBody());
    }

    @Test
    void testRegisterWithInvalidUsername() {
        RegisterDto registerDto = new RegisterDto();
        registerDto.setUsername("invalid username");
        registerDto.setPassword("password");

        ResponseEntity<String> response = authController.register(registerDto);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Username hanya boleh berisi huruf, angka, underscore, dan titik", response.getBody());
    }

    @Test
    void testRegisterWithShortPassword() {
        RegisterDto registerDto = new RegisterDto();
        registerDto.setUsername("username");
        registerDto.setPassword("short");

        ResponseEntity<String> response = authController.register(registerDto);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Password harus memiliki panjang minimal 8 karakter", response.getBody());
    }
}
