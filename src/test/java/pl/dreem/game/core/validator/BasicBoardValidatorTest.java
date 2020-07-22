package pl.dreem.game.core.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.dreem.game.core.board.Board;
import pl.dreem.game.domain.vo.BoardCoordinates;
import pl.dreem.game.domain.vo.MoveResult;
import pl.dreem.game.domain.vo.Point;
import pl.dreem.game.domain.vo.Symbol;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class BasicBoardValidatorTest {

    @DisplayName("verify_draw_success")
    @Test
    public void verifyPlayerStatusShouldReturnDrawStatus() {
        final BasicBoardValidator sut = new BasicBoardValidator();

        final Board testBoard = Board.createBoardFromPreparedData(new Symbol[3][3]);
        fillBoardWithSymbol(testBoard, Symbol.O);

        final Symbol testSymbol = Symbol.X;
        final BoardCoordinates testCoordinates = BoardCoordinates.from(Point.from(2, 2));

        final ValidatorResult actualResult = sut.verifyPlayerStatus(testBoard, testSymbol, testCoordinates);
        assertThat(actualResult, is(equalTo(ValidatorResult.DRAW)));
    }

    @DisplayName("verify_win_success")
    @Test
    public void verifyPlayerStatusShouldReturnWinStatus() {
        final BasicBoardValidator sut = new BasicBoardValidator();

        final Board testBoard = Board.createBoardFromPreparedData(new Symbol[3][3]);
        testBoard.makePlayerMove(Point.from(0, 0), Symbol.O);
        testBoard.makePlayerMove(Point.from(1, 1), Symbol.O);
        testBoard.makePlayerMove(Point.from(2, 2), Symbol.O);

        final Symbol testSymbol = Symbol.O;
        final BoardCoordinates testCoordinates = BoardCoordinates.from(Point.from(2, 2));

        final ValidatorResult actualResult = sut.verifyPlayerStatus(testBoard, testSymbol, testCoordinates);
        assertThat(actualResult, is(equalTo(ValidatorResult.WIN)));
    }

    @DisplayName("verify_success_success")
    @Test
    public void verifyPlayerStatusShouldReturnSuccessStatus() {
        final BasicBoardValidator sut = new BasicBoardValidator();

        final Board testBoard = Board.createBoardFromPreparedData(new Symbol[3][3]);
        testBoard.makePlayerMove(Point.from(0, 0), Symbol.O);

        final Symbol testSymbol = Symbol.X;
        final BoardCoordinates testCoordinates = BoardCoordinates.from(Point.from(1, 1));

        final ValidatorResult actualResult = sut.verifyPlayerStatus(testBoard, testSymbol, testCoordinates);
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