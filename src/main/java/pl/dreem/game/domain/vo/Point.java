package pl.dreem.game.domain.vo;

import pl.dreem.game.domain.exception.InvalidPointInputException;

import java.util.Objects;

public final class Point {

    private final int column;
    private final int row;

    private Point(final int column, final int row) {
        this.column = column;
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public static Point from(final int column, final int row) {
        if ((column < 0) || (row < 0)) {
            throw new InvalidPointInputException();
        }
        return new Point(column, row);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return column == point.column &&
                row == point.row;
    }

    @Override
    public int hashCode() {
        return Objects.hash(column, row);
    }

    @Override
    public String toString() {
        return "Point{" +
                "column=" + column +
                ", row=" + row +
                '}';
    }
}
