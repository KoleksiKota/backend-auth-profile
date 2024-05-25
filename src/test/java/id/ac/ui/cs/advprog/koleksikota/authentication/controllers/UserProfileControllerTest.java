package id.ac.ui.cs.advprog.koleksikota.authentication.controllers;

import id.ac.ui.cs.advprog.koleksikota.authentication.dto.UserProfileDto;
import id.ac.ui.cs.advprog.koleksikota.authentication.models.UserEntity;
import id.ac.ui.cs.advprog.koleksikota.authentication.repository.UserRepository;
import id.ac.ui.cs.advprog.koleksikota.authentication.service.UserProfileService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserProfileControllerTest {

    @Mock
    private UserProfileService userProfileService;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserProfileController userProfileController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateProfile() {
        String username = "testuser";
        UserProfileDto userProfileDto = new UserProfileDto();
        UserEntity user = new UserEntity();
        user.setUsername(username);

        when(userRepository.findByUsername(username)).thenReturn(Optional.of(user));

        ResponseEntity<String> response = userProfileController.createProfile(username, userProfileDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("User profile created successfully", response.getBody());
        verify(userProfileService, times(1)).createUserProfile(user, userProfileDto);
    }

    @Test
    void testCreateProfileUserNotFound() {
        String username = "nonexistentuser";
        UserProfileDto userProfileDto = new UserProfileDto();

        when(userRepository.findByUsername(username)).thenReturn(Optional.empty());

        ResponseEntity<String> response = userProfileController.createProfile(username, userProfileDto);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("User not found", response.getBody());
    }

    @Test
    void testGetProfile() {
        String username = "testuser";
        UserProfileDto userProfileDto = new UserProfileDto();
        userProfileDto.setFullName("Test User");

        when(userProfileService.getUserProfileByUsername(username)).thenReturn(userProfileDto);

        ResponseEntity<UserProfileDto> response = userProfileController.getProfile(username);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(userProfileDto, response.getBody());
    }

    @Test
    void testGetProfileUserNotFound() {
        String username = "nonexistentuser";

        when(userProfileService.getUserProfileByUsername(username)).thenReturn(null);

        ResponseEntity<UserProfileDto> response = userProfileController.getProfile(username);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }
}
