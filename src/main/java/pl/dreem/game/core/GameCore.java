package pl.dreem.game.core;

import pl.dreem.game.core.board.BoardCore;
import pl.dreem.game.core.board.BoardCoreFactory;
import pl.dreem.game.domain.exception.GameAlreadyInProgressException;
import pl.dreem.game.domain.exception.GameNotReadyToStartException;
import pl.dreem.game.domain.vo.*;
import pl.dreem.game.mapper.InputMapper;
import pl.dreem.game.mapper.InputMapperFactory;
import pl.dreem.game.ui.GameUI;
import pl.dreem.game.ui.GameUIFactory;

import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class GameCore {

    private final GameUI ui;
    private final BoardCore boardCore;
    private final InputMapper inputMapper;

    private boolean gameStarted = false;
    private boolean gameNeedInitialising = true;

    private GameCore(final GameUI ui, final BoardCore boardCore, final InputMapper inputMapper) {
        this.ui = Objects.requireNonNull(ui);
        this.boardCore = Objects.requireNonNull(boardCore);
        this.inputMapper = Objects.requireNonNull(inputMapper);
    }

    public void initGame() {
        ui.initNewGame();
        gameNeedInitialising = false;
    }

    public void startGame() {
        if (gameNeedInitialising) {
            throw new GameNotReadyToStartException();
        }
        if (gameStarted) {
            throw new GameAlreadyInProgressException();
        }
        gameStarted = true;
        final ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(this::nextTurn);
    }

    private void nextTurn() {
        final Coordinates coordinates = ui.readNextMove();
        inputMapper.getBoardCoordinates(coordinates)
                   .ifPresentOrElse(this::processNextMove,
                                    this::retryTurn);
    }

    private void processNextMove(final BoardCoordinates boardCoordinates) {
        final MoveResult moveResult = boardCore.nextMove(boardCoordinates);
        processMoveResult(moveResult, boardCoordinates);
    }

    private void processMoveResult(final MoveResult result, final BoardCoordinates boardCoordinates) {
        final Player player = boardCore.getLastPlayer();
        if (MoveResult.SUCCESS.equals(result)) {
            ui.makeMove(player, boardCoordinates);
            nextTurn();
        } else if (MoveResult.FAIL.equals(result)) {
            retryTurn();
        } else if (MoveResult.WIN.equals(result)) {
            ui.makeMove(player, boardCoordinates);
            finishGame(result, player);
        } else if (MoveResult.DRAW.equals(result)) {
            ui.makeMove(player, boardCoordinates);
            finishGame(result, player);
        } else {
            throw new UnsupportedOperationException();
        }
    }

    private void retryTurn() {
        ui.displayResult(boardCore.getActualPlayer(), MoveResult.FAIL);
        nextTurn();
    }

    private void finishGame(final MoveResult result, final Player player) {
        gameStarted = false;
        ui.displayResult(player, result);
        System.exit(0);
    }

    public boolean isGameStarted() {
        return gameStarted;
    }

    public boolean isGameNeedInitialising() {
        return gameNeedInitialising;
    }

    public static GameCore initBasicGame() {
        return initFromSetup(Setup.BASIC);
    }

    public static GameCore initFromSetup(final Setup setup) {
        final GameUI ui = GameUIFactory.getFactory(setup.getGameUI());
        final BoardCore boardCore = BoardCoreFactory.getBoardCore(setup);
        final InputMapper inputMapper = InputMapperFactory.getInputMapper(setup.getInputMapper());
        return new GameCore(ui, boardCore, inputMapper);
    }

    public static GameCore initBasicWithCustomBoards(final GameUI ui, final BoardCore boardCore) {
        final InputMapper inputMapper = InputMapperFactory.getInputMapper(Setup.BASIC.getInputMapper());
        return new GameCore(ui, boardCore, inputMapper);
    }

    @Override
    public String toString() {
        return "GameCore{" +
                "ui=" + ui +
                ", boardCore=" + boardCore +
                ", inputMapper=" + inputMapper +
                ", gameStarted=" + gameStarted +
                ", gameNeedInitialising=" + gameNeedInitialising +
                '}';
    }
}
