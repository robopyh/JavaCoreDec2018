package com.javacore.file4.task3;

import com.google.common.base.Charsets;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class TestConverter {

    @Test
    public void testConvert() throws IOException {
        final Charset inEncoding = Charsets.UTF_8;
        final Charset outEncoding = Charsets.UTF_16;
        final Path in = Paths.get("src", "test", "resources", "simpleRUS.txt");
        final Path out = Paths.get("src", "test", "resources", "UTF16.txt");

        EncodingConverter encodingConverter = new EncodingConverter(in, inEncoding, out, outEncoding);
        encodingConverter.convert();

        final String expected = Files.lines(in, inEncoding)
                .collect(Collectors.joining(System.lineSeparator()));

        final String result = Files.lines(out, outEncoding)
                .collect(Collectors.joining(System.lineSeparator()));

        Assertions.assertEquals(expected, result);
    }
}
