package view;

import model.*;

import java.util.Scanner;

public class ConsoleView {
    private final Scanner scanner = new Scanner(System.in);

    public void showMenu(GameState state) {
        System.out.println("\n--- MENU ---");
        System.out.println("1. NEW <n> - Start a new game with board size n (5-25)");
        if (state.isGameInProgress()) {
            System.out.println("2. PUT <row> <col> <value> - Make a move");
            System.out.println("3. SAVE - Save the current game");
            System.out.println("4. WITHDRAW - Withdraw last move");
            System.out.println("5. GIVEUP - Give up the game");
        }
        System.out.println("6. LOAD - Load a saved game");
        System.out.println("7. EXIT - Exit the program");
    }

    public String getUserInput() {
        System.out.print("Enter command: ");
        return scanner.nextLine();
    }

    public void printBoard(Table table) {
        if (table == null) {
            System.out.println("No board to display.");
            return;
        }

        int size = table.getSize();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Sign sign = table.getSign(i, j);
                // Print a dot for empty positions
                System.out.print(sign == Sign.EMPTY ? "." : sign.name());
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void showError(String message) {
        System.out.println("Error: " + message);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}

