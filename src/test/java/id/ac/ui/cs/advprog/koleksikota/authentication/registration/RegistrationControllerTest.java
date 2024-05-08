package id.ac.ui.cs.advprog.koleksikota.authentication.registration;

import id.ac.ui.cs.advprog.koleksikota.authentication.registration.RegistrationController;
import id.ac.ui.cs.advprog.koleksikota.authentication.registration.RegistrationRequest;
import id.ac.ui.cs.advprog.koleksikota.authentication.registration.RegistrationService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RegistrationController.class)
public class RegistrationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RegistrationService registrationService;

    @Test
    public void itShouldRegisterUser() throws Exception {
        // Given
        RegistrationRequest request = new RegistrationRequest("rifda", "aulia", "test@gmail.com", "password");

        // When
        Mockito.when(registrationService.register(request)).thenReturn("User registered");

        // Then
        mockMvc.perform(post("/api/v1/registration")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"email\":\"test@test.com\",\"password\":\"password\",\"username\":\"test\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("User registered"));
    }

    @Test
    public void itShouldConfirmToken() throws Exception {
        // Given
        String token = "sampleToken";

        // When
        Mockito.when(registrationService.confirmToken(token)).thenReturn("Token confirmed");

        // Then
        mockMvc.perform(get("/api/v1/registration/confirm")
                        .param("token", token))
                .andExpect(status().isOk())
                .andExpect(content().string("Token confirmed"));
    }
}
