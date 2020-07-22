package pl.dreem.game.core.validator;

import pl.dreem.game.domain.vo.CoordinatesInput;

public final class BoardValidatorFactory {

    public static BoardValidator getValidator(final CoordinatesInput coordinatesInput) {
        if (CoordinatesInput.BASIC.equals(coordinatesInput)) {
            return new BasicBoardValidator();
        } else {
            throw new UnsupportedOperationException();
        }
    }
}