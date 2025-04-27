// I will try to use methods to make the code more readable and maintainable.
package JavaCode;

import java.util.Scanner;

public class Rock{
    public static void main(String[] args){
        String userchoicesymb = "";
        String compchoicesymb = "";
        int userpoints = 0;
        int comppoints = 0;

        Scanner keyboard = new Scanner(System.in);
        System.out.println("You are entering a | Rock vs Paper vs Scissors | game.");
        System.out.println("#Rules");
        System.out.println("For playing as Rock | Enter value between 0.0 to 0.3");
        System.out.println("For playing as Paper | Enter value between 0.4 to 0.7");
        System.out.println("For playing as Scissors  | Enter value between 0.8 to 1.0");
        System.out.println("----------------Round 1-------------");
        System.out.println("Enter your choice: Rock or Paper or Scissors");

        double userchoicein = keyboard.nextDouble();
        double compchoicein = Math.random();

        if (userchoicein >= 0.0 && userchoicein <= 0.3) {
            userchoicesymb = "Rock";
        } else if (userchoicein >= 0.4 && userchoicein <= 0.7) {
            userchoicesymb = "Paper";
        } else {
            userchoicesymb = "Scissors";
        }

        if (compchoicein >= 0.0 && compchoicein <= 0.3) {
            compchoicesymb = "Rock";
        } else if (compchoicein >= 0.4 && compchoicein <= 0.7) {
            compchoicesymb = "Paper";
        } else {
            compchoicesymb = "Scissors";
        }

        if (userchoicesymb.equals("Rock") && compchoicesymb.equals("Scissors")) {
            userpoints += 1;
        } else if (userchoicesymb.equals("Rock") && compchoicesymb.equals("Paper")) {
            comppoints += 1;
        } else if (userchoicesymb.equals("Rock") && compchoicesymb.equals("Rock")) {
            userpoints += 1;
            comppoints += 1;
        } else if (userchoicesymb.equals("Paper") && compchoicesymb.equals("Rock")) {
            userpoints += 1;
        } else if (userchoicesymb.equals("Paper") && compchoicesymb.equals("Paper")) {
            userpoints += 1;
            comppoints += 1;
        } else if (userchoicesymb.equals("Paper") && compchoicesymb.equals("Scissors")) {
            comppoints += 1;
        } else if (userchoicesymb.equals("Scissors") && compchoicesymb.equals("Paper")) {
            userpoints += 1;
        } else if (userchoicesymb.equals("Scissors") && compchoicesymb.equals("Rock")) {
            comppoints += 1;
        } else if (userchoicesymb.equals("Scissors") && compchoicesymb.equals("Scissors")) {
            userpoints += 1;
            comppoints += 1;
        }

        System.out.println("Results:");
        System.out.println("User: " + userpoints);
        System.out.println("Computer: " + comppoints);

        keyboard.close();
    }
}
