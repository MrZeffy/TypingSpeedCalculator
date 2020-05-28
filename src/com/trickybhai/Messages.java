package com.trickybhai;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.Scanner;
// This is remote branch Improvise and improve.
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
    static String difficulty;
    static String text;
    static void startingRace() throws InterruptedException, IOException {
        String path ="src\\com\\trickybhai\\typingParagraphs\\";
        difficulty=difficulty.toLowerCase();
        switch (difficulty){
            case "easy" -> path+="Typing1.txt";
            case "legend" -> path+="Typing2.txt";
        }
        text = Files.readString(Path.of(path));
        System.out.println("Are you ready?");
        scanner.nextLine();
        System.out.println("Here is your paragraph:");
        System.out.println();
        System.out.println(text);
        System.out.println();
        System.out.println();
        System.out.println("Ready");
        Thread.sleep(1200);
        System.out.println("Set");
        Thread.sleep(1200);
        System.out.println("GO");
    }


    static void printingOutput(long time, String s){
        System.out.println("Total Time taken: "+String.format("%.2f",time/(double)1000)+" s.");
        int totalWords = CheckingInput.calculateWords(s);
        System.out.println("Total words typed: "+totalWords);
        System.out.println("Your average typing speed: "+CheckingInput.calculateWordsPerMinute(totalWords, time)+"WPM.");
        System.out.println("Your accuracy is: "+CheckingInput.accuracyCalculator(text, s));
    }

    static void setDifficulty(){
        System.out.println("Set the difficulty level:");
        System.out.println("(Easy/Intermediate/Legend)");
        difficulty = scanner.nextLine();
    }
}
