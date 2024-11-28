package services;

import model.GameState;

// Sample Command Implementation
public class NewGameCommand extends Command {
    private final int size;

    public NewGameCommand(int size) {
        this.size = size;
    }

    @Override
    public void execute(GameState state) {
        state.startNewGame(size);
        System.out.println("New game started with board size " + size);
    }
}
