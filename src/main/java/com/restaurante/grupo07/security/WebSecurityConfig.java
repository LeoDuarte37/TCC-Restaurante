package com.restaurante.grupo07.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class WebSecurityConfig {

    @Autowired
    private JwtAuthFilter authFilter;

    @Bean
    UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());

        return authenticationProvider;
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // Referencia: https://docs.spring.io/spring-security/reference/servlet/authorization/authorize-http-requests.html

        http
                .sessionManagement(management -> management
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                        .csrf(csrf -> csrf.disable())
                        .cors(withDefaults());

        http
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers( HttpMethod.POST,"/login", "/login/cadastrar").permitAll()

                        .requestMatchers(HttpMethod.GET, "/mesa").hasAnyRole("ADMINISTRADOR", "CAIXA", "GARCOM", "COZINHA")
                        .requestMatchers(HttpMethod.PUT, "/mesa").hasAnyRole("ADMINISTRADOR", "CAIXA", "GARCOM", "COZINHA")
                        .requestMatchers( HttpMethod.PATCH, "/mesa/atualizar/**").permitAll()

                        .requestMatchers( HttpMethod.GET, "/categoria/listar", "/categoria/listar/**").permitAll()
                        .requestMatchers( HttpMethod.PATCH, "/categoria/atualizar/status").hasAnyRole("ADMINISTRADOR", "CAIXA")

                        .requestMatchers( HttpMethod.GET, "/produto/listar", "/produto/listar/**").permitAll()
                        .requestMatchers( HttpMethod.PATCH, "/produto/atualizar/status").hasAnyRole("ADMINISTRADOR", "CAIXA")

                        .requestMatchers( HttpMethod.POST, "/pedido").permitAll()
                        .requestMatchers( HttpMethod.GET, "/pedido/listar/mesa/{mesa}").permitAll()
                        .requestMatchers( HttpMethod.GET, "/pedido/**").hasAnyRole("ADMINISTRADOR", "CAIXA", "GARCOM", "COZINHA")
                        .requestMatchers( HttpMethod.PUT, "/pedido").hasAnyRole("ADMINISTRADOR", "CAIXA")
                        .requestMatchers( HttpMethod.PATCH, "/pedido/atualizar/status").hasAnyRole("ADMINISTRADOR", "CAIXA", "GARCOM", "COZINHA")

                        .requestMatchers("/error/**").permitAll()
                        .requestMatchers(HttpMethod.OPTIONS).permitAll()
                        .anyRequest().hasRole("ADMINISTRADOR"))

                .authenticationProvider(authenticationProvider())
                .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
                .httpBasic(withDefaults());

        return http.build();
    }
}
