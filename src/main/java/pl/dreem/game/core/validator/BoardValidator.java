package pl.dreem.game.core.validator;

import pl.dreem.game.core.board.Board;
import pl.dreem.game.domain.vo.BoardCoordinates;
import pl.dreem.game.domain.vo.Symbol;

public interface BoardValidator {

    ValidatorResult verifyPlayerStatus(final Board board, final Symbol searchSymbol, final BoardCoordinates lastMove);

}
