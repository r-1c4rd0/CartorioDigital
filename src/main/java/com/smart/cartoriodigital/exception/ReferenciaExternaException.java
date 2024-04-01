package com.smart.cartoriodigital.exception;

public class ReferenciaExternaException extends RuntimeException {

    public ReferenciaExternaException(String message) {
        super(message);
    }

    public ReferenciaExternaException(String message, Throwable cause) {
        super(message, cause);
    }
}