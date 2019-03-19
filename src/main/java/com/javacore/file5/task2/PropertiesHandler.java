package com.javacore.file5.task2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHandler {
    private final Properties properties = new Properties();

    public PropertiesHandler(String path) {
        try (FileInputStream inStream = new FileInputStream(path)) {
            this.properties.load(inStream);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public String getValue(String key) {
        String result = properties.getProperty(key);
        if (result == null) {
            throw new IllegalArgumentException("No such key");
        }
        return result;
    }
}
