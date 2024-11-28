import model.*;
import services.*;
import view.*;

public class GoMoku {
    public static void main(String[] args) {
        ConsoleView view = new ConsoleView();
        GameState state = new GameState();

        boolean running = true;
        while (running) {
            view.showMenu(state);
            String input = view.getUserInput();

            try {
                String[] tokens = input.split(" ");
                String command = tokens[0].toUpperCase();

                switch (command) {
                    case "NEW":
                        int size = Integer.parseInt(tokens[1]);
                        if (size < 5 || size > 25) throw new IllegalArgumentException("Invalid board size");
                        new NewGameCommand(size).execute(state);
                        view.printBoard(state.getTable());
                        break;

                    case "PRINT":
                        new PrintCommand(view).execute(state);
                        break;

                    case "PUT":
                        if (!state.isGameInProgress()) throw new IllegalStateException("No game in progress");
                        int row = Integer.parseInt(tokens[1]);
                        int col = Integer.parseInt(tokens[2]);
                        if (GameLogic.isValidMove(state, row, col)) {
                            GameLogic.applyMove(state, row, col, state.getWhoIsOnMove());
                            view.printBoard(state.getTable());
                        } else {
                            view.showError("Invalid move!");
                        }
                        break;

                    case "EXIT":
                        running = false;
                        break;

                    default:
                        view.showError("Unknown command!");
                        break;
                }
            } catch (Exception e) {
                view.showError(e.getMessage());
            }
        }

        System.out.println("Game exited.");
    }
}
