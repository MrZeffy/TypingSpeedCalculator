package com.trickybhai;

import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

// This is remote branch Improvise and improve.
public class Messages extends Main {

    static final Scanner scanner = new Scanner(System.in);
    static String difficulty; //To set difficulty level.

    //Message to be shown on startup.
    static void welcomeMessage() {
        System.out.println("Welcome to Tricky Typist.");
        System.out.println("===========================================================================");
        System.out.println("||  1. We'll give you a paragraph to write.                              ||");
        System.out.println("||  2. The program will calculate your typing speed and accuracy.        ||");
        System.out.println("||  3. Press Enter after you have finished writing the entire paragraph  ||");
        System.out.println("===========================================================================");
    }

    //sets the difficulty level.
    static void setDifficulty() {
        System.out.println("Set the difficulty level:");
        System.out.println("(Easy/Intermediate/Hard)");
        String s2 = scanner.nextLine();
        s2 = s2.toLowerCase();
        switch (s2) {
            case "easy", "intermediate", "hard" -> difficulty = s2;
            default -> setDifficulty();
        }

        difficulty = difficulty.toLowerCase();
        //Adding path according to difficulty. Testing paragraphs are organized
        // in subfolders based on categories.
        Main.path = Main.path + difficulty + ".txt"; //pickRandomFile picks a random file
        // inside the given folder and return it's path.


    }

    //Main course of the meal.
    static void startingRace() {


        //Reading
        System.out.println("Press Enter to start.");
        scanner.nextLine();
        System.out.println("The fun is about to begin");

        System.out.println("Here is your paragraph:");
        System.out.println();
        for (int i=0;i<2;i++){
            String string = textFromFile.get(ThreadLocalRandom.current().nextInt(0,textFromFile.size()));
            selectedText.add(string);
            System.out.println(string);
        }
        System.out.println();
    }


    //Calls calculating functions and prints output.
    static void printingOutput(long time, String[] user) {
        String[] info;

        info = CheckingInput.accuracyCalculator(selectedText, user);
        int speed = CheckingInput.calculateWordsPerMinute(Integer.parseInt(info[3]), time);
        scores.add(speed);
        System.out.println("Total Time Taken: " + String.format("%.2f", time / (double) 1000) + " s.");
        System.out.println("Typing Speed: " + speed + "WPM.");
        System.out.println("Total words given: "+info[0]);
        System.out.println("Total Words Typed: " + info[3]);
        System.out.println("Total Correct Words: " + info[1]);
        System.out.println("Your Accuracy Is: " + String.format("%.2f",Double.parseDouble(info[2])) + "%");
        if (repeated){

            System.out.println("In This Session");
            System.out.println("Top Speed: "+ Collections.max(scores));
            System.out.println("Average Speed: "+ String.format("%.2f",CheckingInput.calculateAverage(scores)));
        }
    }
}
