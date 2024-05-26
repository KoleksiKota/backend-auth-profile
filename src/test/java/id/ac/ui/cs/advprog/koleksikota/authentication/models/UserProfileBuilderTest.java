package id.ac.ui.cs.advprog.koleksikota.authentication.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserProfileBuilderTest {

    @Test
    void testToString() {
        UserProfile.UserProfileBuilder builder = UserProfile.builder()
                .fullName("Test User")
                .phoneNumber("1234567890")
                .address("Test Address");

        String expectedToString = "UserProfile.UserProfileBuilder(fullName=Test User, phoneNumber=1234567890, address=Test Address, user=null)";
        assertEquals(expectedToString, builder.toString());
    }
}
