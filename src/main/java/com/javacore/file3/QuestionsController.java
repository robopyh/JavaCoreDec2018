package com.javacore.file3;

import com.google.common.primitives.Ints;

import java.util.Locale;
import java.util.Scanner;

public class QuestionsController  {
    private View view = new View();
    private Questions questions = new Questions();

    public static void main(String[] args) {
        QuestionsController questionsController = new QuestionsController();

        Scanner scanner = new Scanner(System.in);

        System.out.println("True Or False quiz!\nTry to guess are this statements true or false.\n");
        System.out.println("Type \"eng\" or \"rus\" to change the language to English or Russian respectively.");
        System.out.println("Type a number from 1 to 5 to see an answer.\n");
        questionsController.view.printQuestions(questionsController.questions);

        while (true) {
            String input = scanner.nextLine().toLowerCase();
            switch (input) {
                case "eng": {
                    questionsController.swapLanguage(Locale.US);
                    break;
                }
                case "rus": {
                    questionsController.swapLanguage(new Locale("ru", "RU"));
                    break;
                }
                default: {
                    if (!questionsController.updateAnswer(input)) {
                        System.out.println("Incorrect input. Try again.\n");
                    }
                }
            }
        }
    }

    private void swapLanguage(Locale locale) {
        questions.setLanguage(locale);
        view.printQuestions(questions);
    }

    private boolean updateAnswer(String input) {
        Integer number = Ints.tryParse(input);
        if (number == null || number < 1 || number > 5) {
            return false;
        }

        questions.setNumber(number);
        view.printAnswer(questions);

        return true;
    }
}
