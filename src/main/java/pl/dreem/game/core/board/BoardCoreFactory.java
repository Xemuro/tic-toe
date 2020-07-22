package pl.dreem.game.core.board;

import pl.dreem.game.domain.vo.Setup;

public final class BoardCoreFactory {

    public static BoardCore getBoardCore(final Setup setup) {
        if (Setup.BASIC.equals(setup)) {
            return BasicBoardCore.initNewBasicBoard(setup);
        } else {
            throw new UnsupportedOperationException();
        }
    }

}
