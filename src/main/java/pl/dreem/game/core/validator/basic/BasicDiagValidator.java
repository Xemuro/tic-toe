package pl.dreem.game.core.validator.basic;

import pl.dreem.game.core.board.Board;
import pl.dreem.game.core.validator.ValidatorResult;
import pl.dreem.game.domain.vo.BoardCoordinates;
import pl.dreem.game.domain.vo.Symbol;

public final class BasicDiagValidator implements BasicValidator {

    @Override
    public ValidatorResult check(Symbol searchSymbol, BoardCoordinates lastMove, final Board actualBoard) {
        ValidatorResult result = ValidatorResult.NONE;

        final Symbol[][] board = actualBoard.getBoard();
        final int possibleMoves = actualBoard.getBoardProperties().getMinimumMoves();

        if (lastMove.getRow() == lastMove.getColumn()) {
            for (int index = 0; index < possibleMoves; index++) {
                if (board[index][index] != searchSymbol)
                    break;
                if (index == possibleMoves - 1) {
                    result = ValidatorResult.WIN;
                }
            }
        }
        return result;
    }
}
