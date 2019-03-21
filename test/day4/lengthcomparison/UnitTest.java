package day4.lengthcomparison;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UnitTest {

    @Test
    void shouldReturnValueOfFeetInInches() {
        BigDecimal expected = new BigDecimal("300");
        BigDecimal actual = Unit.FEET.toBaseUnit(new BigDecimal("1"));
        assertEquals(expected, actual);
    }
}