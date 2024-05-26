package id.ac.ui.cs.advprog.koleksikota.authentication.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserProfileDtoTest {

    @Test
    public void testUserProfileDto() {
        UserProfileDto userProfileDto = new UserProfileDto();
        userProfileDto.setFullName("John Doe");
        userProfileDto.setPhoneNumber("123456789");
        userProfileDto.setAddress("123 Street Name");

        assertEquals("John Doe", userProfileDto.getFullName());
        assertEquals("123456789", userProfileDto.getPhoneNumber());
        assertEquals("123 Street Name", userProfileDto.getAddress());
    }

    @Test
    public void testEqualsAndHashCode() {
        UserProfileDto userProfileDto1 = new UserProfileDto();
        userProfileDto1.setFullName("John Doe");
        userProfileDto1.setPhoneNumber("123456789");
        userProfileDto1.setAddress("123 Street Name");

        UserProfileDto userProfileDto2 = new UserProfileDto();
        userProfileDto2.setFullName("John Doe");
        userProfileDto2.setPhoneNumber("123456789");
        userProfileDto2.setAddress("123 Street Name");

        UserProfileDto userProfileDto3 = new UserProfileDto();
        userProfileDto3.setFullName("Jane Doe");
        userProfileDto3.setPhoneNumber("987654321");
        userProfileDto3.setAddress("321 Street Name");

        // Null handling
        assertNotEquals(userProfileDto1, null);
        // Self comparison
        assertEquals(userProfileDto1, userProfileDto1);
        // Different types
        assertNotEquals(userProfileDto1, new Object());
        // Consistency
        assertEquals(userProfileDto1, userProfileDto2);
        assertEquals(userProfileDto1.hashCode(), userProfileDto2.hashCode());
        assertNotEquals(userProfileDto1, userProfileDto3);
        assertNotEquals(userProfileDto1.hashCode(), userProfileDto3.hashCode());

        // Symmetry
        assertTrue(userProfileDto1.equals(userProfileDto2) && userProfileDto2.equals(userProfileDto1));
        // Transitivity
        UserProfileDto userProfileDto4 = new UserProfileDto();
        userProfileDto4.setFullName("John Doe");
        userProfileDto4.setPhoneNumber("123456789");
        userProfileDto4.setAddress("123 Street Name");
        assertTrue(userProfileDto1.equals(userProfileDto2) && userProfileDto2.equals(userProfileDto4) && userProfileDto1.equals(userProfileDto4));
    }

    @Test
    public void testToString() {
        UserProfileDto userProfileDto = new UserProfileDto();
        userProfileDto.setFullName("John Doe");
        userProfileDto.setPhoneNumber("123456789");
        userProfileDto.setAddress("123 Street Name");

        String expected = "UserProfileDto(fullName=John Doe, phoneNumber=123456789, address=123 Street Name)";
        assertEquals(expected, userProfileDto.toString());
    }

    @Test
    public void testCanEqual() {
        UserProfileDto userProfileDto1 = new UserProfileDto();
        UserProfileDto userProfileDto2 = new UserProfileDto();

        assertTrue(userProfileDto1.canEqual(userProfileDto2));
        assertFalse(userProfileDto1.canEqual(new Object()));
    }
}
