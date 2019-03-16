package com.javacore.file4.javawords;

import com.google.common.collect.Lists;
import com.javacore.file4.javawords.frequency.JavaKeywordFrequency;
import com.javacore.file4.javawords.frequency.KeywordFrequency;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TestFrequency {

    @Test
    public void testSimpleWords() throws IOException {
        Map<String, Integer> expected = new HashMap<String, Integer>() {{
            put("задание", 4);
            put("потоками", 3);
            put("файл", 7);
        }};

        Map<String, Integer> result = new KeywordFrequency().find(
                Files.lines(Paths.get("src", "test", "resources", "simpleRUS.txt"))
                        .collect(Collectors.joining(System.lineSeparator())),
                Lists.newArrayList("задание потоками файл".split(" "))
        );

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testJavaWords() throws IOException {
        Map<String, Integer> expected = new HashMap<String, Integer>() {{
            put("package", 1);
            put("import", 5);
            put("public", 3);
            put("class", 1);
            put("private", 2);
            put("final", 2);
            put("this", 2);
            put("for", 1);
            put("try", 1);
            put("catch", 1);
            put("return", 1);
        }};

        Map<String, Integer> result = new JavaKeywordFrequency().find(
                Files.lines(Paths.get("src", "test", "resources", "CombinedTextFileStream.java"))
                .collect(Collectors.joining(System.lineSeparator()))
        );

        Assertions.assertEquals(expected, result);

    }
}
