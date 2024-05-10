package com.restaurante.grupo07.security;

import lombok.RequiredArgsConstructor;
import com.restaurante.grupo07.model.Login;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtService {

    @Autowired
    private final JwtEncoder JwtEncoder;

    public String generateToken(Authentication authentication) {
        Instant now = Instant.now();
        long expiry = 36000L;

        String authority = authentication.getAuthorities()
                            .stream()
                            .map(() -> GrantedAuthority.getAuthority())
                            .collect(Collectors.joining(" "));

        JwtClaimsSet claims = JwtClaimsSet.builder()
                                .issuer("tcc-restaurante")
                                .issuedAt(now)
                                .expiresAt(now.plusSeconds(expiry))
                                .subject(authentication.getName())
                                .claim("authority", authority)
                                .build();

        return encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }
}
