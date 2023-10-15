package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

public class OutputStreamTest {

    @Test
    void writeOutputStream() {

        Path path = Path.of("output.txt");
        try(OutputStream stream = Files.newOutputStream(path)) {
            for (int i = 0; i < 50; i++) {
                stream.write("Write data\n".getBytes());
                stream.flush();
            }
        } catch (IOException e){
            Assertions.fail(e);
        }
    }
    
    @Test
    void testWriter(){
        Path path = Path.of("writer.txt");
        try(Writer writer = Files.newBufferedWriter(path)) {
            for (int i = 0; i < 50; i++) {
                writer.write("Write data\n");
                writer.flush();
            }
        } catch (IOException e){
            Assertions.fail(e);
        }
    }

    @Test
    void printStream(){
        Path path = Path.of("print.txt");

        try(OutputStream outputStream = Files.newOutputStream(path);
            PrintStream stream = new PrintStream(outputStream)) {

            stream.println("print 1");
            stream.println("print 2");

        } catch (IOException e){
            Assertions.fail(e);
        }
    }
}
