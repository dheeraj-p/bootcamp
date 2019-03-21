package day1.mathstudent;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DimensionTest {
    @Test
    void shouldReturnADimensionWithGivenValidValue() throws InvalidDimensionException {
        Dimension length = Dimension.create(1);
        assertEquals(length.getValue(), 1);
    }

    @Test
    void shouldReturnNullGivenInvalidValue() {
        assertThrows(InvalidDimensionException.class, () -> {
            Dimension length = Dimension.create(-1);
        });

    }
}