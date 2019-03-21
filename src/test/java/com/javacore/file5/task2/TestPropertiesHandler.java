package com.javacore.file5.task2;

import com.google.common.collect.Sets;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class TestPropertiesHandler {

    private static final String GOOD_PROPERTIES_FILE_1 = "good.properties";
    private static final String GOOD_PROPERTIES_FILE_2 = "good2.properties";
    private static final String[] GOOD_KEYS_1 = "key a 123".split(" ");
    private static final String[] GOOD_KEYS_2 = "key name 123".split(" ");

    private static final String BAD_PROPERTIES_FILE = "bad.properties";
    private static final String BAD_KEY = "bad";

    private final Path goodPath1 = Paths.get("src", "test", "resources", GOOD_PROPERTIES_FILE_1);
    private final Path goodPath2 = Paths.get("src", "test", "resources", GOOD_PROPERTIES_FILE_2);
    private final Path badPath = Paths.get("src", "test", "resources", BAD_PROPERTIES_FILE);

    @Test
    public void testGoodFiles() {
        new PropertiesHandler(goodPath1.toString(), goodPath2.toString());
    }

    @Test
    public void testGoodKeys() {
        PropertiesHandler propertiesHandler = new PropertiesHandler(goodPath1.toString(), goodPath2.toString());
        Set<String> result = new HashSet<>();
        for (String goodKey : GOOD_KEYS_1) {
           result.addAll(propertiesHandler.getValue(goodKey));
        }

        Set<String> expected = Sets.newHashSet("value", "opopop", "b", "987");
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testBadFile() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new PropertiesHandler(goodPath1.toString(), badPath.toString()));
    }

    @Test
    public void testBadKey() {
        PropertiesHandler propertiesHandler = new PropertiesHandler(goodPath1.toString());
        Assertions.assertThrows(IllegalArgumentException.class, () -> propertiesHandler.getValue(BAD_KEY));
    }
}
