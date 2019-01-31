package com.javacore.file3;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;

public class HtmlImageRecognizer {
    private String fileText;

    public HtmlImageRecognizer(File file, String charsetName) throws IOException {
        Document document = Jsoup.parse(file, charsetName, "");
        fileText = document.body().text();
    }

    private boolean findConsecutiveReferences() {
        if (fileText.matches(".*\\(.ис\\. \\d{1,2} и \\d{1,2}.*")) {
            System.out.println("There are the consecutive references to images.");
            return true;
        }
        System.out.println("There are no consecutive references to images.");
        return false;
    }

    private void showSentencesWithImageReference() {
        int number = 1;
        String[] sentences = fileText.split("(?<!.ис)[.?!]");

        for (String sentence : sentences) {
            if (sentence.contains("(Рис") || sentence.contains("(рис")) {
                System.out.println(number++ + ". " + sentence);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        HtmlImageRecognizer imageRecognizer = new HtmlImageRecognizer(new File("text.html"), "Cp1251");

        imageRecognizer.findConsecutiveReferences();
        imageRecognizer.showSentencesWithImageReference();
    }
}
