package com.javacore.file3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CrazyLogger {
    private final StringBuilder log = new StringBuilder();

    public void log(String message) {
        String currentDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-YYYY : hh-mm"));
        log.append(currentDateTime).append(" – ").append(message).append(";\n");
    }

    public void showAllMessages() {
        System.out.println("\nCurrent log:\n" + log.toString());
    }

    public void findMessage(String query) {
        System.out.println("Querying for \"" + query + "\" ...");

        String[] logMessages = log.toString().split("\n");
        for (String message : logMessages) {
            if (message.contains(query)) {
                System.out.println(message);
            }
        }
    }
}
