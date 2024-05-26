package id.ac.ui.cs.advprog.koleksikota.authentication.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.security.core.AuthenticationException;

import java.io.IOException;

import static org.mockito.Mockito.*;

class JwtAuthEntryPointTest {

    private JwtAuthEntryPoint jwtAuthEntryPoint;

    @BeforeEach
    void setUp() {
        jwtAuthEntryPoint = new JwtAuthEntryPoint();
    }

    @Test
    void testCommenceWithException() throws ServletException, IOException {
        // Mock request and response
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        // Mock authentication exception
        AuthenticationException authException = mock(AuthenticationException.class);
        String errorMessage = "Unauthorized";
        when(authException.getMessage()).thenReturn(errorMessage);

        // Call the commence method
        jwtAuthEntryPoint.commence(request, response, authException);

        // Verify that sendError method is called with the correct parameters
        verify(response).sendError(HttpServletResponse.SC_UNAUTHORIZED, errorMessage);
    }

}
