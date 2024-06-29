import java.util.Scanner;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    // Constructor to initialize the game
    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }

    // Method to start the game
    public void start() {
        while (true) {
            board.print();
            System.out.println("Current Player: " + currentPlayer.getMarker());
            int row = getInput("row (0-2): ");
            int col = getInput("column (0-2): ");

            if (board.isCellEmpty(row, col)) {
                board.place(row, col, currentPlayer.getMarker());
                if (hasWinner()) {
                    board.print();
                    System.out.println("Player " + currentPlayer.getMarker() + " wins!");
                    break;
                }
                if (board.isFull()) {
                    board.print();
                    System.out.println("It's a draw!");
                    break;
                }
                switchCurrentPlayer();
            } else {
                System.out.println("Cell is not empty. Try again.");
            }
        }
    }

    // Method to switch the current player
    private void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    // Method to check if there's a winner
    private boolean hasWinner() {
        char marker = currentPlayer.getMarker();
        // Check rows, columns, and diagonals for a win
        return (checkRows(marker) || checkColumns(marker) || checkDiagonals(marker));
    }

    // Helper methods to check rows, columns, and diagonals for a win
    private boolean checkRows(char marker) {
        for (int i = 0; i < board.SIZE; i++) {
            if (board.cells[i][0] == marker && board.cells[i][1] == marker && board.cells[i][2] == marker) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns(char marker) {
        for (int i = 0; i < board.SIZE; i++) {
            if (board.cells[0][i] == marker && board.cells[1][i] == marker && board.cells[2][i] == marker) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals(char marker) {
        return ((board.cells[0][0] == marker && board.cells[1][1] == marker && board.cells[2][2] == marker) ||
                (board.cells[0][2] == marker && board.cells[1][1] == marker && board.cells[2][0] == marker));
    }

    // Method to get user input
    private int getInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        int input;
        do {
            System.out.print(prompt);
            input = scanner.nextInt();
        } while (input < 0 || input > 2);
        return input;
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.start();
    }
}
