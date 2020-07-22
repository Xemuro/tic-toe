package pl.dreem.game.core.validator;

import pl.dreem.game.domain.vo.MoveResult;

public enum ValidatorResult {

    NONE(MoveResult.SUCCESS),
    WIN(MoveResult.WIN),
    DRAW(MoveResult.DRAW);

    private MoveResult result;

    ValidatorResult(final MoveResult result) {
        this.result = result;
    }

    public MoveResult getResult() {
        return result;
    }
}
