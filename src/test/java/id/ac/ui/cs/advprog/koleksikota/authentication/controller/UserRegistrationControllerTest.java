package id.ac.ui.cs.advprog.koleksikota.authentication.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserRegistrationController.class)
public class UserRegistrationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnRegistrationPage() throws Exception {
        mockMvc.perform(get("/register"))
                .andExpect(status().isOk());
    }
}
