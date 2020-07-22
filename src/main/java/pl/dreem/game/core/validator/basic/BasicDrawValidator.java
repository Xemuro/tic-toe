package pl.dreem.game.core.validator.basic;

import pl.dreem.game.core.board.Board;
import pl.dreem.game.core.validator.ValidatorResult;
import pl.dreem.game.domain.vo.BoardCoordinates;
import pl.dreem.game.domain.vo.Symbol;

public final class BasicDrawValidator implements BasicValidator {

    @Override
    public ValidatorResult check(final Symbol searchSymbol, final BoardCoordinates lastMove, final Board actualBoard) {
        ValidatorResult result = ValidatorResult.NONE;
        if (actualBoard.getMovements() == actualBoard.getBoardProperties().getMaxMovements()) {
            result = ValidatorResult.DRAW;
        }
        return result;
    }
}
