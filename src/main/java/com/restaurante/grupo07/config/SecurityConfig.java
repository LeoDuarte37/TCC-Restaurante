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
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

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

                    .requestMatchers(HttpMethod.POST, "/mesa/login").permitAll()
                    .requestMatchers(HttpMethod.POST, "/mesa").hasAnyRole("ROOT", "ADMIN")
                    .requestMatchers(HttpMethod.GET, "/mesa/**")
                        .hasAnyRole("ROOT", "ADMIN", "CAIXA", "GARCOM", "COZINHA")
                    .requestMatchers(HttpMethod.PUT, "/mesa").hasAnyRole("ROOT", "ADMIN", "CAIXA")
                    .requestMatchers(HttpMethod.PATCH, "/mesa/atualizar/status").permitAll()
                    .requestMatchers(HttpMethod.PATCH, "/mesa/atualizar/chamarGarcom/{id}").permitAll()
                    .requestMatchers(HttpMethod.DELETE, "/mesa/{id}").hasAnyRole("ROOT", "ADMIN")

                    .requestMatchers(HttpMethod.POST, "/categoria").hasAnyRole("ROOT", "ADMIN")
                    .requestMatchers(HttpMethod.GET,"/categoria/listar/disponiveis/restaurante/{id}").permitAll()
                    .requestMatchers(HttpMethod.GET,"/categoria/listar/restaurante/{id}")
                        .hasAnyRole("ROOT", "ADMIN", "CAIXA")
                    .requestMatchers(HttpMethod.PUT, "/categoria").hasAnyRole("ROOT", "ADMIN")
                    .requestMatchers(HttpMethod.PATCH, "/categoria/atualizar/status")
                        .hasAnyRole("ROOT", "ADMIN", "CAIXA")
                    .requestMatchers(HttpMethod.DELETE, "/categoria/{id}").hasAnyRole("ROOT", "ADMIN")

                    .requestMatchers(HttpMethod.POST, "/subcategoria").hasAnyRole("ROOT", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/subcategoria").hasAnyRole("ROOT", "ADMIN", "CAIXA")
                    .requestMatchers(HttpMethod.DELETE, "/subcategoria/{id}").hasAnyRole("ROOT", "ADMIN")

                    .requestMatchers(HttpMethod.POST, "/produto").hasAnyRole("ROOT", "ADMIN")
                    .requestMatchers(HttpMethod.GET, "/produto/**").permitAll()
                    .requestMatchers(HttpMethod.PUT, "/produto").hasAnyRole("ROOT", "ADMIN")
                    .requestMatchers(HttpMethod.PATCH, "/produto/atualizar/status")
                        .hasAnyRole("ROOT", "ADMIN", "CAIXA")
                    .requestMatchers(HttpMethod.DELETE, "/produto/{id}").hasAnyRole("ROOT", "ADMIN")

                    .requestMatchers(HttpMethod.POST, "/pedido").permitAll()
                    .requestMatchers(HttpMethod.POST, "/pedido/listar/**")
                        .hasAnyRole("ROOT", "ADMIN", "CAIXA", "GARCOM", "COZINHA")
                    .requestMatchers(HttpMethod.GET, "/pedido/listar/restaurante/{id}", "/pedido/listar/status")
                        .hasAnyRole("ROOT", "ADMIN")
                    .requestMatchers(HttpMethod.GET, "/pedido/{id}", "/pedido/listar/data/**", "/pedido/listar/mesa")
                        .hasAnyRole("ROOT", "ADMIN", "CAIXA")
                    .requestMatchers(HttpMethod.PUT).hasAnyRole("ROOT", "ADMIN", "CAIXA")
                    .requestMatchers(HttpMethod.PATCH, "/pedido/atualizar/status")
                        .hasAnyRole("ROOT", "ADMIN", "CAIXA", "GARCOM", "COZINHA")
                    .requestMatchers(HttpMethod.DELETE, "/pedido/{id}").hasAnyRole("ROOT", "ADMIN")

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

    @Bean
    public WebMvcConfigurer corsConfigurer()
    {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry
                        .addMapping("/**")
                        .allowedOrigins("http://localhost:5173")
                        .allowedHeaders("*")
                        .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE");
            }
        };
    }
}
