package com.trickybhai;

import java.util.StringJoiner;

public class CheckingInput {

    //Calculate typing speed
    static int calculateWordsPerMinute(int totalWords, long timeTaken) {
        double inOneSecond = totalWords / (timeTaken / (double) 1000);
        return (int) Math.round(inOneSecond * 60);
    }

    //Calculator overloaded.
    static String[] accuracyCalculator(String[] user) throws NullPointerException {

        //String array for storing info.
        String[] z = new String[5];
        int correctWords = 0;
        int givenWords = 0;
        int typedWords = 0;
        int offby = 0;
        StringJoiner missed = new StringJoiner(", "); //For storing missing words.
        StringJoiner right = new StringJoiner(", "); //For storing correct word per wrong.
        StringJoiner wrong = new StringJoiner(", ");  //For storing mistyped words.


        //Considering one line at a time, for both userInput and fileText.
        for (int i = 0; i < 2; i++) {

            //Processing and comparing a single line, word by word.
            String[] inputFileLine = Main.selectedText.get(i).split(" ");
            String[] userInputLine = user[i].split(" ");

            for (int x = 0; x < userInputLine.length && x < inputFileLine.length; x++) {

                String w = userInputLine[x];

                //Checking if its the first word for off by one check. If so, we don't do the x-1 check

                if (x > 0) {
                    if (w.equals(inputFileLine[x])) {
                        correctWords++;
                    } else if (w.equals(inputFileLine[x - 1])) {
                        correctWords++;
                        offby++;
                        missed.add(w);
                    } else if (x + 1 != userInputLine.length) {
                        if (w.equals(inputFileLine[x + 1])) {
                            correctWords++;
                            offby++;
                            missed.add(w);
                        }
                    } else {
                        wrong.add(w);
                        right.add(inputFileLine[x]);
                    }
                } else {
                    if (w.equals(inputFileLine[x])) {
                        correctWords++;
                    } else if (w.equals(inputFileLine[x + 1])) {
                        correctWords++;
                        offby++;
                        missed.add(w);
                    } else {
                        wrong.add(w);
                        right.add(inputFileLine[x]);
                    }
                }
                typedWords++;
                givenWords++;
            }
        }

        z[0] = String.valueOf(givenWords);
        z[1] = String.valueOf(correctWords);
        z[2] = String.valueOf((correctWords * 100) / (double) givenWords);
        z[3] = String.valueOf(typedWords);

        if (offby != 0) {
            z[4] = String.valueOf(offby);
        } else {
            z[4] = "NA";
        }

        System.out.println("Wrong Words: ");
        System.out.println(wrong);
        System.out.println("Correct Words: ");
        System.out.println(right);

        return z;
    }

    //Calculating Average speed.
    static double calculateAverage() {
        int sum = 0;
        for (int i :
                Main.scores) {
            sum += i;
        }
        return sum / (double) (Main.scores.size());

    }
}

// TODO: Optimize code
