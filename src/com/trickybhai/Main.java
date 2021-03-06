package com.trickybhai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
/*import java.util.LinkedList;
import java.util.List;*/

@SuppressWarnings("ConstantConditions")
public class Main {

    private static final Scanner scanner = new Scanner(System.in); //for scanning.
    public static String path;
    static final ArrayList<Integer> scores = new ArrayList<>(); //for maintaining scores.
    static boolean repeated = false; // for checking if user wants to play again.
    static final ArrayList<String> textFromFile = new ArrayList<>();
    static final ArrayList<String> selectedText = new ArrayList<>();
    //public static String text = ""; //Read input from file.
    //public static List<String> out = new LinkedList<>();
    private static long timeTaken; //Used for Calculating time taken by user to type.
    private static String[] input;  // Used for storing user's input to be checked.

    public static void main(String[] args) throws InterruptedException, IOException {
        boolean devmode = false;

        if (!devmode) {
            if (!repeated) {  //If user plays again, don't print welcome message.
                Messages.welcomeMessage();
            }
            Messages.setDifficulty(); // asks user to set the difficulty level.
            Randomizer.hashmapGenerator();
            Messages.startingRace(); //Start the race.
            takeInput();             //Taking input from user
            //Messages.printingOutput(timeTaken, input);  //Printing the answer output.
            Messages.printingOutput(timeTaken, input);
            //Asking if user wants to test again.
            System.out.println("Do you want to test again?");
            String again = scanner.nextLine();
            again = again.toLowerCase();
            switch (again) {
                case "yes" -> {
                    selectedText.clear();
                    repeated = true;
                    Main.main(null);
                }
                case "no" -> {
                    System.out.println("Application is shutting down.");
                    Thread.sleep(1000);
                }
            }
        } else {
            Messages.setDifficulty();
            Randomizer.hashmapGenerator();
        }
    }

    //Used for taking string input and calculating time taken by user to enter the string.
    public static void takeInput() throws IOException {
        long start = System.currentTimeMillis();
        input = new String[selectedText.size()];
//        input = scanner.nextLine();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 2; i++) {
            input[i] = bufferedReader.readLine();
        }
        long end = System.currentTimeMillis();
        timeTaken = (end - start);
    }
}
// There's a bug in selecting lines. Gotta fix that.
