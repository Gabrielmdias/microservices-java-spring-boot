package com.wit.subscriptiondomain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.UUID;

public class BasicDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID id;
    private Operation operation;
    private String requestId;
    private String apiResource;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @JsonIgnore
    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    @JsonIgnore
    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    @JsonIgnore
    public String getApiResource() {
        return apiResource;
    }

    public void setApiResource(String apiResource) {
        this.apiResource = apiResource;
    }
}
