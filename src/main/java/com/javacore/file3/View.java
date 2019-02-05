package com.javacore.file3;

public class View {
    /**
     * Prints questions in the chosen language.
     *
     * @param questions a {@link Questions} object
     */
    public void printQuestions(Questions questions) {
        for (String question : questions.getQuestions()) {
            System.out.println(question);
        }
        System.out.println();
    }

    /**
     * Prints answer for the chosen question.
     *
     * @param questions a {@link Questions} object
     */
    public void printAnswer(Questions questions) {
        System.out.println(questions.getStringAnswer());
        System.out.println();
    }
}
