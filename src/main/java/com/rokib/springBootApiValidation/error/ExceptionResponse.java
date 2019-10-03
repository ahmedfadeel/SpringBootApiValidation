package com.rokib.springBootApiValidation.error;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ExceptionResponse {
    private LocalDateTime time;
    private String message;
    private String details;

    public ExceptionResponse(LocalDateTime time, String message, String details) {
        this.time = time;
        this.message = message;
        this.details = details;
    }
}
