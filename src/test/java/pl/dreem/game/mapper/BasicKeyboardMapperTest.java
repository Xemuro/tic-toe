package pl.dreem.game.mapper;

import org.junit.jupiter.api.Test;
import pl.dreem.game.domain.exception.InvalidInputException;
import pl.dreem.game.domain.vo.BoardCoordinates;
import pl.dreem.game.domain.vo.Coordinates;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class BasicKeyboardMapperTest {

    @Test
    public void getBoardCoordinatesShouldMapCoordinatesCorrectlyCaseA1() throws InvalidInputException {
        final BasicKeyboardMapper sut = new BasicKeyboardMapper();

        final Coordinates testCoordinates = Coordinates.fromKeyBoardInput("a1");
        final Optional<BoardCoordinates> actualResult = (sut.getBoardCoordinates(testCoordinates));

        assertThat(actualResult.isPresent(), is(true));
        assertThat(actualResult.get().getColumn(), is(equalTo(0)));
        assertThat(actualResult.get().getRow(), is(equalTo(0)));
    }

    @Test
    public void getBoardCoordinatesShouldMapCoordinatesCorrectlyCaseB2() throws InvalidInputException {
        final BasicKeyboardMapper sut = new BasicKeyboardMapper();

        final Coordinates testCoordinates = Coordinates.fromKeyBoardInput("b2");
        final Optional<BoardCoordinates> actualResult = sut.getBoardCoordinates(testCoordinates);

        assertThat(actualResult.isPresent(), is(true));
        assertThat(actualResult.get().getColumn(), is(equalTo(1)));
        assertThat(actualResult.get().getRow(), is(equalTo(1)));
    }

    @Test
    public void getBoardCoordinatesShouldMapCoordinatesCorrectlyCaseC3() throws InvalidInputException {
        final BasicKeyboardMapper sut = new BasicKeyboardMapper();

        final Coordinates testCoordinates = Coordinates.fromKeyBoardInput("c3");
        final Optional<BoardCoordinates> actualResult = sut.getBoardCoordinates(testCoordinates);

        assertThat(actualResult.get().getColumn(), is(equalTo(2)));
        assertThat(actualResult.get().getRow(), is(equalTo(2)));
    }

    @Test
    public void getBoardCoordinatesShouldNotMapCaseD4() throws InvalidInputException {
        final BasicKeyboardMapper sut = new BasicKeyboardMapper();

        final Coordinates testCoordinates = Coordinates.fromKeyBoardInput("d4");
        final Optional<BoardCoordinates> actualResult = sut.getBoardCoordinates(testCoordinates);

        assertThat(actualResult.isPresent(), is(false));
    }
}
