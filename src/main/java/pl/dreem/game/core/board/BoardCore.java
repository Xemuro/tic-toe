package pl.dreem.game.core.board;

import pl.dreem.game.domain.vo.BoardCoordinates;
import pl.dreem.game.domain.vo.MoveResult;
import pl.dreem.game.domain.vo.Player;

public interface BoardCore {
    Player getActualPlayer();

    Player getLastPlayer();

    MoveResult nextMove(BoardCoordinates boardCoordinates);
}
