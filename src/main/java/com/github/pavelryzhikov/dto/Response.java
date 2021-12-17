package com.github.pavelryzhikov.dto;

import lombok.Data;

@Data
public class Response {

    private String statusCode;

    public Response() {
    }

    public Response(String statusCode) {
        this.statusCode = statusCode;
    }

}
