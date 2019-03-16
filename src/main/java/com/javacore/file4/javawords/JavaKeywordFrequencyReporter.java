package com.javacore.file4.javawords;

import com.javacore.file4.javawords.frequency.JavaKeywordFrequency;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class JavaKeywordFrequencyReporter {
    
    private final FileIO fileIO;
    private final Path in;
    private final Path out;

    public JavaKeywordFrequencyReporter(FileIO fileIO, Path in, Path out) {
        this.fileIO = fileIO;
        this.in = in;
        this.out = out;
    }
    
    public void report() {
        final String lines = fileIO.read(in);
        final Map<String, Integer> frequency = new JavaKeywordFrequency().find(lines);

        final String result = buildString(frequency);

        fileIO.write(result, out);
    }

    private String buildString(Map<String, Integer> frequency) {
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(frequency.entrySet());
        StringBuilder result = new StringBuilder();

        try (Stream<Map.Entry<String, Integer>> stream = sortedList.stream()) {
            stream
                    .sorted(Map.Entry.<String, Integer>comparingByValue()
                            .reversed()
                            .thenComparing(Map.Entry.comparingByKey()))
                    .forEach(entry -> result.append(entry.getKey()).append(" - ").append(entry.getValue()).append("\n"));
        }

        return result.toString();
    }
}
