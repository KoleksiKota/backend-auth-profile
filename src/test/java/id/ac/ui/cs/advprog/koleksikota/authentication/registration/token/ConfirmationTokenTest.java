package id.ac.ui.cs.advprog.koleksikota.authentication.registration.token;

import id.ac.ui.cs.advprog.koleksikota.authentication.appuser.AppUser;
import id.ac.ui.cs.advprog.koleksikota.authentication.registration.token.ConfirmationToken;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ConfirmationTokenTest {

    @Test
    void itShouldCreateConfirmationToken() {
        // Given
        String token = "sampleToken";
        LocalDateTime createdAt = LocalDateTime.now();
        LocalDateTime expiresAt = createdAt.plusHours(24);
        AppUser appUser = new AppUser();

        // When
        ConfirmationToken confirmationToken = new ConfirmationToken(token, createdAt, expiresAt, appUser);

        // Then
        assertNotNull(confirmationToken);
        assertEquals(token, confirmationToken.getToken());
        assertEquals(createdAt, confirmationToken.getCreatedAt());
        assertEquals(expiresAt, confirmationToken.getExpiresAt());
        assertEquals(appUser, confirmationToken.getAppUser());
    }
}
