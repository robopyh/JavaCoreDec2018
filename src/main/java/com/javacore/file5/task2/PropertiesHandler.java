package com.javacore.file5.task2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class PropertiesHandler {
    private final List<Properties> propertiesList = new ArrayList<>();

    public PropertiesHandler(String... paths) {
        for (String path : paths) {
            try (FileInputStream inStream = new FileInputStream(path)) {
                Properties properties = new Properties();
                properties.load(inStream);
                propertiesList.add(properties);
            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

    public Set<String> getValue(String key) {
        Set<String> result = new HashSet<>();
        for (Properties properties : propertiesList) {
            if (properties.containsKey(key)) {
                result.add(properties.getProperty(key));
            }
        }
        if (result.isEmpty()) {
            throw new IllegalArgumentException("No such key");
        }
        return result;
    }
}
