package com.github.pavelryzhikov.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.github.pavelryzhikov.dto.Request;
import com.github.pavelryzhikov.dto.Response;

public class XMLUtils {
    public static String toXML(Response response) throws JsonProcessingException {
        return new XmlMapper().writeValueAsString(response);
    }

    public static String toXML(Request request) throws JsonProcessingException {
        return new XmlMapper().writeValueAsString(request);
    }

    public static Request XMLtoRequest(String xml) throws JsonProcessingException {
        return new XmlMapper().readValue(xml, Request.class);
    }

    public static Response XMLtoResponse(String xml) throws JsonProcessingException {
        return new XmlMapper().readValue(xml, Response.class);
    }

}
