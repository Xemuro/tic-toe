package pl.dreem.game.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BoardCoordinatesTest {

    @DisplayName("isCoordinatesValid_validParameters_positive")
    @Test
    public void isCoordinatesValidShouldForValidParametersReturnPositiveResult(){
        final int x = 5;
        final int y = 5;
        final Point point = Point.from(x, y);
        final BoardProperties testData = BoardProperties.create(10, 10);

        final boolean expectedResult = true;

        BoardCoordinates sut = BoardCoordinates.from(point);
        boolean actualResult = sut.isCoordinatesValid(testData);
        assertThat(actualResult, is(expectedResult));
    }

    @DisplayName("isCoordinatesValid_boundaryParameters_positive")
    @Test
    public void isCoordinatesValidShouldForBoundaryParametersReturnPositiveResult(){
        final int x = 4;
        final int y = 4;
        final Point point = Point.from(x, y);
        final BoardProperties testData = BoardProperties.create(10, 10);

        final boolean expectedResult = true;

        BoardCoordinates sut = BoardCoordinates.from(point);
        boolean actualResult = sut.isCoordinatesValid(testData);
        assertThat(actualResult, is(expectedResult));
    }
}