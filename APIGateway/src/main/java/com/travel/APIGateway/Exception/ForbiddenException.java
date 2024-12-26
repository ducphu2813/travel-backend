package com.travel.APIGateway.Exception;


public class ForbiddenException extends RuntimeException{

        public ForbiddenException(String message) {
            super(message);
        }

        public ForbiddenException(String message, Throwable cause) {
            super(message, cause);
        }
}
