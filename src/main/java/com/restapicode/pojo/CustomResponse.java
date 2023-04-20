package com.restapicode.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomResponse {
    @JsonProperty
    private String action = "Processed successfully";
    @JsonProperty
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorMessage;

    public CustomResponse() {
    }

    public CustomResponse(String action) {
        this.action = action;
    }

    public CustomResponse(String action, String errorMessage) {
        this.action = action;
        this.errorMessage = errorMessage;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

}
