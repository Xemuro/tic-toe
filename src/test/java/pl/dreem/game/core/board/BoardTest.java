package pl.dreem.game.core.board;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.dreem.game.domain.vo.BoardProperties;
import pl.dreem.game.domain.vo.Point;
import pl.dreem.game.domain.vo.Symbol;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class BoardTest {

    @DisplayName("createBasicBoard_basicInit_success")
    @Test
    public void createBasicBoardShouldCreateBasicBoard() {
        final Board actualResult = Board.createBasicBoard();
        assertThat(actualResult.getBoard().length, is(equalTo(3)));
        assertThat(actualResult.getBoard()[0].length, is(equalTo(3)));
    }

    @DisplayName("movements_afterBasicInit_0")
    @Test
    public void getMovementsShouldCreateBasicBoardWith0Movements() {
        final Board sut = Board.createBasicBoard();
        final int actualResult = sut.getMovements();
        assertThat(actualResult, is(equalTo(0)));
    }

    @DisplayName("getSymbol_basicInit_dot")
    @Test
    public void getSymbolWithValidPointShouldForBasicBoardReturnDotPoint() {
        final Board sut = Board.createBasicBoard();
        final Symbol firstActualSymbol = sut.getSymbol(Point.from(0, 0));
        final Symbol secondActualSymbol = sut.getSymbol(Point.from(2, 2));
        assertThat(firstActualSymbol, is(equalTo(Symbol.DOT)));
        assertThat(secondActualSymbol, is(equalTo(Symbol.DOT)));
    }

    @DisplayName("getBoardProperties_basicInit_validProperties")
    @Test
    public void getBoardPropertiesShouldReturnValidPropertiesForWrapper() {
        final Board sut = Board.createBasicBoard();
        final BoardProperties actualProperties = sut.getBoardProperties();
        assertThat(actualProperties.getRows(), is(equalTo(3)));
        assertThat(actualProperties.getColumns(), is(equalTo(3)));
        assertThat(actualProperties.getMinimumMoves(), is(equalTo(5)));
        assertThat(actualProperties.getMaxMovements(), is(equalTo(9)));
    }
}
