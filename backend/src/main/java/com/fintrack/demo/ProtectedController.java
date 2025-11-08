package com.fintrack.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

@RestController
@RequestMapping("/api/demo")
public class ProtectedController {

    @GetMapping("/me")
    public Map<String, Object> me(Principal principal) {
        // principal.getName() contains the subject (user id string we set earlier or email if configured)
        return Map.of("principal", principal == null ? null : principal.getName());
    }
}
