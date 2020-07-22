package pl.dreem.game.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.dreem.game.core.board.Board;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class BoardPropertiesTest {

    @DisplayName("maxMovements_basicParam_positive")
    @Test
    public void createNewOneShouldBeCreatedWithValidMaxMovements() {
        final BoardProperties boardProperties = getTestBoardPropertiesFromBasicData();

        final int actualMaxMovements = boardProperties.getMaxMovements();

        assertThat(actualMaxMovements, is(equalTo(9)));
    }

    @DisplayName("minMovements_basicParam_positive")
    @Test
    public void createNewOneShouldBeCreatedWithValidMinMovements() {
        final BoardProperties boardProperties = getTestBoardPropertiesFromBasicData();

        final int actualMinMovements = boardProperties.getMinimumMoves();

        assertThat(actualMinMovements, is(equalTo(3)));
    }

    @DisplayName("columns_basicParam_positive")
    @Test
    public void createNewOneShouldBeCreatedWithValidColumns() {
        final BoardProperties boardProperties = getTestBoardPropertiesFromBasicData();

        final int actualColumns = boardProperties.getColumns();

        assertThat(actualColumns, is(equalTo(3)));
    }

    @DisplayName("rows_basicParam_positive")
    @Test
    public void createNewOneShouldBeCreatedWithValidRows() {
        final BoardProperties boardProperties = getTestBoardPropertiesFromBasicData();

        final int actualRows = boardProperties.getRows();

        assertThat(actualRows, is(equalTo(3)));
    }

    private BoardProperties getTestBoardPropertiesFromBasicData() {
        final Board basicBoard = Board.createBasicBoard();
        return basicBoard.getBoardProperties();
    }

}
