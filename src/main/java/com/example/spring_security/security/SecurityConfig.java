package com.example.spring_security.security;

import com.example.spring_security.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/*
 * @created 05/07/2023 - 1:48 PM
 * @project Spring_Security
 * @author Yosef Adel Mahmoud Saaid
 */
@Configuration
public class SecurityConfig {
    //beans
    //bcrypt bean definition
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //authenticationProvider bean definition



    @Bean
    public DaoAuthenticationProvider authenticationProvider(UserService userService){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/manger").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.GET, "/api/admin").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/**").permitAll()

        );

        // use HTTP Basic authentication
        http.httpBasic(Customizer.withDefaults());

        // disable Cross Site Request Forgery (CSRF)
        // in general not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH
        http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }

}
