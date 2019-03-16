package com.javacore.file4.javawords;

import com.javacore.file4.javawords.task1.FileByteStream;
import com.javacore.file4.javawords.task2.FileCharacterStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class TestIOStream {

    @Test
    public void testRead() throws IOException {
        final Path path = Paths.get("src", "test", "resources", "simpleENG.txt");

        String expected = Files.lines(path)
                .collect(Collectors.joining(System.lineSeparator()));

        String resultByte = new FileByteStream().read(path);
        String resultCharacter = new FileCharacterStream().read(path);

        Assertions.assertEquals(expected, resultByte);
        Assertions.assertEquals(expected, resultCharacter);
    }

    @Test
    public void testWrite() throws IOException {
        final Path outByte = Paths.get("src", "test", "resources", "outputByte.txt");
        final Path outCharacter = Paths.get("src", "test", "resources", "outputCharacter.txt");
        final Path in = Paths.get("src", "test", "resources", "simpleENG.txt");

        String expected = Files.lines(in)
                .collect(Collectors.joining(System.lineSeparator()));

        new FileByteStream().write(expected, outByte);
        new FileCharacterStream().write(expected, outCharacter);

        String resultByte = Files.lines(outByte)
                .collect(Collectors.joining(System.lineSeparator()));
        String resultCharacter = Files.lines(outCharacter)
                .collect(Collectors.joining(System.lineSeparator()));

        Assertions.assertEquals(expected, resultByte);
        Assertions.assertEquals(expected, resultCharacter);
    }

    @Test
    public void testBadFile() {
        final Path badFile = Paths.get("src", "test", "resources", "1.txt");

        Assertions.assertEquals("", new FileByteStream().read(badFile));
        Assertions.assertEquals("", new FileCharacterStream().read(badFile));
    }
}
