package pl.dreem.game.core.board;

import pl.dreem.game.core.validator.BoardValidator;
import pl.dreem.game.core.validator.BoardValidatorFactory;
import pl.dreem.game.domain.vo.*;

import java.util.Objects;

public final class BasicBoardCore implements BoardCore {

    private final Board board;
    private final BoardProperties boardProperties;
    private final BoardValidator validator;

    private Player actualPlayer;
    private Player lastPlayer;

    private BasicBoardCore(final Board board, final Setup setup) {
        this.board = Objects.requireNonNull(board);
        this.boardProperties = Objects.requireNonNull(board.getBoardProperties());
        this.validator = BoardValidatorFactory.getValidator(setup.getInputMapper());
        this.actualPlayer = Player.FIRST;
        this.lastPlayer = Player.SECOND;
    }

    @Override
    public Player getActualPlayer() {
        return actualPlayer;
    }

    @Override
    public Player getLastPlayer() {
        return lastPlayer;
    }

    @Override
    public MoveResult nextMove(final BoardCoordinates boardCoordinates) {
        final MoveResult result;

        final boolean isCoordinatesValid = boardCoordinates.isCoordinatesValid(boardProperties);

        if (isCoordinatesValid && isDotField(board.getSymbol(boardCoordinates.getPoint()))) {
            result = processPlayerMove(boardCoordinates);
        } else {
            result = MoveResult.FAIL;
        }

        return result;
    }

    private MoveResult processPlayerMove(final BoardCoordinates coordinated) {
        final MoveResult result;

        final Symbol playerSymbol = actualPlayer.getSymbol();
        board.makePlayerMove(coordinated.getPoint(), playerSymbol);

        if (isTimeToCheckPlayerStatus()) {
            result = verifyPlayerStatus(coordinated);
        } else {
            result = MoveResult.SUCCESS;
        }

        switchPlayer();

        return result;
    }

    private MoveResult verifyPlayerStatus(final BoardCoordinates lastMove) {
        return validator.verifyPlayerStatus(board, actualPlayer.getSymbol(), lastMove)
                        .getResult();
    }

    private boolean isTimeToCheckPlayerStatus() {
        return board.getMovements() >= boardProperties.getMinimumMoves();
    }

    private boolean isDotField(final Symbol actualSymbol) {
        return actualSymbol == Symbol.DOT;
    }

    private void switchPlayer() {
        lastPlayer = actualPlayer;
        actualPlayer = actualPlayer == Player.FIRST ? Player.SECOND : Player.FIRST;
    }

    public static BasicBoardCore initNewBasicBoard(final Setup setup) {
        final Board board = Board.createBasicBoard();
        return new BasicBoardCore(board, setup);
    }
}