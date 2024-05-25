package id.ac.ui.cs.advprog.koleksikota.authentication.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoleTest {

    @Test
    void testRole() {
        Role role = new Role();
        role.setId(1);
        role.setName("USER");

        assertEquals(1, role.getId());
        assertEquals("USER", role.getName());
    }
}
