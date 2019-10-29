package com.cancha.gateway.web.handler.error;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Default Error Message")
public class Error {

    @ApiModelProperty(name = "code")
    @JsonProperty("code")
    private String code;

    @ApiModelProperty(name = "message")
    @JsonProperty("message")
    private String message;

    public Error(String message) {
        this.message = message;
    }

    public Error(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
