package com.gkfcsolution.springbasicsecurity.config;

import com.gkfcsolution.springbasicsecurity.model.User;
import com.gkfcsolution.springbasicsecurity.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

/**
 * Created on 2025 at 12:03
 * File: null.java
 * Project: spring-basic-security
 *
 * @author Frank GUEKENG
 * @date 19/09/2025
 * @time 12:03
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig {

/*    @Autowired
    private UserDetailsService userDetailsService;*/
    @Autowired
private UserRepository userRepository;


    // ✅ Encoder des mots de passe
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // ✅ Provider qui gère l’authentification avec UserDetailsService
/*    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }*/

    // ✅ AuthenticationManager via AuthenticationConfiguration (plus moderne)
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    // ✅ Config des filtres de sécurité
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/noAuth/**").permitAll()
                        .requestMatchers("/secure/**").hasAnyRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults()); // ou formLogin() si tu veux du login web

        return http.build();
    }

}