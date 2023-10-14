package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;

class InputStreamTest {

    @Test
    void readInputStream() {
        Path path = Path.of("pom.xml");
        try(InputStream stream = Files.newInputStream(path)) {
            StringBuilder builder = new StringBuilder();
            int data;
            int counter = 0;
            while ((data = stream.read()) != -1){
                builder.append((char) data);
                counter++;
            }
            System.out.println(counter);
            System.out.println(builder);
        } catch (IOException e){
            Assertions.fail(e);
        }
    }

    @Test
    void readInputStreamBytes() {
        Path path = Path.of("pom.xml");
        try(InputStream stream = Files.newInputStream(path)) {
            StringBuilder builder = new StringBuilder();
            byte[] bytes = new byte[1024];
            int length;
            int counter = 0;
            while ((length = stream.read(bytes)) != -1){
                builder.append(new String(bytes, 0, length));
                counter++;
            }
            System.out.println(counter);
            System.out.println(builder);
        } catch (IOException e){
            Assertions.fail(e);
        }
    }

    @Test
    void readerBytes() {
        Path path = Path.of("output.txt");
        try(Reader reader = Files.newBufferedReader(path)) {
            StringBuilder builder = new StringBuilder();
            char[] chars = new char[1024];
            int length;
            int counter = 0;
            while ((length = reader.read(chars)) != -1){
                builder.append(new String(chars, 0, length));
                counter++;
            }
            System.out.println(counter);
            System.out.println(builder);
        } catch (IOException e){
            Assertions.fail(e);
        }
    }
}
