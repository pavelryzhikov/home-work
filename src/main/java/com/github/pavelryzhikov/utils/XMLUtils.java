package com.github.pavelryzhikov.utils;

import com.github.pavelryzhikov.dto.Request;
import com.github.pavelryzhikov.dto.Response;

public class XMLUtils {
    public static String toXML(Response response) {
        return "";
    }

    public static String toXML(Request request) {
        return "";
    }

    public static Request XMLtoRequest(String xml) {
        return new Request("www");
    }

    public static Response XMLtoResponse(String xml) {
        return new Response("SSS");
    }

}
