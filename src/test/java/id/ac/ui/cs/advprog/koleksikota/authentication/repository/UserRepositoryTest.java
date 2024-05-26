package id.ac.ui.cs.advprog.koleksikota.authentication.repository;

import id.ac.ui.cs.advprog.koleksikota.authentication.models.UserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(locations = "classpath:application-test.properties")
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        UserEntity user = new UserEntity();
        user.setUsername("testuser");
        user.setPassword("password");
        userRepository.save(user);
    }

    @Test
    void testFindByUsername() {
        Optional<UserEntity> user = userRepository.findByUsername("testuser");
        assertTrue(user.isPresent());
    }

    @Test
    void testExistsByUsername() {
        Boolean exists = userRepository.existsByUsername("testuser");
        assertTrue(exists);

        exists = userRepository.existsByUsername("nonexistentuser");
        assertFalse(exists);
    }
}
