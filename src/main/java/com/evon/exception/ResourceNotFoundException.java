package com.evon.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {

    String message;

    public ResourceNotFoundException(String message) {
        super(String.format(message));
        this.message = message;
    }
}
