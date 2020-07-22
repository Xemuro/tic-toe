package pl.dreem.game.core.validator.basic;

import pl.dreem.game.core.board.Board;
import pl.dreem.game.core.validator.ValidatorResult;
import pl.dreem.game.domain.vo.BoardCoordinates;
import pl.dreem.game.domain.vo.Symbol;

public final class BasicRowValidator implements BasicValidator {

    @Override
    public ValidatorResult check(final Symbol searchSymbol, final BoardCoordinates lastMove, final Board actualBoard) {
        ValidatorResult result = ValidatorResult.NONE;

        final Symbol[][] board = actualBoard.getBoard();
        final int possibleMoves = actualBoard.getBoardProperties().getMinimumMoves();

        for (int row = 0; row < possibleMoves; row++) {
            if (board[row][lastMove.getColumn()] != searchSymbol)
                break;
            if (row == possibleMoves - 1) {
                result = ValidatorResult.WIN;
            }
        }
        return result;
    }
}