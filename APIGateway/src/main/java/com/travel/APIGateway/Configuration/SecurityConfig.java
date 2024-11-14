package com.travel.APIGateway.Configuration;

import com.travel.APIGateway.Filter.AuthenticationFilter;
import com.travel.APIGateway.Filter.RouteValidator;
import com.travel.APIGateway.Service.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;


@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Autowired
    private JWTService jwtService;
    @Autowired
    private RouteValidator routeValidator;

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http
                // ...
                .csrf(csrf -> csrf.disable());
        return http.build();
    }
}
