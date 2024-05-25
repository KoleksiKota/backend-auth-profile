package id.ac.ui.cs.advprog.koleksikota.authentication.repository;

import id.ac.ui.cs.advprog.koleksikota.authentication.models.UserEntity;
import id.ac.ui.cs.advprog.koleksikota.authentication.models.UserProfile;
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
class UserProfileRepositoryTest {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        UserEntity user = new UserEntity();
        user.setUsername("testuser");
        user.setPassword("password");
        userRepository.save(user);

        UserProfile profile = UserProfile.builder()
                .fullName("Test User")
                .phoneNumber("1234567890")
                .address("Test Address")
                .user(user)
                .build();
        userProfileRepository.save(profile);
    }

    @Test
    void testFindByUser_Username() {
        Optional<UserProfile> profile = userProfileRepository.findByUser_Username("testuser");
        assertTrue(profile.isPresent());
    }
}
