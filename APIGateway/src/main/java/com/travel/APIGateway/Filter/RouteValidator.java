package com.travel.APIGateway.Filter;

import org.springframework.stereotype.Component;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Predicate;

@Component
public class RouteValidator {

    //danh sách endpoint không cần xác thực
    public static final List<String> openApiEndpoints = List.of(
            "**/login",
            "**/register"
    );

    //check coi request có phải là endpoint mở hay không
    public Predicate<ServerHttpRequest> isSecured =
            request -> openApiEndpoints
                    .stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));
}
