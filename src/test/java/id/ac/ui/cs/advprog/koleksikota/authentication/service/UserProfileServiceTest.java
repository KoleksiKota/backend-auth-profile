package id.ac.ui.cs.advprog.koleksikota.authentication.service;

import id.ac.ui.cs.advprog.koleksikota.authentication.dto.UserProfileDto;
import id.ac.ui.cs.advprog.koleksikota.authentication.models.UserEntity;
import id.ac.ui.cs.advprog.koleksikota.authentication.models.UserProfile;
import id.ac.ui.cs.advprog.koleksikota.authentication.repository.UserProfileRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserProfileServiceTest {

    @Mock
    private UserProfileRepository userProfileRepository;

    @InjectMocks
    private UserProfileService userProfileService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetUserProfileByUsername_UserFound() {
        UserEntity user = new UserEntity();
        user.setUsername("testuser");

        UserProfile userProfile = UserProfile.builder()
                .fullName("Test User")
                .phoneNumber("1234567890")
                .address("Test Address")
                .user(user)
                .build();

        when(userProfileRepository.findByUser_Username("testuser")).thenReturn(Optional.of(userProfile));

        UserProfileDto userProfileDto = userProfileService.getUserProfileByUsername("testuser");

        assertNotNull(userProfileDto);
        assertEquals("Test User", userProfileDto.getFullName());
        assertEquals("1234567890", userProfileDto.getPhoneNumber());
        assertEquals("Test Address", userProfileDto.getAddress());
    }

    @Test
    void testGetUserProfileByUsername_UserNotFound() {
        when(userProfileRepository.findByUser_Username("testuser")).thenReturn(Optional.empty());

        UserProfileDto userProfileDto = userProfileService.getUserProfileByUsername("testuser");

        assertNull(userProfileDto);
    }

    @Test
    void testCreateUserProfile() {
        UserEntity user = new UserEntity();
        user.setUsername("testuser");

        UserProfileDto userProfileDto = new UserProfileDto();
        userProfileDto.setFullName("Test User");
        userProfileDto.setPhoneNumber("1234567890");
        userProfileDto.setAddress("Test Address");

        UserProfile userProfile = UserProfile.builder()
                .fullName("Test User")
                .phoneNumber("1234567890")
                .address("Test Address")
                .user(user)
                .build();

        when(userProfileRepository.save(any(UserProfile.class))).thenReturn(userProfile);

        UserProfile createdUserProfile = userProfileService.createUserProfile(user, userProfileDto);

        assertNotNull(createdUserProfile);
        assertEquals("Test User", createdUserProfile.getFullName());
        assertEquals("1234567890", createdUserProfile.getPhoneNumber());
        assertEquals("Test Address", createdUserProfile.getAddress());
    }
}
