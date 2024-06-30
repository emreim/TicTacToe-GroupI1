class TicTacToe {
    Player playerX;
    Player playerY;
    Player currentPlayer;
    Board board;

    public TicTacToe() {
        playerX = new Player('X');
        playerY = new Player('O');
        currentPlayer = playerX;
        board = new Board();
    }

    public void start() {
        board.clear();
        currentPlayer = playerX;
    }

    public void switchCurrentPlayer() {
        if (currentPlayer == playerX) {
            currentPlayer = playerY;
        } else {
            currentPlayer = playerX;
        }
    }

    public Board getBoard() {
        return board;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

}
