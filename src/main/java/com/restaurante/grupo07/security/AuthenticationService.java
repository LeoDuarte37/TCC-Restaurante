package com.restaurante.grupo07.security;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private JwtService jwtService;

    public String authenticate(Authentication authentication) {
        return jwtService.generateToken(authentication);
    }
}
