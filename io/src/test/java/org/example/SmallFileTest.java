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
}
