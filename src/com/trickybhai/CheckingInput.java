package com.trickybhai;

import java.util.*;

public class CheckingInput {

    //Calculate typing speed
    static int calculateWordsPerMinute(int totalWords, long timeTaken) {
        double inOneSecond = totalWords / (timeTaken / (double) 1000);
        return (int) Math.round(inOneSecond * 60);
    }

    //Calculator overloaded.
    static String[] accuracyCalculator(ArrayList<String> input, String[] user) throws NullPointerException{
        //String array for storing info.
        String[] z = new String[4];
        int correctWords = 0;
        int givenWords = 0;
        int typedWords = 0;
        StringJoiner missed = new StringJoiner(","); //For storing missing words.
        StringJoiner wrong = new StringJoiner(",");  //For storing mistyped words.


        //Considering one line at a time, for both userInput and fileText.
        for (int i=0;i<2;i++){

            //Processing and comparing a single line, word by word.
            String[] inputFileLine = input.get(i).split(" ");
            String[] userInputLine = user[i].split(" ");
            for (int j=0;j<inputFileLine.length && j<userInputLine.length;j++){
                //Checking at same index.
                if (inputFileLine[j].equals(userInputLine[j])){
                    correctWords+=1;
                }else{
                    if (j>0){
                        //Checking at previous index.
                        if (userInputLine[j].equals(inputFileLine[j-1])){
                            correctWords+=1;
                            System.out.println("You added an extra word: "+userInputLine[j-1]);
                            continue;
                        }
                    }
                    if (j<inputFileLine.length-1){
                        //Checking at previous index.
                        if (userInputLine[j].equals(inputFileLine[j+1])){
                            correctWords+=1;
                            //Adding missing word to missing String.
                            missed.add(inputFileLine[j]);
                            continue;
                        }

                    }
                    //Adding wrong words to wrong string.
                    wrong.add(userInputLine[j]);

                }
            }
            //Printing wrong and missing words if any.
            if (wrong.length()!=0){
                System.out.println("Wrong words: "+wrong.toString());
            }
            if (missed.length()!=0){
                System.out.println("Missing words: "+missed.toString());
            }
            givenWords+=inputFileLine.length;
            typedWords+=userInputLine.length;
        }
        z[0] = String.valueOf(givenWords);
        z[1] = String.valueOf(correctWords);
        z[2] = String.valueOf((correctWords * 100) / (double) givenWords);
        z[3] = String.valueOf(typedWords);

        return z;
    }

    //Calculating Average speed.
    static double calculateAverage(ArrayList<Integer> s){
        int sum =0;
        for (int i:
             s) {
            sum+=i;
        }
        return sum/(double)(s.size());

    }
}

// TODO: Optimize code
