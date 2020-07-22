package pl.dreem.game.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.dreem.game.domain.exception.InvalidPointInputException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PointTest {

    @DisplayName("create_basicParameters_positive")
    @Test
    public void pointShouldBeCreatedForValidParameters() {
        Point actualResult = Point.from(10, 10);
        assertNotNull(actualResult);
    }

    @DisplayName("create_boundaryParameters_positive")
    @Test
    public void pointShouldBeCreatedForBoundaryParameters() {
        Point actualResult = Point.from(0, 0);
        assertNotNull(actualResult);
    }

    @DisplayName("create_negativeParameters_failure")
    @Test
    public void pointShouldNotBeCreatedForNegativeParameters() {
        assertThrows(InvalidPointInputException.class, () -> Point.from(-10, -10));
    }

    @DisplayName("create_mixNegativePositiveParameters_failure")
    @Test
    public void pointShouldNotBeCreatedForNegativePositiveParameters() {
        assertThrows(InvalidPointInputException.class, () -> Point.from(-10, 10));
    }

    @DisplayName("create_mixPositiveNegativeParameters_failure")
    @Test
    public void pointShouldNotBeCreatedForNegativeParametersParameters() {
        assertThrows(InvalidPointInputException.class, () -> Point.from(10, -10));
    }
}
