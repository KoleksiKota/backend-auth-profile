package id.ac.ui.cs.advprog.koleksikota.authentication.registration;

import id.ac.ui.cs.advprog.koleksikota.authentication.appuser.AppUser;
import id.ac.ui.cs.advprog.koleksikota.authentication.appuser.AppUserRole;
import id.ac.ui.cs.advprog.koleksikota.authentication.appuser.AppUserService;
import id.ac.ui.cs.advprog.koleksikota.authentication.email.EmailSender;
import id.ac.ui.cs.advprog.koleksikota.authentication.registration.token.ConfirmationToken;
import id.ac.ui.cs.advprog.koleksikota.authentication.registration.token.ConfirmationTokenService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class RegistrationServiceTest {

    @MockBean
    private AppUserService appUserService;

    @MockBean
    private EmailValidator emailValidator;

    @MockBean
    private ConfirmationTokenService confirmationTokenService;

    @MockBean
    private EmailSender emailSender;

    @Test
    public void itShouldRegisterUser() {
        // Given
        RegistrationRequest request = new RegistrationRequest("John", "Doe", "john.doe@example.com", "password123");
        AppUser user = new AppUser("John", "Doe", "john.doe@example.com", "password123", AppUserRole.USER);
        ConfirmationToken token = new ConfirmationToken("sampleToken", LocalDateTime.now(), LocalDateTime.now().plusMinutes(15), user);
        RegistrationService registrationService = new RegistrationService(appUserService, emailValidator, confirmationTokenService, emailSender);

        when(emailValidator.test(request.getEmail())).thenReturn(true);
        when(appUserService.signUpUser(any(AppUser.class))).thenReturn(token.getToken());

        // When
        String resultToken = registrationService.register(request);

        // Then
        assertNotNull(resultToken);
        assertEquals(token.getToken(), resultToken);
    }

    @Test
    public void itShouldConfirmToken() {
        // Given
        String tokenString = "sampleToken";
        AppUser user = new AppUser("John", "Doe", "john.doe@example.com", "password123", AppUserRole.USER);
        ConfirmationToken token = new ConfirmationToken(tokenString, LocalDateTime.now(), LocalDateTime.now().plusMinutes(15), user);
        RegistrationService registrationService = new RegistrationService(appUserService, emailValidator, confirmationTokenService, emailSender);

        when(confirmationTokenService.getToken(tokenString)).thenReturn(java.util.Optional.of(token));

        // When
        String result = registrationService.confirmToken(tokenString);

        // Then
        assertNotNull(result);
        assertEquals("confirmed", result);
    }
}
