package com.onespace.exceptions;

/**
 *
 */
public class MetalValueNotFound extends RuntimeException {
    public MetalValueNotFound(String errorMessage) {
        super(errorMessage);
    }
}