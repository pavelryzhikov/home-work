package com.github.pavelryzhikov.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pavelryzhikov.dto.Request;
import com.github.pavelryzhikov.dto.Response;

public class JSONUtils {

    public static String toJSON(Response response) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(response);
    }

    public static String toJSON(Request request) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(request);
    }

    public static Request JSONtoRequest(String json) throws JsonProcessingException {
        return new ObjectMapper().readValue(json, Request.class);
    }

    public static Response JSONtoResponse(String json) throws JsonProcessingException {
        return new ObjectMapper().readValue(json, Response.class);
    }


}
