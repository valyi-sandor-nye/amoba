package services;

import model.*;
import view.ConsoleView;

public class PrintCommand extends Command {
    private final ConsoleView view;

    public PrintCommand(ConsoleView view) {
        this.view = view;
    }

    @Override
    public void execute(GameState state) {
        Table table = state.getTable();
        if (table == null) {
            view.showMessage("No board to display. Start a new game first.");
        } else {
            view.printBoard(table);
        }
    }
}
