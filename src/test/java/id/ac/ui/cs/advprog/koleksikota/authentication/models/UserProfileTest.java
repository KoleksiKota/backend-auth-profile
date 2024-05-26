package id.ac.ui.cs.advprog.koleksikota.authentication.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserProfileTest {

    @Test
    void testUserProfileMethods() {
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

    @Test
    void testUserProfileConstructor() {
        UserProfile profile = new UserProfile();

        assertEquals(0, profile.getId());
        assertEquals(null, profile.getFullName());
        assertEquals(null, profile.getPhoneNumber());
        assertEquals(null, profile.getAddress());
        assertEquals(null, profile.getUser());
    }

    @Test
    void testSetterMethods() {
        UserProfile profile = new UserProfile();
        UserEntity user = new UserEntity();
        user.setId(1);
        profile.setUser(user);

        profile.setId(1);
        profile.setFullName("Test User");
        profile.setPhoneNumber("1234567890");
        profile.setAddress("Test Address");

        assertEquals(1, profile.getId());
        assertEquals("Test User", profile.getFullName());
        assertEquals("1234567890", profile.getPhoneNumber());
        assertEquals("Test Address", profile.getAddress());
        assertEquals(user, profile.getUser());
    }
}