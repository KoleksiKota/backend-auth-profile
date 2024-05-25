package id.ac.ui.cs.advprog.koleksikota.authentication.security;

import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class CorsConfigurationTest {

    @Test
    void testCorsConfigurer() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        WebMvcConfigurer configurer = corsConfiguration.corsConfigurer();
        assertNotNull(configurer);

        CorsRegistry registry = new CorsRegistry();
        configurer.addCorsMappings(registry);
    }
}
