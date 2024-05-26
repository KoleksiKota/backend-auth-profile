package id.ac.ui.cs.advprog.koleksikota.authentication.models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserEntityTest {

    @Test
    void testUserEntity() {
        UserEntity user = new UserEntity();
        user.setId(1);
        user.setUsername("testuser");
        user.setPassword("password");

        Role role = new Role();
        role.setId(1);
        role.setName("USER");

        List<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);

        assertEquals(1, user.getId());
        assertEquals("testuser", user.getUsername());
        assertEquals("password", user.getPassword());
        assertEquals(roles, user.getRoles());
    }

    @Test
    void testEqualsAndHashCode() {
        UserEntity user1 = new UserEntity();
        user1.setId(1);
        user1.setUsername("testuser");

        UserEntity user2 = new UserEntity();
        user2.setId(1);
        user2.setUsername("testuser");

        assertEquals(user1, user2);
        assertEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    void testToString() {
        UserEntity user = new UserEntity();
        user.setId(1);
        user.setUsername("testuser");

        String expectedToString = "UserEntity(id=1, username=testuser, password=null, roles=[])";
        assertEquals(expectedToString, user.toString());
    }
}