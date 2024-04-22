package com.learnmongo.mongoDB.mongodb.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authorization.AuthorityAuthorizationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurity  {
    @Bean
    SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(authz ->
                        authz
                            .requestMatchers(HttpMethod.GET, "api/student/students").hasAnyAuthority("SCOPE_developer")
                            .requestMatchers(HttpMethod.DELETE, "api/student/delete", "api/student/deleteById/{id}")
                            .access(AuthorityAuthorizationManager.hasAnyAuthority("ADMIN"))
                            .anyRequest().authenticated())
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> {}));
        return httpSecurity.build();
    }

}
