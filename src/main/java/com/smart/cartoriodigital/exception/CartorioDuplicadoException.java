package com.smart.cartoriodigital.exception;

public class CartorioDuplicadoException extends RuntimeException {

    public CartorioDuplicadoException(String message) {
        super(message);
    }

    public CartorioDuplicadoException(String message, Throwable cause) {
        super(message, cause);
    }
}
