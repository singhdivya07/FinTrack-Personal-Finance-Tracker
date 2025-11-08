package com.fintrack.auth.service;

import com.fintrack.auth.dto.RegisterRequest;
import com.fintrack.auth.model.User;
import com.fintrack.auth.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public User register(RegisterRequest req) {
        if (userRepository.existsByEmail(req.getEmail())) {
            throw new IllegalArgumentException("Email already registered");
        }
        String hashed = passwordEncoder.encode(req.getPassword());
        User u = new User(req.getName(), req.getEmail(), hashed);
        return userRepository.save(u);
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email).orElse(null);
    }
}
