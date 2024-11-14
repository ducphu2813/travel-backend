package com.travel.APIGateway.Configuration;

import com.travel.APIGateway.Filter.AuthenticationFilter;
import com.travel.APIGateway.Filter.RouteValidator;
import com.travel.APIGateway.Service.JWTService;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class GatewayConfig {

    @Bean
    public AuthenticationFilter authenticationFilter(JWTService jwtService
                                                    , RouteValidator routeValidator) {
        return new AuthenticationFilter(jwtService, routeValidator);
    }
    //tạo route locator
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder
                                            , AuthenticationFilter authenticationFilter) {
        return builder.routes()
                .route("user_service_route", r -> r.path("/api/user/**")                                    // định nghĩa route đến 1 controller cụ thể
                        .filters(f -> f.filter(authenticationFilter.apply(new AuthenticationFilter.Config())))   // add filter jwt
                        .uri("lb://USER"))                                                                      // tên service đăng ký trên eureka

                .route("booking_service_route", r -> r.path("/api/booking/**")
                        .filters(f -> f.filter(authenticationFilter.apply(new AuthenticationFilter.Config())))
                        .uri("lb://BOOKING"))

                .route("flight_service_route", r -> r.path("/api/flight/**")
                        .filters(f -> f.filter(authenticationFilter.apply(new AuthenticationFilter.Config())))
                        .uri("lb://FLIGHT"))

                .route("tour_service_route", r -> r.path("/api/tour/**")
                        .filters(f -> f.filter(authenticationFilter.apply(new AuthenticationFilter.Config())))
                        .uri("lb://TOUR"))

                .route("resort_service_route", r -> r.path("/api/resort/**")
                        .filters(f -> f.filter(authenticationFilter.apply(new AuthenticationFilter.Config())))
                        .uri("lb://RESORT"))

                .route("payment_service_route", r -> r.path("/api/payment/**")
                        .filters(f -> f.filter(authenticationFilter.apply(new AuthenticationFilter.Config())))
                        .uri("lb://PAYMENT"))

                //route này không cần xác thực
                .route("auth_service_route", r -> r.path("/api/auth/**")
                        .uri("lb://USER"))
                .build();
    }


}
