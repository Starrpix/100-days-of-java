import java.util.*;

class Board {
    int count = 0;
    String board[] = {" ", " ", " ", " ", " ", " ", " ", " ", " "};

    void printBoard() {
        System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("-----------");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("-----------");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8]);
    }

    boolean updateBoard(int position, String type) {
        if (board[position - 1].equals(" ")) {
            board[position - 1] = type;
            count++;
            return true;
        } else {
            System.out.println("Position already selected. Select another position");
            return false;
        }
    }

    boolean checkDraw() {
        return count == 9;
    }

    boolean checkWinner(String type) {
        return (board[0].equals(type) && board[1].equals(type) && board[2].equals(type)) ||
               (board[3].equals(type) && board[4].equals(type) && board[5].equals(type)) ||
               (board[6].equals(type) && board[7].equals(type) && board[8].equals(type)) ||
               (board[0].equals(type) && board[3].equals(type) && board[6].equals(type)) ||
               (board[1].equals(type) && board[4].equals(type) && board[7].equals(type)) ||
               (board[2].equals(type) && board[5].equals(type) && board[8].equals(type)) ||
               (board[0].equals(type) && board[4].equals(type) && board[8].equals(type)) ||
               (board[2].equals(type) && board[4].equals(type) && board[6].equals(type));
    }
}

class Player {
    String name;
    String type;

    Player(String type, Scanner input) {
        this.type = type;
        if (type.equals("X")) {
            System.out.print("Player selecting X, enter your name: ");
        } else {
            System.out.print("Player selecting 0, enter your name: ");
        }
        name = input.nextLine();
    }
}

class Game {
    Scanner input = new Scanner(System.in);
    Board board = new Board();
    Player p1 = new Player("X", input);
    Player p2 = new Player("0", input);
    Player currentPlayer = p1;

    void play() {
        String msg = "Enter the position (1 - 9):";
        while (true) {
            System.out.println(currentPlayer.name + " " + msg);
            int position = input.nextInt();

            if (position < 1 || position > 9) {
                System.out.println("Invalid position. Choose a number between 1 and 9.");
                continue;
            }

            if (board.updateBoard(position, currentPlayer.type)) {
                board.printBoard();

                if (board.checkWinner(currentPlayer.type)) {
                    System.out.println(currentPlayer.name + " wins!");
                    break;
                } else if (board.checkDraw()) {
                    System.out.println("Game is a draw!");
                    break;
                } else {
                    currentPlayer = (currentPlayer == p1) ? p2 : p1;
                }
            }
        }
        input.close(); 
    }
}

class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
