package com.trickybhai;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.Scanner;
// This is remote branch Improvise and improve.
public class Messages {

    //Message to be shown on startup.
    static void welcomeMessage(){
        System.out.println("Welcome to Tricky Typist.");
        System.out.println("=====================================================================");
        System.out.println("||  1. We'll give you a paragraph to write.                        ||");
        System.out.println("||  2. The program will calculate your typing speed and accuracy.  ||");
        System.out.println("||  3. Press Enter at the end of the Input.                        ||");
        System.out.println("=====================================================================");
    }


    static Scanner scanner = new Scanner(System.in);
    static String difficulty; //To set difficulty level.
    static String text; //Read input from file.

    //Main course of the meal.
    static void startingRace() throws InterruptedException, IOException {

        //Default path of demo text.
        String path ="src\\com\\trickybhai\\typingParagraphs\\";

        difficulty=difficulty.toLowerCase();
        //Adding path according to difficulty. Testing paragraphs are organized
        // in subfolders based on categories.
        path = CheckingInput.pickRandomFile(path+difficulty+"\\"); //pickRandomFile picks a random file
        // inside the given folder and return it's path.



        //Reading
        text = Files.readString(Path.of(path));

        System.out.println("Press any key to start.");
        scanner.nextLine();
        System.out.println("The fun is about to begin");

        System.out.println("Here is your paragraph:");
        System.out.println();
        System.out.println(text); //printing the demo text.
        System.out.println();
        System.out.println();
        System.out.println("Ready");
        Thread.sleep(1200);
        System.out.println("Set");
        Thread.sleep(1200);
        System.out.print("GO ========>>>");
    }

    //Calls the calculating functions and prints the final output.
    static void printingOutput(long time, String s){
        System.out.println("Total Time taken: "+String.format("%.2f",time/(double)1000)+" s.");
        int totalWords = CheckingInput.calculateWords(s);
        System.out.println("Total words typed: "+totalWords);
        System.out.println("Your average typing speed: "+CheckingInput.calculateWordsPerMinute(totalWords, time)+"WPM.");
        System.out.println("Your accuracy is: "+String.format("%.2f",CheckingInput.accuracyCalculator(text, s))+"%");
    }

    //sets the difficulty level.
    static void setDifficulty(){
        System.out.println("Set the difficulty level:");
        System.out.println("(Easy/Intermediate/Legend)");
        String s2 = scanner.nextLine();
        s2=s2.toLowerCase();
        switch (s2){
            case "easy", "intermediate", "legend" -> difficulty=s2;
            default -> setDifficulty();
         }

    }
}
