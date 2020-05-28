package com.trickybhai;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static long timeTaken; //Used for Calculating time taken by user to type.
    private static String input;  // Used for storing user's input to be checked.
    private static final Scanner scanner = new Scanner(System.in); //for scanning.
    private static boolean repeated = false; // for checking if user wants to play again.
    public static void main(String[] args) throws InterruptedException, IOException {

        if (!repeated){  //If user plays again, don't print welcome message.
            Messages.welcomeMessage();
        }
        Messages.setDifficulty(); // asks user to set the difficulty level.
        Messages.startingRace(); //Start the race.
        takeInput();             //Taking input from user
        Messages.printingOutput(timeTaken,input);  //Printing the answer output.

        //Asking if user wants to test again.
        System.out.println("Do you want to test again?");
        String again = scanner.nextLine();
        again = again.toLowerCase();
        switch (again){
            case "yes" -> {
                repeated=true;
                Main.main(null);
            }
            case "no" -> {
                System.out.println("Application is shutting down.");
                Thread.sleep(1000);
            }
        }
    }


    //Used for taking string input and calculating time taken by user to Enter the string.
    public static void takeInput(){
        long start = System.currentTimeMillis();
        input = scanner.nextLine();
        long end = System.currentTimeMillis();
        timeTaken = (end-start);
    }
}
