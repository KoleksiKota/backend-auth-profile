package id.ac.ui.cs.advprog.koleksikota.authentication.models;

import id.ac.ui.cs.advprog.koleksikota.authentication.models.Role;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoleTest {

    @Test
    void testRoleMethods() {
        Role role = new Role();
        role.setId(1);
        role.setName("USER");

        assertEquals(1, role.getId());
        assertEquals("USER", role.getName());
    }

    @Test
    void testRoleConstructor() {
        Role role = new Role();

        assertEquals(0, role.getId());
        assertEquals(null, role.getName());
    }
}