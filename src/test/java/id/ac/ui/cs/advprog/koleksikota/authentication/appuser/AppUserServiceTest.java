package id.ac.ui.cs.advprog.koleksikota.authentication.appuser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AppUserServiceTest {

    @Mock
    private AppUserRepository appUserRepository;
    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Mock
    private ConfirmationTokenService confirmationTokenService;

    private AppUserService underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        underTest = new AppUserService(appUserRepository, bCryptPasswordEncoder, confirmationTokenService);
    }

    @Test
    void itShouldSelectExistingUserByEmail() {
        // given
        String email = "test@test.com";
        AppUser appUser = new AppUser();
        appUser.setEmail(email);

        when(appUserRepository.findByEmail(email))
                .thenReturn(Optional.of(appUser));

        // when
        UserDetails returnedUser = underTest.loadUserByUsername(email);

        // then
        assertEquals(appUser, returnedUser);
    }

    @Test
    void itShouldThrowWhenEmailDoesNotExist() {
        // given
        String email = "test@test.com";

        when(appUserRepository.findByEmail(email))
                .thenReturn(Optional.empty());

        // when
        // then
        assertThrows(UsernameNotFoundException.class, () -> underTest.loadUserByUsername(email));
    }

    // TODO: Add more tests for signUpUser and enableAppUser methods
}
