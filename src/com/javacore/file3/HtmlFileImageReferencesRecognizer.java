package com.javacore.file3;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;

/**
 * Class that allows to define is a HTML-file contains consecutive image references
 * and find sentences that contains at least one reference.
 */
public class HtmlFileImageReferencesRecognizer {
    private String fileText;

    /**
     * Instantiates a new HTML-file image references recognizer.
     *
     * @param file        a file to analyze in .html format
     * @param charsetName a file's charset
     * @throws IOException the io exception
     */
    public HtmlFileImageReferencesRecognizer(File file, String charsetName) throws IOException {
        Document document = Jsoup.parse(file, charsetName, "");
        fileText = document.body().text();
    }

    /**
     * Find consecutive image references in file.
     *
     * @return the boolean
     */
    public boolean isConsecutiveReferences() {
        if (fileText.matches(".*\\(.ис\\. \\d{1,2} и \\d{1,2}.*")) {
            System.out.println("There are the consecutive references to images.");
            return true;
        }
        System.out.println("There are no consecutive references to images.");
        return false;
    }

    /**
     * Print sentences with image references.
     */
    public void showSentencesWithImageReference() {
        int number = 1;
        String[] sentences = fileText.split("(?<!.ис)[.?!]");

        for (String sentence : sentences) {
            if (sentence.contains("(Рис") || sentence.contains("(рис")) {
                System.out.println(number++ + ". " + sentence);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        HtmlFileImageReferencesRecognizer imageRecognizer = new HtmlFileImageReferencesRecognizer(new File("text.html"), "Cp1251");

        imageRecognizer.isConsecutiveReferences();
        imageRecognizer.showSentencesWithImageReference();
    }
}
