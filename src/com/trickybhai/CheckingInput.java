package com.trickybhai;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CheckingInput {

    //Calculate typing speed
    static int calculateWordsPerMinute(int totalWords, long timeTaken) {
        double inOneSecond = totalWords / (timeTaken / (double) 1000);
        return (int) Math.round(inOneSecond * 60);
    }

    //Calculating accuracy.
    static String[] accuracyCalculator(String givenText, String enteredText) {
        String[] z = new String[3];
        int i = 0;
        givenText = givenText.replaceAll("[.]", " ");
        enteredText = enteredText.replaceAll("[.]", " ");

        String[] x = givenText.split(" ");
        String[] y = enteredText.split(" ");

        List<String> given = new LinkedList<>(Arrays.asList(x));
        List<String> entered = new LinkedList<>(Arrays.asList(y));

        given.removeAll(Collections.singleton(""));
        entered.removeAll(Collections.singleton(""));

        int correctWords = 0;

        while (i < entered.size()) {

            if (i != 0) {
                if (entered.get(i).equals(given.get(i)) || entered.get(i - 1).equals(given.get(i)) || entered.get(i + 1).equals(given.get(i))) {
                    correctWords++;
                } else {
                    System.out.println("Wrong word " + entered.get(i));
                }
            } else {
                if (entered.get(i).equals(given.get(i)) || entered.get(i + 1).equals(given.get(i))) {
                    correctWords++;
                } else {
                    System.out.println("Wrong word " + entered.get(i));
                }
            }
            i++;
        }
        String calc = String.valueOf((correctWords * 100) / (double) given.size());

        z[0] = String.valueOf(given.size());
        z[1] = String.valueOf(correctWords);
        z[2] = calc;

        return z;
    }


}
