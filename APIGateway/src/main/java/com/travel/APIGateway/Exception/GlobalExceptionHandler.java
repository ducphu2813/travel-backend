package com.travel.APIGateway.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@ControllerAdvice
public class GlobalExceptionHandler {

    // xử lý lỗi unauthorized (bao gồm unauthorized, signature không hợp lệ, token hết hạn)
    @ExceptionHandler({UnauthorizedException.class, io.jsonwebtoken.security.SignatureException.class, io.jsonwebtoken.ExpiredJwtException.class})
    public Mono<ResponseEntity<ErrorResponse>> handleUnauthorizedException(Exception ex, ServerWebExchange exchange) {
        ErrorResponse errorDetails = new ErrorResponse(HttpStatus.UNAUTHORIZED, ex.getMessage(), exchange.getRequest().getPath().value());
        return Mono.just(new ResponseEntity<>(errorDetails, HttpStatus.UNAUTHORIZED));
    }

    // xử lý lỗi forbidden
    @ExceptionHandler(ForbiddenException.class)
    public Mono<ResponseEntity<ErrorResponse>> handleForbiddenException(ForbiddenException ex, ServerWebExchange exchange) {
        ErrorResponse errorDetails = new ErrorResponse(HttpStatus.FORBIDDEN, ex.getMessage(), exchange.getRequest().getPath().value());
        return Mono.just(new ResponseEntity<>(errorDetails, HttpStatus.FORBIDDEN));
    }
}
