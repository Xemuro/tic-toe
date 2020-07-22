package pl.dreem.game.ui;

import pl.dreem.game.domain.exception.InvalidInputException;
import pl.dreem.game.domain.vo.*;
import pl.dreem.game.ui.util.CommandLineInteraction;

import java.io.IOException;

import static java.lang.System.out;

public class ConsoleUI implements GameUI {

    private String[][] uiBoardState;

    @Override
    public void initNewGame() {
        uiBoardState = new String[4][4];
        uiBoardState[0][1] = "A";
        uiBoardState[0][2] = "B";
        uiBoardState[0][3] = "C";
        uiBoardState[0][0] = " ";
        uiBoardState[1][0] = "1";
        uiBoardState[2][0] = "2";
        uiBoardState[3][0] = "3";
        drawBoard();
    }

    @Override
    public void makeMove(final Player symbol, final BoardCoordinates position) {
        uiBoardState[position.getRow() + 1][position.getColumn() + 1] = symbol.getSymbol().name();
        drawBoard();
    }

    private void drawBoard() {
        try {
            clearConsole();
        } catch (IOException e) {
            out.println("Problem with clean console.");
        }

        for (int i = 0; i < uiBoardState.length; i++) {
            for (int j = 0; j < uiBoardState[0].length; j++) {
                final String value = uiBoardState[i][j];
                final String toDisplay = value != null ? value : Symbol.DOT.getConsoleRepresentation();
                out.print(toDisplay + " ");
            }
            out.println(" ");
        }
    }

    private void clearConsole() throws IOException {
        final String operatingSystem = System.getProperty("os.name");
        if (operatingSystem.contains("Windows")) {
            Runtime.getRuntime().exec("cls");
        } else {
            Runtime.getRuntime().exec("clear");
        }
    }

    @Override
    public Coordinates readNextMove() {
        try {
            out.println("\nEnter coordinates from the range: 1 - 3, A - C\n");
            return Coordinates.fromKeyBoardInput(CommandLineInteraction.readLineFromUI());
        } catch (InvalidInputException e) {
            out.println("\nInvalid input - coordinate example: A1, c2, B3, 1B, 2C, 1a\n");
            return readNextMove();
        }
    }

    @Override
    public void displayResult(final Player player, final MoveResult result) {
        if (result.equals(MoveResult.FAIL)) {
            out.println("\nInvalid coordinates - out of board range! 1 - 3, A - C, or already selected coordinate.\n");
        } else if (result.equals(MoveResult.WIN)) {
            out.println("\nPlayer: " + player + " won!");
        } else if (result.equals(MoveResult.DRAW)) {
            out.println("\nDraw!");
        }
    }
}