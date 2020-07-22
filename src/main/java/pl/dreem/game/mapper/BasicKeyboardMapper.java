package pl.dreem.game.mapper;

import pl.dreem.game.domain.vo.BoardCoordinates;
import pl.dreem.game.domain.vo.Coordinates;
import pl.dreem.game.domain.vo.Point;

import java.util.Optional;

public class BasicKeyboardMapper implements InputMapper {

    @Override
    public Optional<BoardCoordinates> getBoardCoordinates(final Coordinates coordinates) {
        final String column = coordinates.getColumn();
        final String row = coordinates.getRow();

        final int mappedColumn;
        if (row.equalsIgnoreCase("A")) {
            mappedColumn = 0;
        } else if (row.equalsIgnoreCase("B")) {
            mappedColumn = 1;
        } else if (row.equalsIgnoreCase("C")) {
            mappedColumn = 2;
        } else {
            return Optional.empty();
        }

        final int mappedRow = Integer.valueOf(column) - 1;
        if (mappedRow < 0) {
            return Optional.empty();
        }

        return Optional.of(BoardCoordinates.from(Point.from(mappedColumn, mappedRow)));
    }
}
