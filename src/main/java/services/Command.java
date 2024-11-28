package services;

import model.GameState;

public abstract class Command {
    public abstract void execute(GameState state);
}
