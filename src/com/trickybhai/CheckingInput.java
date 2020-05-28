package com.trickybhai;

public class CheckingInput {


    static int calculateWords(String s){
        return s.split(" ").length;
    }

    static int calculateWordsPerMinute(int totalWords, long timeTaken){
        int inOneSecond = (int) (totalWords/(timeTaken*1000));
        return inOneSecond*60;


    }



}
