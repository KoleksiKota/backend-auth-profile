package id.ac.ui.cs.advprog.koleksikota.authentication.registration;

import id.ac.ui.cs.advprog.koleksikota.authentication.registration.RegistrationRequest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RegistrationRequestTest {

    @Test
    void itShouldCreateRegistrationRequest() {
        // Given
        String firstName = "John";
        String lastName = "Doe";
        String email = "john.doe@example.com";
        String password = "password123";

        // When
        RegistrationRequest request = new RegistrationRequest(firstName, lastName, email, password);

        // Then
        assertNotNull(request);
        assertEquals(firstName, request.getFirstName());
        assertEquals(lastName, request.getLastName());
        assertEquals(email, request.getEmail());
        assertEquals(password, request.getPassword());
    }
}
