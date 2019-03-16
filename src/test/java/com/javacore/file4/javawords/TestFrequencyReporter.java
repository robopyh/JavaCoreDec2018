package com.javacore.file4.javawords;

import com.javacore.file4.javawords.task1.FileByteStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class TestFrequencyReporter {

    @Test
    public void testReport() throws IOException {
        final String expected =
        "import - 5\n" +
        "public - 3\n" +
        "final - 2\n" +
        "private - 2\n" +
        "this - 2\n" +
        "catch - 1\n" +
        "class - 1\n" +
        "for - 1\n" +
        "package - 1\n" +
        "return - 1\n" +
        "try - 1";

        Path in = Paths.get("src", "test", "resources", "CombinedTextFileStream.java");
        Path out = Paths.get("src", "test", "resources", "JavaOut.txt");
        FileIO fileIO = new FileByteStream();


        JavaKeywordFrequencyReporter javaKeywordFrequencyReporter = new JavaKeywordFrequencyReporter(fileIO, in, out);
        javaKeywordFrequencyReporter.report();

        String result = Files.lines(Paths.get("src", "test", "resources", "JavaOut.txt"))
                .collect(Collectors.joining("\n"));

        Assertions.assertEquals(expected, result);
    }
}
