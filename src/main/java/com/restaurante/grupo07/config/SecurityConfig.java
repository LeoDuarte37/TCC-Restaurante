package com.restaurante.grupo07.config;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Value("${jwt.public.key}")
    private RSAPublicKey key;

    @Value("${jwt.private.key}")
    private RSAPrivateKey priv;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // Referencia: https://docs.spring.io/spring-security/reference/servlet/authorization/authorize-http-requests.html

        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers(HttpMethod.POST,"/login", "/login/cadastrar").permitAll()

                        .requestMatchers(HttpMethod.GET, "/mesa/listar", "/mesa/{id}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/mesa/listar/status/{status}").hasAnyAuthority("ADMIN", "CAIXA", "GARCOM", "COZINHA")
                        .requestMatchers(HttpMethod.GET, "/mesa/listar/chamandoGarcom}").hasAnyAuthority("ADMIN", "CAIXA", "GARCOM", "COZINHA")
                        .requestMatchers(HttpMethod.PUT, "/mesa").hasAnyAuthority("ADMIN", "CAIXA", "GARCOM", "COZINHA")
                        .requestMatchers(HttpMethod.PATCH, "/mesa/atualizar/**").permitAll()

                        .requestMatchers(HttpMethod.GET, "/categoria/listar", "/categoria/{id}").permitAll()
                        .requestMatchers(HttpMethod.PATCH, "/categoria/atualizar/status").hasAnyAuthority("ADMIN", "CAIXA")

                        .requestMatchers(HttpMethod.GET, "/produto/listar").permitAll()
                        .requestMatchers(HttpMethod.GET, "/produto/{id}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/produto/listar/disponiveis").permitAll()
                        .requestMatchers(HttpMethod.PATCH, "/produto/atualizar/status").hasAnyAuthority("ADMIN", "CAIXA")

                        .requestMatchers(HttpMethod.POST, "/pedido").permitAll()
                        .requestMatchers(HttpMethod.GET, "/pedido/listar/mesa/{mesa}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/pedido/**").hasAnyAuthority("ADMIN", "CAIXA", "GARCOM", "COZINHA")
                        .requestMatchers(HttpMethod.PUT, "/pedido").hasAnyAuthority("ADMIN", "CAIXA")
                        .requestMatchers(HttpMethod.PATCH, "/pedido/atualizar/status").hasAnyAuthority("ADMIN", "CAIXA", "GARCOM", "COZINHA")

                        .anyRequest().hasAuthority("ADMIN")
                        .httpBasic(Customizer.withDefaults())
                        .oauth2ResourceServer(conf -> conf.jwt(jwt -> jwt.decoder(jwtDecoder())))
                ).build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withPublicKey(this.key).build();
    }

    @Bean 
    JwtEncoder JwtEncoder() {
        JWK jwk = new RSAKey.Builder().privateKey(this.priv).build();
        JWKSource<SecurityContext> jwks = new ImmutableJWKSet<>(new JWKSet(jwk));

        return new NimbusJwtEncoder(jwks);
    }
}
