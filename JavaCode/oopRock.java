import java.util.*;

class Game{
    String userPick;
    String computerPick;
    String result;

    String getComputerPick(){
        int randomNumber = (int) (Math.random() * 3) + 1;
        
        if(randomNumber == 1){
            computerPick = "rock";
        }else if (randomNumber == 2){
            computerPick = "paper";
        }else{
            computerPick = "scissors";
        }
        return computerPick;
    }

    String getUserPick(){
        Scanner key = new Scanner(System.in);

        while(true){
        System.out.println("Enter rock, paper or scissors:");
        userPick = key.nextLine();
        if(userPick.equals("rock") || userPick.equals("paper") || userPick.equals("scissors")){
        break;
        }
        }
        return userPick;
    }

    String getResult(String userPick, String computerPick){
         if (userPick.equals(computerPick)) {
            return "drawed.";
        }

        else if (userPick.equals("paper") && computerPick.equals("rock")) {
            return "won.";
        }

        else if (userPick.equals("rock") && computerPick.equals("scissors")) {
            return "won.";
        }

        else if (userPick.equals("scissors") && computerPick.equals("paper")) {
            return "won.";
        }

        else {
            return "lost.";
        }
    }
}

class Main {

    public static void main(String[] args){

        while(true){
        Game game = new Game();
        String userPick = game.getUserPick();
        String computerPick = game.getComputerPick();
        String result = game.getResult(userPick,computerPick);

        System.out.println("User choosed: "+userPick);
        System.out.println("Computer choosed: "+computerPick);
        System.out.println("You have "+result);

        Scanner input = new Scanner(System.in);

        System.out.println("Do you want to play again? (y/n): ");

        String playAgain = input.nextLine();
        

        if(!(playAgain.equals("y"))){
            break;
        }

        }

        }
    }


