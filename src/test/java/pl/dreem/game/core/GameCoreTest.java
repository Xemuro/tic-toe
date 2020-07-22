package pl.dreem.game.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.dreem.game.domain.exception.GameAlreadyInProgressException;
import pl.dreem.game.domain.exception.GameNotReadyToStartException;
import pl.dreem.game.mock.BoardCoreFailMock;
import pl.dreem.game.mock.BoardCoreSuccessMock;
import pl.dreem.game.mock.BoardCoreWinMock;
import pl.dreem.game.mock.GameUIMock;

import java.time.Duration;

import static org.awaitility.Awaitility.await;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameCoreTest {

    @DisplayName("generate_basic_positive")
    @Test
    public void initBasicGameShouldCreateBasicGame() {
        final GameCore actualResult = GameCore.initBasicGame();
        assertNotNull(actualResult);
    }

    @DisplayName("initGame_notNeedInit_positive")
    @Test
    public void initGameShouldNotThrowException() {
        final GameCore actualResult = GameCore.initBasicGame();
        actualResult.initGame();

        assertThat(actualResult.isGameNeedInitialising(), is(false));
    }

    @DisplayName("initGame_canBeStarted_positive")
    @Test
    public void initGameShouldCanBeStarted() {
        final GameCore actualResult = GameCore.initBasicGame();
        actualResult.initGame();

        assertThat(actualResult.isGameStarted(), is(false));
    }

    @DisplayName("startGame_basic_positive")
    @Test
    public void startGameShouldNotThrowException() {
        final GameCore actualResult = GameCore.initBasicGame();
        actualResult.initGame();
        actualResult.startGame();

        assertThat(actualResult.isGameStarted(), is(true));
    }

    @DisplayName("startGame_withoutInit_failure")
    @Test
    public void startGameWithoutInitShouldThrowException() {
        final GameCore actualResult = GameCore.initBasicGame();

        assertThrows(GameNotReadyToStartException.class, actualResult::startGame);
    }

    @DisplayName("startGame_doubleStart_failure")
    @Test
    public void doubleStartGameShouldThrowException() {
        final GameCore actualResult = GameCore.initBasicGame();
        actualResult.initGame();
        actualResult.startGame();

        assertThrows(GameAlreadyInProgressException.class, actualResult::startGame);
    }

    @DisplayName("nextMove_success_positive")
    @Test
    public void startGameShouldReadUserInputAndNotThrowExceptionForSuccessAction() {
        final GameUIMock gameUIMock = new GameUIMock();
        final GameCore actualResult = GameCore.initBasicWithCustomBoards(gameUIMock, new BoardCoreSuccessMock());
        actualResult.initGame();
        actualResult.startGame();

        await().atMost(Duration.ofSeconds(5))
               .until(gameUIMock::getMakeMoveHandler, not(hasSize(0)));
        assertThat(actualResult.isGameStarted(), is(true));
    }

    @DisplayName("nextMove_fail_positive")
    @Test
    public void startGameShouldReadUserInputAndNotThrowExceptionForFailAction() {
        final GameUIMock gameUIMock = new GameUIMock();
        final GameCore actualResult = GameCore.initBasicWithCustomBoards(gameUIMock, new BoardCoreFailMock());
        actualResult.initGame();
        actualResult.startGame();

        await().atMost(Duration.ofSeconds(5))
               .until(gameUIMock::getMakeMoveHandler, hasSize(0));
        assertThat(actualResult.isGameStarted(), is(true));
    }

    @DisplayName("nextMove_win_positive")
    @Test
    public void startGameShouldReadUserInputAndNotThrowExceptionForWinAction() {
        final GameUIMock gameUIMock = new GameUIMock();
        final GameCore actualResult = GameCore.initBasicWithCustomBoards(gameUIMock, new BoardCoreWinMock());
        actualResult.initGame();
        actualResult.startGame();

        await().atMost(Duration.ofSeconds(5))
               .until(gameUIMock::getMakeMoveHandler, hasSize(1));
        assertThat(actualResult.isGameStarted(), is(false));
    }

    @DisplayName("nextMove_draw_positive")
    @Test
    public void startGameShouldReadUserInputAndNotThrowExceptionForDrawAction() {
        final GameUIMock gameUIMock = new GameUIMock();
        final GameCore actualResult = GameCore.initBasicWithCustomBoards(gameUIMock, new BoardCoreWinMock());
        actualResult.initGame();
        actualResult.startGame();

        await().atMost(Duration.ofSeconds(5))
               .until(gameUIMock::getMakeMoveHandler, hasSize(1));
        assertThat(actualResult.isGameStarted(), is(false));
    }
}