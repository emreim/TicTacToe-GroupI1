import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TicTacToe myGame = new TicTacToe();
        myGame.board.clear();
        Scanner scanner = new Scanner(System.in);

        while (!myGame.board.hasWinner() && !myGame.board.isFull()) {
            myGame.board.print();
            System.out.println("Current Player: " + myGame.currentPlayer.getMarker());

            int x = -1, y = -1;
            boolean validInput = false;
            while (!validInput) {
                try {
                    // Eingabe für Zeile (x)
                    System.out.print("row (0-2): ");
                    x = Integer.parseInt(scanner.nextLine());
                    if (x < 0 || x > 2) {
                        System.out.println("Invalid input. Please enter numbers between 0 and 2.");
                        continue;
                    }

                    // Eingabe für Spalte (y)
                    boolean validCol = false;
                    while (!validCol) {
                        try {
                            System.out.print("column (0-2): ");
                            y = Integer.parseInt(scanner.nextLine());
                            if (y >= 0 && y <= 2) {
                                if (myGame.board.isCellEmpty(x, y)) {
                                    validCol = true;
                                    validInput = true;
                                } else {
                                    System.out.println("Cell is not empty. Please try again.");
                                }
                            } else {
                                System.out.println("Invalid input. Please enter numbers between 0 and 2.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter numbers between 0 and 2.");
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter numbers between 0 and 2.");
                }
            }

            myGame.board.place(x, y, myGame.currentPlayer.getMarker());
            if (!myGame.board.hasWinner() && !myGame.board.isFull()) {
                myGame.switchCurrentPlayer();
            }
        }

        myGame.board.print();
        if (myGame.board.hasWinner()) {
            myGame.switchCurrentPlayer(); // Switch back to the winning player
            System.out.println("Player " + myGame.currentPlayer.getMarker() + " wins!");
        } else {
            System.out.println("The game is a draw.");
        }

        scanner.close();
    }
}