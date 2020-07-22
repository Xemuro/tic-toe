package pl.dreem.game.mapper;

import pl.dreem.game.domain.vo.BoardCoordinates;
import pl.dreem.game.domain.vo.Coordinates;

import java.util.Optional;

public interface InputMapper {

    Optional<BoardCoordinates> getBoardCoordinates(final Coordinates coordinates);

}
