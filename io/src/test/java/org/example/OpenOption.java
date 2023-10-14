package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * menambahkan standard open option agar setiap kali writer dijalankan
 * item dari pathnya akan bertambah bukan di replace
 */
public class OpenOption {

    @Test
    void append() {
        Path path = Path.of("append.txt");
        try(Writer writer = Files.newBufferedWriter(path, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            writer.write("Add Append\n");
            writer.flush();
        } catch (IOException e){
            Assertions.fail(e);
        }
    }
}
