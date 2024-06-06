package com.restaurante.grupo07.config;

import com.restaurante.grupo07.security.SecurityFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
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
                        .requestMatchers(HttpMethod.PUT,"/login" ).hasAnyRole("ROOT", "ADMIN")
                        .requestMatchers(HttpMethod.DELETE,"/login/{username}").hasAnyRole("ROOT", "ADMIN")

                        .requestMatchers( "/usuario", "/usuario/**").hasAnyRole("ROOT", "ADMIN")

                        .requestMatchers( "/perfil", "/perfil/**").hasRole("ROOT")

                        .requestMatchers( "/restaurante", "/restaurante/**").hasRole("ROOT")

                        .requestMatchers(HttpMethod.POST, "/mesa").hasAnyRole("ROOT", "ADMIN", "GERENTE")
                        .requestMatchers(HttpMethod.GET, "/mesa/{id}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/mesa/listar", "/mesa/listar/**")
                            .hasAnyRole("ROOT", "ADMIN", "GERENTE", "CAIXA", "GARCOM", "COZINHA")
                        .requestMatchers(HttpMethod.PUT, "/mesa")
                            .hasAnyRole("ROOT", "ADMIN", "GERENTE", "CAIXA")
                        .requestMatchers(HttpMethod.PATCH, "/mesa/atualizar/**")
                            .hasAnyRole("ROOT", "ADMIN", "GERENTE", "CAIXA", "GARCOM", "COZINHA")
                        .requestMatchers(HttpMethod.DELETE, "/mesa/{id}").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.POST, "/categoria")
                            .hasAnyRole("ROOT", "ADMIN", "GERENTE")
                        .requestMatchers(HttpMethod.GET,"/categoria/**").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/categoria")
                            .hasAnyRole("ROOT", "ADMIN", "GERENTE")
                        .requestMatchers(HttpMethod.PATCH, "/categoria/atualizar/status")
                            .hasAnyRole("ROOT", "ADMIN", "GERENTE", "CAIXA")
                        .requestMatchers(HttpMethod.DELETE, "/categoria/{id}").hasAnyRole("ROOT", "ADMIN")

                        .requestMatchers(HttpMethod.POST, "/produto")
                            .hasAnyRole("ROOT", "ADMIN", "GERENTE")
                        .requestMatchers(HttpMethod.GET, "/produto/**").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/produto")
                            .hasAnyRole("ROOT", "ADMIN", "GERENTE")
                        .requestMatchers(HttpMethod.PATCH, "/produto/atualizar/status")
                            .hasAnyRole("ROOT", "ADMIN", "GERENTE", "CAIXA")
                        .requestMatchers(HttpMethod.DELETE, "/produto/{id}").hasAnyRole("ROOT", "ADMIN")

                        .requestMatchers(HttpMethod.POST, "/pedido").permitAll()
                        .requestMatchers(HttpMethod.GET, "/pedido/listar/mesa/{mesa}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/pedido/listar", "/pedido/listar/status")
                            .hasAnyRole("ROOT", "ADMIN", "GERENTE", "CAIXA")
                        .requestMatchers(HttpMethod.PUT, "/pedido")
                            .hasAnyRole("ROOT", "ADMIN", "GERENTE", "CAIXA")
                        .requestMatchers(HttpMethod.PATCH, "/pedido/atualizar/status")
                            .hasAnyRole("ROOT", "ADMIN", "GERENTE", "CAIXA", "GARCOM", "COZINHA")
                        .requestMatchers(HttpMethod.DELETE, "/pedido/{id}")
                            .hasAnyRole("ROOT", "ADMIN", "GERENTE", "CAIXA")

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
