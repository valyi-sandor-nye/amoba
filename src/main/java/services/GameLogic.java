package services;

import model.GameState;
import model.Sign;
import model.Table;

public class GameLogic {
    public static boolean isValidMove(GameState state, int row, int col) {
        Table table = state.getTable();
        return table.isValidPosition(row, col) && table.getSign(row, col) == Sign.EMPTY;
    }

    public static void applyMove(GameState state, int row, int col, Sign sign) {
        state.getTable().setSign(row, col, sign);
        state.toggleTurn();
    }
}

