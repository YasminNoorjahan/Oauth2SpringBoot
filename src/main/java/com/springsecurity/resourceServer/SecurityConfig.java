package com.springsecurity.resourceServer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.security.web.SecurityFilterChain;

import java.nio.file.PathMatcher;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests()
                        .requestMatchers("/test","/","").permitAll()
                        .anyRequest().authenticated()
                        .and()
                                .oauth2Login();

      /*  http
                .authorizeHttpRequests()
                .requestMatchers("/user")
                .authenticated().anyRequest()
                .permitAll()
                .and()
                .oauth2Login();*/
        return http.build();
    }





/*        @Bean
    public OAuth2ClientContext oauth2ClientContext(List<ClientRegistration> clientRegistrations) {
        OAuth2ClientContextHolder contextHolder = new OAuth2ClientContextHolder();
        contextHolder.setClientRegistrations(clientRegistrations);
        return contextHolder;
    }*/
}
