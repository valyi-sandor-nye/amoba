package model;

public class Table {
    final private Sign[][] board;

    public Table(int size) {
        board = new Sign[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = Sign.EMPTY;
            }
        }
    }

    public int getSize() {
        return board.length;
    }

    public Sign getSign(int row, int col) {
        return board[row][col];
    }

    public void setSign(int row, int col, Sign sign) {
        board[row][col] = sign;
    }

    public boolean isValidPosition(int row, int col) {
        int size = board.length;
        return row >= 0 && col >= 0 && row < size && col < size;
    }
}
