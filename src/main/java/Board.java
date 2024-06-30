class Board {
    private char[][] cells;

    public Board() {
        cells = new char[3][3];
        clear();
    }

    public boolean isCellEmpty(int x, int y) {
        return cells[x][y] == ' ';
    }

    public void place(int x, int y, char marker) {
        if (isCellEmpty(x, y)) {
            cells[x][y] = marker;
        }
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public void clear() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = ' ';
            }
        }
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        System.out.println("_______");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < cells[i].length; j++) {
                System.out.print(cells[i][j]);
                if (j < cells[i].length - 1)
                    System.out.print("|");
            }
            System.out.println("|");
        }
        System.out.println("-------");
        return sb.toString();
    }

    public boolean hasWinner() {
        for (int i = 0; i < 3; i++) {
            if (cells[i][0] == cells[i][1] && cells[i][1] == cells[i][2] && cells[i][0] != ' ') {
                return true;
            }
            if (cells[0][i] == cells[1][i] && cells[1][i] == cells[2][i] && cells[0][i] != ' ') {
                return true;
            }
        }

        if (cells[0][0] == cells[1][1] && cells[1][1] == cells[2][2] && cells[0][0] != ' ') {
            return true;
        }
        if (cells[0][2] == cells[1][1] && cells[1][1] == cells[2][0] && cells[0][2] != ' ') {
            return true;
        }

        return false;
    }

    public char[][] getCells() {
        return cells;
    }
}