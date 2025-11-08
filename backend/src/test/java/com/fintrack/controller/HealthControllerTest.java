package com.fintrack.controller;

import com.fintrack.controller.HealthController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

// Mock these to prevent security + db initialization
import com.fintrack.auth.jwt.JwtService;
import com.fintrack.auth.repository.UserRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@SpringBootTest - Loaded whole application (including DB, security)
@WebMvcTest(HealthController.class)
class HealthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // Mocks required security dependencies so that the controller loads
    @MockBean
    private JwtService jwtService;

    @MockBean
    private UserRepository userRepository;

    @Test
    void healthEndpointShouldReturnOk() throws Exception {
//        mockMvc.perform(get("/api/health"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.status").value("UP"))
//                .andExpect(jsonPath("$.service").value("FinTrack Backend"));
        mockMvc.perform(get("/api/health"))
                .andExpect(status().isOk());
    }
}