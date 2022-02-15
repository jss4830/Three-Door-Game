/*
 * Name: Jesse Goldman
 * Date: 2/14/2022
 * Course Number: CSC-212-D01
 * Course Name: Java 2
 * Problem Number: Monty Hall
 * Email: Jgoldman2001@student.stcc.edu
 * Short Description of the Problem: Three Door Game Driver
 */

import java.util.Scanner;

public class ThreeDoorDriver {
    private final static String TITLE = "CSC111 Project Template";
    private final static String CONTINUE_PROMPT = "Do this again? [y/N] ";

    //**********************************************
    // Put as many methods you need here

    //**********************************************
    // Start your logic coding in the process method
    private static void process(Scanner input, String args[]) throws Exception {
        System.out.println("Choose your door [1-3]");
        int selection = input.nextInt();

       /* System.out.println("Will you switch doors? [Y/N]");*/
        System.out.println("Will you switch doors? [0] NO [1] Yes");
        int switchDoors = input.nextInt();

        System.out.println("Enter number of simulations");
        int simulationCount = input.nextInt();

        double count = 0;
        double winCount = 0;

        while (count<simulationCount){
            // create ThreeDoorGame object, pass contestant door selection switch decision
            ThreeDoorGame game = new ThreeDoorGame(selection, switchDoors);

            //monty places a prize behind one of the three doors
            game.placePrize();

            //contestant selects a door
            game.pickContestantDoor(selection);

            //monty reveals a zonk door
            game.montyRevealZonk();

            //contestant decides whether to switch doors
            if(switchDoors == 1){
                game.switchDoor();
            }

            //check if contestant chose the prize door
            if(game.getContestantDoor() == game.getPrizeDoor()){
                winCount ++;
            }
            count++;
        }

        double winningPercentage = ((winCount/simulationCount)*100.0);
        System.out.println("Winning percentage = " + winningPercentage + "%");
        input.nextLine();
    }


    //**********************************************
    // Do not change the doThisAgain method
    private static boolean doThisAgain(Scanner input, String prompt) {
        System.out.print(prompt);
        String doOver = input.nextLine();
        return doOver.trim().equalsIgnoreCase("Y");
    }

    //**********************************************
    // Do not change the main method
    public static void main(String args[]) throws Exception {
        System.out.println("Welcome to " + TITLE);
        Scanner input = new Scanner(System.in);
        do {
            process(input, args);
        } while (doThisAgain(input, CONTINUE_PROMPT));
        input.close();
        System.out.println("Thank you for using " + TITLE);
    }

}