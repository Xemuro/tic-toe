package pl.dreem.game.core.validator;

import pl.dreem.game.core.board.Board;
import pl.dreem.game.core.validator.basic.BasicValidator;
import pl.dreem.game.core.validator.basic.BasicValidatorsFactory;
import pl.dreem.game.domain.vo.BoardCoordinates;
import pl.dreem.game.domain.vo.Symbol;

public final class BasicBoardValidator implements BoardValidator {

    @Override
    public ValidatorResult verifyPlayerStatus(final Board board, final Symbol searchSymbol,
                                         final BoardCoordinates lastMove) {
        ValidatorResult result = ValidatorResult.NONE;

        for (final BasicValidator validator : BasicValidatorsFactory.getBasicValidators()) {
            result = validator.check(searchSymbol, lastMove, board);
            if (ValidatorResult.NONE != result) {
                break;
            }
        }

        return result;
    }
}