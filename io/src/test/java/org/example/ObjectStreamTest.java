package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * manipulasi object Person ke file
 */
public class ObjectStreamTest {

    @Test
    void savePerson() {
        Person person = new Person();
        person.setId("1");
        person.setName("Ichwan");

        Path path = Path.of("ichwan.person");

        try(OutputStream stream = Files.newOutputStream(path);
            ObjectOutputStream outputStream = new ObjectOutputStream(stream)) {
            outputStream.writeObject(person);
            outputStream.flush();
        } catch (IOException e){
            Assertions.fail(e);
        }
    }
    
    @Test
    void readPerson(){
        Path path = Path.of("ichwan.person");

        try(InputStream stream = Files.newInputStream(path);
            ObjectInputStream inputStream = new ObjectInputStream(stream)) {

            Person person = (Person) inputStream.readObject();

            Assertions.assertEquals("1", person.getId());
            Assertions.assertEquals("Ichwan", person.getName());

        } catch (IOException | ClassNotFoundException e){
            Assertions.fail(e);
        }
    }
}
