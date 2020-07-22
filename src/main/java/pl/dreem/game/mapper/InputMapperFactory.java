package pl.dreem.game.mapper;

import pl.dreem.game.domain.vo.CoordinatesInput;

public final class InputMapperFactory {

    public static InputMapper getInputMapper(final CoordinatesInput input) {
        if (CoordinatesInput.BASIC.equals(input)) {
            return new BasicKeyboardMapper();
        } else {
            throw new UnsupportedOperationException();
        }
    }

}
