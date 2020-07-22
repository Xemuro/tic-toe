package pl.dreem.game.core.board;

import pl.dreem.game.domain.exception.InvalidPlayerSymbolException;
import pl.dreem.game.domain.vo.BoardProperties;
import pl.dreem.game.domain.vo.Point;
import pl.dreem.game.domain.vo.Symbol;

import java.util.Arrays;
import java.util.Objects;

public final class Board {

    private final Symbol[][] board;
    private int movements;

    private Board(final Symbol[][] board) {
        this.board = Objects.requireNonNull(board);
        this.movements = 0;
        fillBoard(board);
    }

    public Symbol getSymbol(final Point point) {
        return board[point.getRow()][point.getColumn()];
    }

    public void makePlayerMove(final Point point, final Symbol symbol) {
        if (symbol == Symbol.DOT) {
            throw new InvalidPlayerSymbolException();
        }

        board[point.getRow()][point.getColumn()] = symbol;
        movements++;
    }

    public int getMovements() {
        return movements;
    }

    public Symbol[][] getBoard() {
        return board;
    }

    public static Board createBasicBoard() {
        final Symbol[][] board = new Symbol[3][3];
        return new Board(board);
    }

    public static Board createBoardFromPreparedData(final Symbol[][] board){
        return new Board(board);
    }

    public BoardProperties getBoardProperties() {
        return BoardProperties.create(board.length, board[0].length);
    }

    private static void fillBoard(Symbol[][] board) {
        for (Symbol[] row : board) {
            Arrays.fill(row, Symbol.DOT);
        }
    }
}