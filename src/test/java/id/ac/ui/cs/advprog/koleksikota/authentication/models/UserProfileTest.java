package id.ac.ui.cs.advprog.koleksikota.authentication.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserProfileTest {

    @Test
    void testUserProfile() {
        UserEntity user = new UserEntity();
        user.setId(1);
        user.setUsername("testuser");

        UserProfile profile = UserProfile.builder()
                .fullName("Test User")
                .phoneNumber("1234567890")
                .address("Test Address")
                .user(user)
                .build();

        assertEquals("Test User", profile.getFullName());
        assertEquals("1234567890", profile.getPhoneNumber());
        assertEquals("Test Address", profile.getAddress());
        assertEquals(user, profile.getUser());
    }
}
