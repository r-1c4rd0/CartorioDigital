package com.smart.cartoriodigital.exception;

public class CartorioNotFoundException extends RuntimeException {

    public CartorioNotFoundException(String message) {
        super(message);
    }

    public CartorioNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}