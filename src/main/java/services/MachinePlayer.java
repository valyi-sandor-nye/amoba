package services;

import model.GameState;
import model.Position;
import model.Table;

import java.util.Random;

public class MachinePlayer {
    public static Position getRandomMove(GameState state) {
        Random random = new Random();
        Table table = state.getTable();
        int size = table.getSize();
        Position move;

        do {
            int row = random.nextInt(size);
            int col = random.nextInt(size);
            move = new Position(row, col);
        } while (!GameLogic.isValidMove(state, move.row, move.col));

        return move;
    }
}

