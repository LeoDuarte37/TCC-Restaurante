package com.restaurante.grupo07.config;

import com.restaurante.grupo07.security.JwtAuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtAuthFilter authFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // Referencia: https://docs.spring.io/spring-security/reference/servlet/authorization/authorize-http-requests.html

        return http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers(HttpMethod.POST,"/login", "/login/cadastrar").permitAll()

                        .requestMatchers(HttpMethod.GET, "/mesa/listar", "/mesa/{id}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/mesa/listar/status/{status}").hasAnyRole("ADMIN", "CAIXA", "GARCOM", "COZINHA")
                        .requestMatchers(HttpMethod.GET, "/mesa/listar/chamandoGarcom}").hasAnyRole("ADMIN", "CAIXA", "GARCOM", "COZINHA")
                        .requestMatchers(HttpMethod.PUT, "/mesa").hasAnyRole("ADMIN", "CAIXA", "GARCOM", "COZINHA")
                        .requestMatchers(HttpMethod.PATCH, "/mesa/atualizar/**").permitAll()

                        .requestMatchers(HttpMethod.GET, "/categoria/listar", "/categoria/{id}").permitAll()
                        .requestMatchers(HttpMethod.PATCH, "/categoria/atualizar/status").hasAnyRole("ADMIN", "CAIXA")

                        .requestMatchers(HttpMethod.GET, "/produto/listar").permitAll()
                        .requestMatchers(HttpMethod.GET, "/produto/{id}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/produto/listar/disponiveis").permitAll()
                        .requestMatchers(HttpMethod.PATCH, "/produto/atualizar/status").hasAnyRole("ADMIN", "CAIXA")

                        .requestMatchers(HttpMethod.POST, "/pedido").permitAll()
                        .requestMatchers(HttpMethod.GET, "/pedido/listar/mesa/{mesa}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/pedido/**").hasAnyRole("ADMIN", "CAIXA", "GARCOM", "COZINHA")
                        .requestMatchers(HttpMethod.PUT, "/pedido").hasAnyRole("ADMIN", "CAIXA")
                        .requestMatchers(HttpMethod.PATCH, "/pedido/atualizar/status").hasAnyRole("ADMIN", "CAIXA", "GARCOM", "COZINHA")

                        .anyRequest().hasRole("ADMIN")

                ).addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class).build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
