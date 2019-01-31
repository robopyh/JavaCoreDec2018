package com.javacore.file3;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;


/**
 * Class provides the questions on English and Russian languages.
 */
public final class Questions {
    private final List<String> russianQuestions = new ArrayList<>();
    private final List<String> englishQuestions = new ArrayList<>();

    private final List<String[]> answers = new ArrayList<>();

    {
        russianQuestions.add("1. Криптонит является источником силы Супермена.");
        russianQuestions.add("2. Только американские астронавты и советские космонавты высаживались на Луне.");
        russianQuestions.add("3. Название улицы «Уолл-стрит» происходит от ряда (\"стены\") банков, " +
                "которые приветствовали посетителей финансового района Нью-Йорка в 19 веке.");
        russianQuestions.add("4. Шоколад может быть смертельным для собак.");
        russianQuestions.add("5. Сэндвич назван в честь человека.");

        englishQuestions.add("1. Kryptonite is the source of Superman's power.");
        englishQuestions.add("2. Only Americans and Soviets have walked on the Moon.");
        englishQuestions.add("3. The name \"Wall Street\" stems from the row (\"wall\") of banks" +
                " that greeted visitors to New York City's financial district in the 1800s.");
        englishQuestions.add("4. Chocolate can be lethal to dogs.");
        englishQuestions.add("5. Sandwich, the food item, is named after a person.");

        answers.add(new String[]{"Неверно.\nКриптонит, который является радиоактивным мусором после разрушения Криптона (его родной планеты) ослабляет его.",
                "False.\nKryptonite, the radioactive debris from the destruction of Krypton (his home planet), nullifies his powers."});
        answers.add(new String[]{"Неверно.\n12 человек присутствовали на Луне (между 1969 и 1972 годами), и все они были американскими астронавтами миссии Аполлон.",
                "False.\nTwelve men have walked on the Moon (between 1969 and 1972), and all were Americans on Apollo missions."});
        answers.add(new String[]{"Неверно.\nНазвание, вероятно, произошло от стены 17 века, установленной голландскими поселенцами для отражения нападений британцев и индейцев.",
                "False.\nThe name likely stems from a 17th-century wall erected by Dutch settlers to repel a British or Indian attack."});
        answers.add(new String[]{"Верно.\nШоколад содержит алкалоидные стимуляторы: кофеин и теобромин, причем последний очень токсичен для собак.",
                "True.\nChocolate contains the alkaloid stimulants caffeine and theobromine, the latter being highly toxic to dogs."});
        answers.add(new String[]{"Верно.\nХотя английский граф Сэндвич (1718-1792) не был первым, кто ел мясо между двумя кусками хлеба, его любовь к этой закуске породила знаменитое название.",
                "True.\nThough England's Earl of Sandwich (1718-1792) wasn't the first to eat meat between two slices of bread, his fondness for it generated its famous name."});
    }

    private LANGUAGE language = LANGUAGE.ENG;
    private int number;

    public enum LANGUAGE {RUS, ENG}


    public void setLanguage(@NonNull LANGUAGE language) {
        this.language = language;
    }

    public List<String> getQuestions() {
        if (language == LANGUAGE.RUS) {
            return russianQuestions;
        }
        return englishQuestions;
    }

    /**
     * Sets a number of the question will be answered.
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
        String[] answersArray = answers.get(number);
        if (this.language == LANGUAGE.RUS) {
            return answersArray[0];
        }
        return answersArray[1];
    }
}
