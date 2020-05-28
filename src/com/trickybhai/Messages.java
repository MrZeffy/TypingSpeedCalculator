package com.trickybhai;

import java.util.Scanner;

public class Messages {
    static void welcomeMessage(){
        System.out.println("Welcome to Tricky Typist.");
        System.out.println("=====================================================================");
        System.out.println("||  1. We'll give you a paragraph to write.                        ||");
        System.out.println("||  2. The program will calculate your typing speed and accuracy.  ||");
        System.out.println("||  3. Press Enter at the end of the Input.                        ||");
        System.out.println("=====================================================================");
    }

    static Scanner scanner = new Scanner(System.in);

    static void startingRace() throws InterruptedException {
        System.out.println("Are you ready?");
        scanner.nextLine();
        System.out.println("Here is your paragraph:");
        System.out.println();
        System.out.println("Instagram is a very great platform. We are going to have a great webinar. We want to encourage a lot of people and then we can work as a team. ");
        System.out.println();
        System.out.println();
        System.out.println("Ready");
        Thread.sleep(1200);
        System.out.println("Set");
        Thread.sleep(1200);
        System.out.println("GO");
    }

    static void printingOutput(long time, String s){
        System.out.println("Total Time taken: "+(time*1000)+" s.");
        int totalWords = CheckingInput.calculateWords(s);
        System.out.println("Total words typed: "+totalWords);
        System.out.println("Your average typing speed: "+CheckingInput.calculateWordsPerMinute(totalWords, time));

    }
}
