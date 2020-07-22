package pl.dreem.game.core.validator.basic;

import pl.dreem.game.core.board.Board;
import pl.dreem.game.core.validator.ValidatorResult;
import pl.dreem.game.domain.vo.BoardCoordinates;
import pl.dreem.game.domain.vo.Symbol;

public final class BasicColumnValidator implements BasicValidator {

    @Override
    public ValidatorResult check(final Symbol searchSymbol, final BoardCoordinates lastMove, final Board actualBoard) {
        ValidatorResult result = ValidatorResult.NONE;

        final Symbol[][] board = actualBoard.getBoard();
        final int possibleMoves = actualBoard.getBoardProperties().getMinimumMoves();

        for (int column = 0; column < possibleMoves; column++) {
            if (board[lastMove.getRow()][column] != searchSymbol)
                break;
            if (column == possibleMoves - 1) {
                result = ValidatorResult.WIN;
            }
        }
        return result;
    }
}
