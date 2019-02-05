package com.javacore.file3;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;


/**
 * Class provides the questions on English and Russian languages.
 */
public final class Questions {
    private final List<String> questions = new ArrayList<>();

    private Locale locale = Locale.US;
    private int number;


    public void setLanguage(@NonNull Locale locale) {
        this.locale = locale;
        questions.clear();
    }

    public List<String> getQuestions() {
        if (questions.isEmpty()) {
            loadQuestions();
        }
        return questions;
    }

    private void loadQuestions() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("com.javacore.file3.Questions", locale);
        for (String key : resourceBundle.keySet()) {
            questions.add(resourceBundle.getString(key));
        }
    }

    /**
     * Sets a number of the question that will be answered.
     *
     * @param number the number of the question
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Gets a string answer on the chosen question in the preferred language.
     *
     * @return a string answer
     */
    public String getStringAnswer() {
        return loadAnswer();
    }

    private String loadAnswer() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Answers", locale);
        return resourceBundle.getString("answer_" + number);
    }
}
