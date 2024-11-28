package model;

public
class GameState {
    private Table table;
    private Sign whoIsOnMove;
    private boolean gameInProgress;

    public GameState() {
        this.gameInProgress = false;
        this.whoIsOnMove = Sign.X; // Human starts by default
    }

    public void startNewGame(int size) {
        this.table = new Table(size);
        this.gameInProgress = true;
        this.whoIsOnMove = Sign.X; // Reset turn
    }

    public Table getTable() {
        return table;
    }

    public boolean isGameInProgress() {
        return gameInProgress;
    }

    public Sign getWhoIsOnMove() {
        return whoIsOnMove;
    }

    public void toggleTurn() {
        whoIsOnMove = (whoIsOnMove == Sign.X) ? Sign.O : Sign.X;
    }

    public void endGame() {
        this.gameInProgress = false;
    }
}

