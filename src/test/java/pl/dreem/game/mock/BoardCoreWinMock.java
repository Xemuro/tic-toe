package pl.dreem.game.mock;

import pl.dreem.game.core.board.BoardCore;
import pl.dreem.game.domain.vo.BoardCoordinates;
import pl.dreem.game.domain.vo.MoveResult;
import pl.dreem.game.domain.vo.Player;

public final class BoardCoreWinMock implements BoardCore {

    @Override
    public Player getActualPlayer() {
        return Player.FIRST;
    }

    @Override
    public Player getLastPlayer() {
        return Player.SECOND;
    }

    @Override
    public MoveResult nextMove(BoardCoordinates boardCoordinates) {
        return MoveResult.WIN;
    }
}
