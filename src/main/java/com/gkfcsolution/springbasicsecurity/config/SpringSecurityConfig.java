package com.gkfcsolution.springbasicsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

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
public class SpringSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // pour REST
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/noAuth/**").permitAll() // endpoint public
                        .anyRequest().hasRole("ADMIN"))
                // le reste sécurisé
                .httpBasic(Customizer.withDefaults());     // auth basique HTTP pour API

        return http.build();
    }


    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user1 = User.builder()
                .username("frankUser")
                .password(passwordEncoder().encode("user1234"))
                .roles("USER")
                .build();
        UserDetails admin1 = User.builder()
                .username("frankAdmin")
                .password(passwordEncoder().encode("admin1234"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user1, admin1);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
