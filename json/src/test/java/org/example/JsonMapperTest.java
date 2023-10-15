package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class JsonMapperTest {

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void createObjectMapper() {

        Assertions.assertNotNull(objectMapper);
    }

    @Test
    void createJson() throws JsonProcessingException {
        Map<String, Object> data = Map.of(
                "name", "Ichwan Sholihin",
                "address", Map.of(
                        "street", "Rajawali",
                        "city", "Bandar Lampung"
                ),
                "age", 20,
                "married", true
        );

        String json = objectMapper.writeValueAsString(data);

        System.out.println(json);

        Assertions.assertNotNull(data);
    }

    @Test
    void readJson() throws JsonProcessingException {
        String json = """
                {"age":20,"married":true,"address":{"street":"Rajawali","city":"Bandar Lampung"},"name":"Ichwan Sholihin"}
                """;

        Map<String, Object> data = objectMapper.readValue(json, new TypeReference<>() {
        });

        Assertions.assertEquals("Ichwan Sholihin", data.get("name"));
        Assertions.assertEquals(20, data.get("age"));
    }

    /**
     * cara membaca JSON array sama dengan JSON object
     */
    @Test
    void createJsonArray() throws JsonProcessingException {
        List<String> state = List.of("Indonesia", "Palestine", "Yemen");

        String value = objectMapper.writeValueAsString(state);

        Assertions.assertNotNull(state);
        System.out.println(value);
    }

    @Test
    void createJsonFromObject() throws JsonProcessingException {
        Person person = new Person();

        person.setId("123A");
        person.setName("Ichwan Sholihin");
        person.setHobbies(List.of("Coding", "Reading", "Travelling"));

        Address address = new Address();
        address.setStreet("Rajawali");
        address.setCity("Bandar Lampung");
        address.setZipcode("35362");
        person.setAddress(address);

        String value = objectMapper.writeValueAsString(person);
        Assertions.assertNotNull(person);
        System.out.println(value);
    }

    @Test
    void convertJsonToObject() throws JsonProcessingException {
        String json = """
                {"id":"123A","name":"Ichwan Sholihin","hobbies":["Coding","Reading","Travelling"],"address":{"street":"Rajawali","city":"Bandar Lampung","zipcode":"35362"}}
                """;

        Person person = objectMapper.readValue(json, Person.class);

        Assertions.assertNotNull(person);
    }
}
