package com.javacore.file5.task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TestPropertiesHandler {

    private static final String GOOD_PROPERTIES_FILE = "good.properties";
    private static final String[] GOOD_KEYS = "key a 123".split(" ");

    private static final String BAD_PROPERTIES_FILE = "bad.properties";
    private static final String BAD_KEY = "bad";

    private final Path goodPath = Paths.get("src", "test", "resources", GOOD_PROPERTIES_FILE);
    private final Path badPath = Paths.get("src", "test", "resources", BAD_PROPERTIES_FILE);

    @Test
    public void testGoodFile() {
        new PropertiesHandler(goodPath.toString());
    }

    @Test
    public void testGoodKey() {
        PropertiesHandler propertiesHandler = new PropertiesHandler(goodPath.toString());
        for (String goodKey : GOOD_KEYS) {
            propertiesHandler.getValue(goodKey);
        }
    }

    @Test
    public void testBadFile() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new PropertiesHandler(badPath.toString()));
    }

    @Test
    public void testBadKey() {
        PropertiesHandler propertiesHandler = new PropertiesHandler(goodPath.toString());
        Assertions.assertThrows(IllegalArgumentException.class, () -> propertiesHandler.getValue(BAD_KEY));
    }
}
