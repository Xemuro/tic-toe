package pl.dreem.game.core.board;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.dreem.game.domain.vo.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BasicBoardCoreTest {

    @DisplayName("initBasic_basic_positive")
    @Test
    public void initNewBasicBoardShouldGenerateBasicBoard() {
        final BasicBoardCore actualResult = BasicBoardCore.initNewBasicBoard(Setup.BASIC);
        assertNotNull(actualResult);
    }

    @DisplayName("actualPlayer_basicInit_firstPlayer")
    @Test
    public void getActualPlayerShouldForBasicBoardReturnFirstPlayer() {
        final BasicBoardCore sut = BasicBoardCore.initNewBasicBoard(Setup.BASIC);
        final Player actualResult = sut.getActualPlayer();

        assertThat(actualResult, is(equalTo(Player.FIRST)));
    }

    @DisplayName("lastPlayer_basicInit_secondPlayer")
    @Test
    public void getLastPlayerShouldForBasicBoardReturnSecondPlayer() {
        final BasicBoardCore sut = BasicBoardCore.initNewBasicBoard(Setup.BASIC);
        final Player actualResult = sut.getLastPlayer();

        assertThat(actualResult, is(equalTo(Player.SECOND)));
    }

    @DisplayName("nextMove_basicInit_validPoint_success")
    @Test
    public void nextMoveShouldForBasicBoardAndValidPointReturnSuccess() {
        final BasicBoardCore sut = BasicBoardCore.initNewBasicBoard(Setup.BASIC);

        final BoardCoordinates testData = BoardCoordinates.from(Point.from(1, 1));
        final MoveResult actualResult = sut.nextMove(testData);

        assertThat(actualResult, is(equalTo(MoveResult.SUCCESS)));
    }

    @DisplayName("nextMove_basicInit_MarkPoint_fail")
    @Test
    public void nextMoveShouldForBasicBoardAndAlreadyMarkPointReturnFail() {
        final BasicBoardCore sut = BasicBoardCore.initNewBasicBoard(Setup.BASIC);

        sut.nextMove(BoardCoordinates.from(Point.from(1, 1)));
        final MoveResult actualResult = sut.nextMove(BoardCoordinates.from(Point.from(1, 1)));

        assertThat(actualResult, is(equalTo(MoveResult.FAIL)));
    }

    @DisplayName("nextMove_playersSwitch_firstPlayer")
    @Test
    public void nextMoveShouldSwitchPlayers() {
        final BasicBoardCore sut = BasicBoardCore.initNewBasicBoard(Setup.BASIC);
        sut.nextMove(BoardCoordinates.from(Point.from(1, 1)));
        sut.nextMove(BoardCoordinates.from(Point.from(2, 2)));
        final Player actualResult = sut.getActualPlayer();

        assertThat(actualResult, is(equalTo(Player.FIRST)));
    }

    @DisplayName("nextMove_basicInit_InvalidPoint_fail")
    @Test
    public void nextMoveShouldForBasicBoardAndInvalidPointReturnFail() {
        final BasicBoardCore sut = BasicBoardCore.initNewBasicBoard(Setup.BASIC);

        final BoardCoordinates pointOfOutBound = BoardCoordinates.from(Point.from(10, 10));
        final MoveResult actualResult = sut.nextMove(pointOfOutBound);

        assertThat(actualResult, is(equalTo(MoveResult.FAIL)));
    }

}