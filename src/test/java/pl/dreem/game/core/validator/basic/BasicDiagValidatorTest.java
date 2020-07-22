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

public class BasicDiagValidatorTest {

    //  Case - WIN
    // 0 . .
    // . 0 .
    // . . 0

    @Test
    public void checkShouldFindWinPattern() {
        final BasicDiagValidator sut = new BasicDiagValidator();

        final Symbol testSymbol = Symbol.O;
        final BoardCoordinates testLastCoordinates = BoardCoordinates.from(Point.from(2, 2));

        final Board testBasicBoard = Board.createBasicBoard();

        final Point firstPoint = Point.from(0, 0);
        final Point secondPoint = Point.from(1, 1);
        final Point thirdPoint = Point.from(2, 2);

        testBasicBoard.makePlayerMove(firstPoint, testSymbol);
        testBasicBoard.makePlayerMove(secondPoint, testSymbol);
        testBasicBoard.makePlayerMove(thirdPoint, testSymbol);

        final ValidatorResult actualResult = sut.check(testSymbol, testLastCoordinates, testBasicBoard);

        assertThat(actualResult, is(equalTo(ValidatorResult.WIN)));
    }

    //  Case - WIN
    // 0 . .
    // . 0 .
    // . . 0

    @Test
    public void checkShouldFindWinPatternRev() {
        final BasicDiagValidator sut = new BasicDiagValidator();

        final Symbol testSymbol = Symbol.O;
        final BoardCoordinates testLastCoordinates = BoardCoordinates.from(Point.from(0, 0));

        final Board testBasicBoard = Board.createBasicBoard();

        final Point firstPoint = Point.from(2, 2);
        final Point secondPoint = Point.from(1, 1);
        final Point thirdPoint = Point.from(0, 0);

        testBasicBoard.makePlayerMove(firstPoint, testSymbol);
        testBasicBoard.makePlayerMove(secondPoint, testSymbol);
        testBasicBoard.makePlayerMove(thirdPoint, testSymbol);

        final ValidatorResult actualResult = sut.check(testSymbol, testLastCoordinates, testBasicBoard);

        assertThat(actualResult, is(equalTo(ValidatorResult.WIN)));
    }

    //  Case - fail (success)
    // . . 0
    // . 0 .
    // 0 . .

    @Test
    public void checkShouldFindSuccessPattern() {
        final BasicDiagValidator sut = new BasicDiagValidator();

        final Symbol testSymbol = Symbol.O;
        final BoardCoordinates testLastCoordinates = BoardCoordinates.from(Point.from(0, 2));

        final Board testBasicBoard = Board.createBasicBoard();

        final Point firstPoint = Point.from(2, 0);
        final Point secondPoint = Point.from(1, 1);
        final Point thirdPoint = Point.from(0, 2);

        testBasicBoard.makePlayerMove(firstPoint, testSymbol);
        testBasicBoard.makePlayerMove(secondPoint, testSymbol);
        testBasicBoard.makePlayerMove(thirdPoint, testSymbol);

        final ValidatorResult actualResult = sut.check(testSymbol, testLastCoordinates, testBasicBoard);

        assertThat(actualResult, is(equalTo(MoveResult.SUCCESS)));
    }

}
