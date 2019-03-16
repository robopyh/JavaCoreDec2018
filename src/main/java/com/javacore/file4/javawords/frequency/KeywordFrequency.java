package com.javacore.file4.javawords.frequency;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeywordFrequency {

    public Map<String, Integer> find(String lines, List<String> keywords) {
        final Map<String, Integer> reservedWordsFrequency = new HashMap<>();

        Arrays.stream(lines.toLowerCase().split("[^\\p{L}]"))
                .filter(keywords::contains)
                .forEach(word -> reservedWordsFrequency.merge(word, 1, Integer::sum));

        return reservedWordsFrequency;
    }
}