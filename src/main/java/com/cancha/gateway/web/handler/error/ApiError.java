package com.cancha.gateway.web.handler.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;

@ApiModel("API Error Message")
public class ApiError extends Error {

    @ApiModelProperty(name = "timestamp")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp = LocalDateTime.now();

    @ApiModelProperty(name = "status")
    @JsonProperty("status")
    private HttpStatus status;

    @ApiModelProperty(name = "errors")
    @JsonProperty("errors")
    private List errors;

    public ApiError(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public ApiError(HttpStatus status, String code, String message) {
        super(code, message);
        this.status = status;
    }

    public ApiError(HttpStatus status, String message, List errors) {
        super(message);

        this.status = status;
        this.errors = errors;
    }

    public ApiError(HttpStatus status, String code, String message, List errors) {
        super(code, message);

        this.status = status;
        this.errors = errors;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public ApiError setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public List getErrors() {
        return errors;
    }

    public ApiError setErrors(List errors) {
        this.errors = errors;
        return this;
    }

    public static ResponseEntity responseError(HttpStatus status, String message) {
        return new ResponseEntity(new ApiError(status, message), status);
    }

    public static ResponseEntity responseError(HttpStatus status, String code, String message) {
        return new ResponseEntity(new ApiError(status, code, message), status);
    }

    public static ResponseEntity responseError(HttpStatus status, String message, List errors) {
        return new ResponseEntity(new ApiError(status, message, errors), status);
    }

    public static ResponseEntity responseError(HttpStatus status, String code, String message, List errors) {
        return new ResponseEntity(new ApiError(status, code, message, errors), status);
    }

}
