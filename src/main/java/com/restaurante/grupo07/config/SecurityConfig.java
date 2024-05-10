package com.restaurante.grupo07.config;

import com.restaurante.grupo07.security.SecurityFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebSecurity
@EnableWebMvc
public class SecurityConfig {

    @Autowired
    private SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // Referencia: https://docs.spring.io/spring-security/reference/servlet/authorization/authorize-http-requests.html

        return http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers(HttpMethod.POST,"/login", "/login/cadastrar").permitAll()

                        .requestMatchers(HttpMethod.GET, "/mesa/listar").permitAll()
                        .requestMatchers(HttpMethod.GET, "/mesa/listar/status/{status}").hasAnyRole("ADMIN", "CAIXA", "GARCOM", "COZINHA")
                        .requestMatchers(HttpMethod.GET, "/mesa/listar/chamandoGarcom").hasAnyRole("ADMIN", "CAIXA", "GARCOM", "COZINHA")
                        .requestMatchers(HttpMethod.PUT, "/mesa").hasAnyRole("ADMIN", "CAIXA", "GARCOM", "COZINHA")

                        .requestMatchers("/categoria/listar").permitAll()
                        .requestMatchers(HttpMethod.PATCH, "/categoria/atualizar/status").hasAnyRole("ADMIN", "CAIXA")

                        .requestMatchers("/produto/listar").permitAll()
                        .requestMatchers(HttpMethod.GET, "/produto/{id}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/produto/listar/disponiveis").permitAll()
                        .requestMatchers(HttpMethod.PATCH, "/produto/atualizar/status").hasAnyRole("ADMIN", "CAIXA")

                        .requestMatchers(HttpMethod.POST, "/pedido").permitAll()
                        .requestMatchers(HttpMethod.GET, "/pedido/listar/mesa/{mesa}").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/pedido").hasAnyRole("ADMIN", "CAIXA")
                        .requestMatchers(HttpMethod.PATCH, "/pedido/atualizar/status").hasAnyRole("ADMIN", "CAIXA", "GARCOM", "COZINHA")

                        .anyRequest().authenticated()

                ).addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class).build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
