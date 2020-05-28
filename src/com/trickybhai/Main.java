package com.trickybhai;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static boolean repeated = false;
    public static void main(String[] args) throws InterruptedException {
	// write your code here
        if (!repeated){
            Messages.welcomeMessage();
        }

        Messages.startingRace();

        String s = takeInput();
        Messages.printingOutput(timeTaken,s);



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
                Thread.sleep(2000);
            }
        }
    }

    private static long timeTaken;

    public static String takeInput(){
        long start = System.currentTimeMillis();
        String s1 = scanner.nextLine();
        long end = System.currentTimeMillis();
        timeTaken = (end-start);
        return s1;
    }
}
