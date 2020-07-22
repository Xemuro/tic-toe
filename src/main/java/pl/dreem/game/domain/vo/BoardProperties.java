package pl.dreem.game.domain.vo;

import java.util.Objects;

public final class BoardProperties {

    private final int columns;
    private final int rows;
    private final int maxMovements;

    private BoardProperties(final int columns, final int rows, final int maxMovements) {
        this.columns = columns;
        this.rows = rows;
        this.maxMovements = maxMovements;
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public int getMaxMovements() {
        return maxMovements;
    }

    public int getMinimumMoves() {
        return Math.min(columns, rows);
    }

    public static BoardProperties create(final int columns, final int rows){
        return new BoardProperties(columns, rows, columns * rows);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardProperties that = (BoardProperties) o;
        return columns == that.columns &&
                rows == that.rows &&
                maxMovements == that.maxMovements;
    }

    @Override
    public int hashCode() {
        return Objects.hash(columns, rows, maxMovements);
    }

    @Override
    public String toString() {
        return "BoardProperties{" +
                "columns=" + columns +
                ", rows=" + rows +
                ", maxMovements=" + maxMovements +
                '}';
    }
}
