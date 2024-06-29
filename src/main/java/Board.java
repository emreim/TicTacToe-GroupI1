

public class Board {
    final int SIZE = 3;
    final char[][] cells;

    public Board() {
        cells = new char[SIZE][SIZE];
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
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (cells[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public void clear() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = ' ';
            }

        }
    }

    public void print() {
        System.out.println("_______");
        for (int i = 0; i < SIZE; i++) {
            System.out.print("|");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(cells[i][j]);
                if (j < SIZE - 1)
                    System.out.print("|");
            }
            System.out.println("|");
        }
        System.out.println("-------");
    }
}
