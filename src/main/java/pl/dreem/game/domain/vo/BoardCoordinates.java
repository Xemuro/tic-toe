package pl.dreem.game.domain.vo;

import java.util.Objects;

public final class BoardCoordinates {

    private Point point;

    private BoardCoordinates(final Point point) {
        this.point = Objects.requireNonNull(point);
    }

    public Point getPoint() {
        return point;
    }

    public int getColumn() {
        return point.getColumn();
    }

    public int getRow() {
        return point.getRow();
    }

    public boolean isCoordinatesValid(final BoardProperties properties) {
        final boolean result;
        if (point.getColumn() >= properties.getColumns() || point.getRow() >= properties.getRows()) {
            result = false;
        } else {
            result = true;
        }
        return result;
    }

    public static BoardCoordinates from(final Point point) {
        return new BoardCoordinates(point);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardCoordinates that = (BoardCoordinates) o;
        return Objects.equals(point, that.point);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point);
    }

    @Override
    public String toString() {
        return "BoardCoordinates{" +
                "point=" + point +
                '}';
    }
}
