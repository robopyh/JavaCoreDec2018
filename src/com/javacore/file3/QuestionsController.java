package com.javacore.file3;

import com.google.common.primitives.Ints;

import java.util.Scanner;

public class QuestionsController  {
    private View view = new View();
    private Questions questions = new Questions();

    public static void main(String[] args) {
        QuestionsController questionsController = new QuestionsController();

        Scanner scanner = new Scanner(System.in);

        System.out.println("True Or False quiz!\nTry to guess are this statements true or false.\n");
        System.out.println("Type \"ENG\" or \"RUS\" to change the language to English or Russian respectively.");
        System.out.println("Type a number from 1 to 5 to see an answer.\n");
        questionsController.view.printQuestions(questionsController.questions);

        while (true) {
            String input = scanner.nextLine();
            switch (input) {
                case "ENG": {
                    questionsController.swapLanguage(Questions.LANGUAGE.ENG);
                    break;
                }
                case "RUS": {
                    questionsController.swapLanguage(Questions.LANGUAGE.RUS);
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

    private void swapLanguage(Questions.LANGUAGE language) {
        questions.setLanguage(language);
        view.printQuestions(questions);
    }

    private boolean updateAnswer(String input) {
        Integer number = Ints.tryParse(input);
        if (number == null || number < 1 || number > 5) {
            return false;
        }

        questions.setNumber(number - 1);
        view.printAnswer(questions);

        return true;
    }
}
