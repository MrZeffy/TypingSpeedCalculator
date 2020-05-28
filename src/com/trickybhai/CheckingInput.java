package com.trickybhai;

public class CheckingInput {


    static int calculateWords(String s){
        return s.split(" ").length;
    }

    static int calculateWordsPerMinute(int totalWords, long timeTaken){
        double inOneSecond = totalWords/(timeTaken/(double)1000);
        return (int) Math.round(inOneSecond*60);
    }

    static double accuracyCalculator(String givenText, String enteredText){
        givenText = givenText.replaceAll("\n", "");
        String[] given = givenText.split(" ");
        String[] entered = enteredText.split(" ");
        int correctWords = 0;
        for(int i=0;i<entered.length;i++){
            if (entered[i].equals(given[i])){
                correctWords+=1;
            }else
                System.out.println("Wrong word"+entered[i]);
        }
        System.out.println("Total correct words: "+correctWords);
        return (correctWords*100)/(double)given.length;
    }



}
