package pl.dreem.game.core.validator.basic;

import pl.dreem.game.core.board.Board;
import pl.dreem.game.core.validator.ValidatorResult;
import pl.dreem.game.domain.vo.BoardCoordinates;
import pl.dreem.game.domain.vo.MoveResult;
import pl.dreem.game.domain.vo.Symbol;

public interface BasicValidator {

    ValidatorResult check(Symbol searchSymbol, BoardCoordinates lastMove, Board actualBoard);

}
