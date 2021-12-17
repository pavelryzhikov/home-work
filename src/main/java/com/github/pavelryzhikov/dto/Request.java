package com.github.pavelryzhikov.dto;

import lombok.Data;

@Data
public class Request {
    private String atmNumber;

    public Request() {
    }

    public Request(String atmNumber) {
        this.atmNumber = atmNumber;
    }
}
