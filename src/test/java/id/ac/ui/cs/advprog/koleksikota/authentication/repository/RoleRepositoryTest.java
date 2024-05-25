package id.ac.ui.cs.advprog.koleksikota.authentication.repository;

import id.ac.ui.cs.advprog.koleksikota.authentication.models.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(locations = "classpath:application-test.properties")
class RoleRepositoryTest {

    @Autowired
    private RoleRepository roleRepository;

    @BeforeEach
    void setUp() {
        Role role = new Role();
        role.setName("USER");
        roleRepository.save(role);
    }

    @Test
    void testFindByName() {
        Optional<Role> role = roleRepository.findByName("USER");
        assertTrue(role.isPresent());
    }
}
