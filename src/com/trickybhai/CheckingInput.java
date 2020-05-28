package com.trickybhai;

import java.io.File;
import java.util.Random;

public class CheckingInput {


    //calculating total words entered.
    static int calculateWords(String s){
        return s.split(" ").length;
    }

    //Calculate typing speed
    static int calculateWordsPerMinute(int totalWords, long timeTaken){
        double inOneSecond = totalWords/(timeTaken/(double)1000);
        return (int) Math.round(inOneSecond*60);
    }

    //Calculating accuracy.
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

    //Opening a random file inside a given directory.
    static String pickRandomFile(String home){
        File files = new File(home);
        File[] files1 = files.listFiles();
        Random random = new Random();
        assert files1 != null;
        return files1[random.nextInt(files1.length)].getPath();
    }



}
