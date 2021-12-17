package com.github.pavelryzhikov;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;


/**
 * песочница
 */
@Slf4j
public class Main {
    public static void main(String[] args) {
        JsonToMapDemo json = new JsonToMapDemo();
        JsonToMapDemo.main(args);
    }
}

@Data
class Person {
    private String name;
    private String age;
}

class JsonToMapDemo {
    public static void main(String[] args) {
        String json = "{\"name\":\"Akshay\",\"age\":\"23\"}";
        convertJsonToMap(json);
        convertJsonToPerson(json);

    }

    private static void convertJsonToPerson(String jsonString) {
        try {

            Person personMap = new ObjectMapper().readValue(jsonString, Person.class);
            System.out.println(personMap);

        } catch (JsonGenerationException e) {
            e.printStackTrace();

        } catch (JsonMappingException e) {
            e.printStackTrace();

        } catch (JsonProcessingException e) {

            e.printStackTrace();
        }
    }

    private static void convertJsonToMap(String jsonString) {
        try {

            Map<String, Object> personMap = new ObjectMapper().readValue(jsonString, Map.class);
            System.out.println(personMap);

        } catch (JsonGenerationException e) {
            e.printStackTrace();

        } catch (JsonMappingException e) {
            e.printStackTrace();

        } catch (JsonProcessingException e) {

            e.printStackTrace();
        }
    }
}
