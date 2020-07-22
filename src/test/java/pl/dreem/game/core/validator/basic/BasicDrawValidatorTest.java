package pl.dreem.game.core.validator.basic;

import org.junit.jupiter.api.Test;
import pl.dreem.game.core.board.Board;
import pl.dreem.game.core.validator.ValidatorResult;
import pl.dreem.game.domain.vo.BoardCoordinates;
import pl.dreem.game.domain.vo.MoveResult;
import pl.dreem.game.domain.vo.Point;
import pl.dreem.game.domain.vo.Symbol;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class BasicDrawValidatorTest {

    @Test
    public void checkShouldReturnDraw() {
        final BasicDrawValidator sut = new BasicDrawValidator();

        final Point testLastPoint = Point.from(0, 0);

        final Symbol testSymbol = Symbol.O;
        final BoardCoordinates testLastCoordinates = BoardCoordinates.from(testLastPoint);

        final Board testBasicBoard = Board.createBasicBoard();
        fillBoardWithSymbol(testBasicBoard, testSymbol);

        final ValidatorResult actualResult = sut.check(testSymbol, testLastCoordinates, testBasicBoard);

        assertThat(actualResult, is(equalTo(ValidatorResult.DRAW)));
    }

    @Test
    public void checkShouldReturnSuccess() {
        final BasicDrawValidator sut = new BasicDrawValidator();

        final Point testLastPoint = Point.from(0, 0);

        final Symbol testSymbol = Symbol.O;
        final BoardCoordinates testLastCoordinates = BoardCoordinates.from(testLastPoint);

        final Board testBasicBoard = Board.createBasicBoard();

        final ValidatorResult actualResult = sut.check(testSymbol, testLastCoordinates, testBasicBoard);

        assertThat(actualResult, is(equalTo(ValidatorResult.NONE)));
    }

    private void fillBoardWithSymbol(final Board boardWrapper, final Symbol symbol) {
        final Symbol[][] board = boardWrapper.getBoard();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boardWrapper.makePlayerMove(Point.from(i, j), symbol);
            }
        }
    }

}
