package pl.dreem.game.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.dreem.game.domain.exception.InvalidInputException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CoordinatesTest {

    @DisplayName("fromKeyBoardInput_a1_positive")
    @Test
    public void fromKeyBoardInputShouldValidHandlea1Case() throws InvalidInputException {
        final String testInput = "a1";
        final String expectedColumn = "1";
        final String expectedRow = "A";

        final Coordinates coordinates = Coordinates.fromKeyBoardInput(testInput);

        final String actualColumn = coordinates.getColumn();
        final String actualRow = coordinates.getRow();

        assertThat(actualColumn, is(equalTo(expectedColumn)));
        assertThat(actualRow, is(equalTo(expectedRow)));
    }

    @DisplayName("fromKeyBoardInput_A1_positive")
    @Test
    public void fromKeyBoardInputShouldValidHandleA1Case() throws InvalidInputException {
        final String testInput = "A1";
        final String expectedColumn = "1";
        final String expectedRow = "A";

        final Coordinates coordinates = Coordinates.fromKeyBoardInput(testInput);

        final String actualColumn = coordinates.getColumn();
        final String actualRow = coordinates.getRow();

        assertThat(actualColumn, is(equalTo(expectedColumn)));
        assertThat(actualRow, is(equalTo(expectedRow)));
    }

    @DisplayName("fromKeyBoardInput_1a_positive")
    @Test
    public void fromKeyBoardInputShouldValidHandle1aCase() throws InvalidInputException {
        final String testInput = "1a";
        final String expectedColumn = "1";
        final String expectedRow = "A";

        final Coordinates coordinates = Coordinates.fromKeyBoardInput(testInput);

        final String actualColumn = coordinates.getColumn();
        final String actualRow = coordinates.getRow();

        assertThat(actualColumn, is(equalTo(expectedColumn)));
        assertThat(actualRow, is(equalTo(expectedRow)));
    }

    @DisplayName("fromKeyBoardInput_c9_positive")
    @Test
    public void fromKeyBoardInputShouldValidHandlec9Case() throws InvalidInputException {
        final String testInput = "c9";
        final String expectedColumn = "9";
        final String expectedRow = "C";

        final Coordinates coordinates = Coordinates.fromKeyBoardInput(testInput);

        final String actualColumn = coordinates.getColumn();
        final String actualRow = coordinates.getRow();

        assertThat(actualColumn, is(equalTo(expectedColumn)));
        assertThat(actualRow, is(equalTo(expectedRow)));
    }

    @DisplayName("fromKeyBoardInput_1A_positive")
    @Test
    public void fromKeyBoardInputShouldValidHandle1ACase() throws InvalidInputException {
        final String testInput = "1A";
        final String expectedColumn = "1";
        final String expectedRow = "A";

        final Coordinates coordinates = Coordinates.fromKeyBoardInput(testInput);

        final String actualColumn = coordinates.getColumn();
        final String actualRow = coordinates.getRow();

        assertThat(actualColumn, is(equalTo(expectedColumn)));
        assertThat(actualRow, is(equalTo(expectedRow)));
    }

    @DisplayName("fromKeyBoardInput_AA_failure")
    @Test
    public void fromKeyBoardInputShouldThrowExceptionAACase() {
        final String testInput = "AA";
        assertThrows(InvalidInputException.class, () -> Coordinates.fromKeyBoardInput(testInput));
    }

    @DisplayName("fromKeyBoardInput_11_failure")
    @Test
    public void fromKeyBoardInputShouldThrowException11Case() {
        final String testInput = "11";
        assertThrows(InvalidInputException.class, () -> Coordinates.fromKeyBoardInput(testInput));
    }

    @DisplayName("fromKeyBoardInput_LONG_failure")
    @Test
    public void fromKeyBoardInputShouldThrowExceptionLongUpperCase() {
        final String testInput = "LONG";
        assertThrows(InvalidInputException.class, () -> Coordinates.fromKeyBoardInput(testInput));
    }

    @DisplayName("fromKeyBoardInput_long_failure")
    @Test
    public void fromKeyBoardInputShouldThrowExceptionLowerCase() {
        final String testInput = "long";
        assertThrows(InvalidInputException.class, () -> Coordinates.fromKeyBoardInput(testInput));
    }

    @DisplayName("fromKeyBoardInput_B_failure")
    @Test
    public void fromKeyBoardInputShouldThrowExceptionBUpperCase() {
        final String testInput = "B";
        assertThrows(InvalidInputException.class, () -> Coordinates.fromKeyBoardInput(testInput));
    }

    @DisplayName("fromKeyBoardInput_b_failure")
    @Test
    public void fromKeyBoardInputShouldThrowExceptionBLowerCase() {
        final String testInput = "b";
        assertThrows(InvalidInputException.class, () -> Coordinates.fromKeyBoardInput(testInput));
    }
}