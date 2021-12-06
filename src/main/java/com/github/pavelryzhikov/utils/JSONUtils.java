package com.github.pavelryzhikov.utils;

import com.github.pavelryzhikov.dto.Request;
import com.github.pavelryzhikov.dto.Response;

public class JSONUtils {

    public static String toJSON(Response response) {

        return "";
    }

    public static String toJSON(Request request) {
        return "";
    }

    public static Request JSONtoRequest(String json) {
        return new Request("www");
    }

    public static Response JSONtoResponse(String json) {
        return new Response("SSS");
    }


}
