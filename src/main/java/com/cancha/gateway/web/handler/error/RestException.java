package com.cancha.gateway.web.handler.error;


import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by MARA on 24/06/2018.
 */
public class RestException extends RuntimeException {

    private ApiError apiError;

    public RestException(HttpStatus status, String mensaje) {
        super(mensaje);
        apiError = new ApiError(status, mensaje);
        apiError.setTimestamp(LocalDateTime.now());
    }

    public RestException(HttpStatus status, String mensaje, List errors) {
        super(mensaje);
        apiError = new ApiError(status, mensaje);
        apiError.setTimestamp(LocalDateTime.now());
        apiError.setErrors(errors);
    }

    public ApiError getApiError() {
        return apiError;
    }
}

