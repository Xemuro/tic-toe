package pl.dreem.game.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.dreem.game.core.board.Board;
import pl.dreem.game.domain.exception.InvalidPlayerSymbolException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BoardTest {

    @DisplayName("create_basicBoard_filled")
    @Test
    public void basicBoardShouldBeCreatedAndFilled() {
        final Board sut = Board.createBasicBoard();
        final Symbol[][] board = sut.getBoard();

        for (Symbol[] row : board) {
            for (Symbol column : row) {
                assertThat(column, is(equalTo(Symbol.DOT)));
            }
        }
    }

    @DisplayName("playerMove_valid_increment")
    @Test
    public void makePlayerMoveShouldIncrementWhenPlayerMakeMove() {
        final Board sut = Board.createBasicBoard();

        final Point firstTestPoint = Point.from(1, 1);
        final Point secondTestPoint = Point.from(2, 2);

        sut.makePlayerMove(firstTestPoint, Symbol.O);
        sut.makePlayerMove(secondTestPoint, Symbol.X);

        final int actualMovements = sut.getMovements();

        assertThat(actualMovements, is(equalTo(2)));
    }

    @DisplayName("playerMove_invalidSymbol_exception")
    @Test
    public void makePlayerMoveShouldShouldForWrongSymbolThrowException() {
        final Board sut = Board.createBasicBoard();

        final Point firstTestPoint = Point.from(1, 1);

        assertThrows(InvalidPlayerSymbolException.class, () -> sut.makePlayerMove(firstTestPoint, Symbol.DOT));
    }

    @DisplayName("getBoardProperties_basicParams_positive")
    @Test
    public void getBoardPropertiesShouldReturnProperties() {
        final Board sut = Board.createBasicBoard();
        final BoardProperties actualResult = sut.getBoardProperties();

        assertNotNull(actualResult);
        assertThat(actualResult.getColumns(), is(equalTo(3)));
        assertThat(actualResult.getRows(), is(equalTo(3)));
    }

    @DisplayName("getSymbol_basicPoint_positive")
    @Test
    public void getSymbolShouldReturnSymbol() {
        final Point testPoint = Point.from(1, 1);

        final Board sut = Board.createBasicBoard();
        final Symbol actualSymbol = sut.getSymbol(testPoint);

        assertThat(actualSymbol, is(equalTo(Symbol.DOT)));
    }

    @DisplayName("getSymbol_afterPlayerMove_positive")
    @Test
    public void getSymbolShouldReturnPlayerSymbol() {
        final Point testPoint = Point.from(1, 1);
        final Symbol expectedSymbol = Symbol.O;

        final Board sut = Board.createBasicBoard();
        sut.makePlayerMove(testPoint, expectedSymbol);
        final Symbol actualSymbol = sut.getSymbol(testPoint);

        assertThat(actualSymbol, is(equalTo(expectedSymbol)));
    }
}