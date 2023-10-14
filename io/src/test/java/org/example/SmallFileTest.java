package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class SmallFileTest {

    @Test
    void writeSmallFile() throws IOException {
        Path path = Path.of("file1.txt");
        byte[] bytes = "Hello World".getBytes();
        Files.write(path, bytes);
        Assertions.assertTrue(Files.exists(path));

        Path path2 = Path.of("file2.txt");
        Files.writeString(path2, "Hello File 2");
        Assertions.assertTrue(Files.exists(path2));
    }

    @Test
    void readSmallFile() throws IOException {
        Path path = Path.of("file1.txt");
        byte[] bytes = Files.readAllBytes(path);
        String content = new String(bytes);
        Assertions.assertEquals("Hello World", content);

        Path path2 = Path.of("file2.txt");
        String content2 = Files.readString(path2);
        Assertions.assertEquals("Hello File 2", content2);
    }
}
