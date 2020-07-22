package pl.dreem.game.domain.vo;

import pl.dreem.game.domain.exception.InvalidInputException;

import java.util.Objects;
import java.util.regex.Pattern;

public final class Coordinates {

    private final String row;
    private final String column;

    private Coordinates(final String row, final String column) {
        this.row = Objects.requireNonNull(row);
        this.column = Objects.requireNonNull(column);
    }

    public String getRow() {
        return row;
    }

    public String getColumn() {
        return column;
    }

    public static Coordinates fromKeyBoardInput(final String input) throws InvalidInputException {
        final String inputWithoutSpaces = input.replaceAll("\\s+", "");
        final Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-zA-Z])([a-zA-Z0-9]{2})$");
        if (!pattern.matcher(inputWithoutSpaces).matches()) {
            throw new InvalidInputException();
        }

        final String[] splitInput = inputWithoutSpaces.split("");
        final boolean isLetter = Character.isLetter(splitInput[0].charAt(0));

        final String column, row;

        if (isLetter) {
            row = splitInput[0];
            column = splitInput[1];
        } else {
            column = splitInput[0];
            row = splitInput[1];
        }

        return new Coordinates(row.toUpperCase(), column);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(row, that.row) &&
                Objects.equals(column, that.column);
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "row='" + row + '\'' +
                ", column='" + column + '\'' +
                '}';
    }
}
