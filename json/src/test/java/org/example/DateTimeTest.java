package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

class DateTimeTest {

    @Test
    void dateTimeTestJSON() throws JsonProcessingException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        ObjectMapper mapper = new ObjectMapper()
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                .configure(SerializationFeature.INDENT_OUTPUT, true)
                .setDateFormat(dateFormat);

        Person person = new Person();
        person.setId("1");
        person.setName("Ichwan");
        person.setCreatedAt(new Date());

        Assertions.assertNotNull(person);
        String json = mapper.writeValueAsString(person);
        System.out.println(json);
    }
}
