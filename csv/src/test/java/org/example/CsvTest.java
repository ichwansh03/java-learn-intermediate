package org.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;

class CsvTest {

    @Test
    void createCSV() throws IOException {
        StringWriter writer = new StringWriter();

        CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT);
        printer.printRecord("Ichwan","Sholihin","Natar",22);
        printer.printRecord("Ahmad","Awaluddin","Metro",23);
        printer.flush();

        String string = writer.getBuffer().toString();
        Assertions.assertNotNull(printer);
        System.out.println(string);
    }

    @Test
    void readCSV() throws IOException {
        Path path = Path.of("sample.csv");
        Reader reader = Files.newBufferedReader(path);

        CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT);
        for (CSVRecord record : parser){
            System.out.println("First name: "+record.get(0));
            System.out.println("Last name: "+record.get(1));
            System.out.println("Address: "+record.get(2));
            System.out.println("Age: "+record.get(3));
        }
    }

    @Test
    void readCSVWithHeader() throws IOException {
        Path path = Path.of("sample.csv");
        Reader reader = Files.newBufferedReader(path);

        CSVFormat format = CSVFormat.DEFAULT.builder().setHeader().build();
        CSVParser parser = new CSVParser(reader, format);
        for (CSVRecord record : parser){
            System.out.println("First name: "+record.get("First name"));
            System.out.println("Last name: "+record.get("Last name"));
            System.out.println("Address: "+record.get("Address"));
            System.out.println("Age: "+record.get("Age"));
        }
    }

    @Test
    void createCSVWithHeader() throws IOException {
        StringWriter writer = new StringWriter();

        CSVFormat format = CSVFormat.DEFAULT.builder()
                .setHeader("First name", "Last name", "Address", "Age")
                .build();

        CSVPrinter printer = new CSVPrinter(writer, format);
        printer.printRecord("Abdul","Malik","Pesawaran",24);
        printer.printRecord("Dani","Ramadhan","Kotabumi",25);
        printer.flush();

        String string = writer.getBuffer().toString();
        Assertions.assertNotNull(printer);
        System.out.println(string);
    }

    @Test
    void createCSVWithTDFFormat() throws IOException {
        StringWriter writer = new StringWriter();

        CSVFormat format = CSVFormat.TDF.builder()
                .setHeader("First name", "Last name", "Address", "Age")
                .build();

        CSVPrinter printer = new CSVPrinter(writer, format);
        printer.printRecord("Abdul","Malik","Pesawaran",24);
        printer.printRecord("Dani","Ramadhan","Kotabumi",25);
        printer.flush();

        String string = writer.getBuffer().toString();
        Assertions.assertNotNull(printer);
        System.out.println(string);
    }

}
