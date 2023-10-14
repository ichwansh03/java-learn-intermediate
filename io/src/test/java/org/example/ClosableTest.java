package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

class ClosableTest {

    @Test
    void closeIO() {
        Path path = Path.of("pom.xml");
        try(InputStream inputStream = Files.newInputStream(path);
            InputStream inputStream2 = Files.newInputStream(path)) {

            //DO IT

        } catch (IOException e){
            Assertions.fail(e);
        }
    }
}
