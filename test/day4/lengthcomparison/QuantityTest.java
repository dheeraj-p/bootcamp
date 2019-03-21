package day4.lengthcomparison;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class QuantityTest {
    @Test
    void shouldReturnTrueForSameValueOfFeet() {
        Quantity twoFeet = new Quantity(new BigDecimal("2"), Unit.FEET);
        Quantity otherTwoFeet = new Quantity(new BigDecimal("2"), Unit.FEET);
        assertTrue(twoFeet.isEqual(otherTwoFeet));
    }

    @Test
    void shouldReturnFalseForDifferentValueOfFeet() {
        Quantity twoFeet = new Quantity(new BigDecimal("2"), Unit.FEET);
        Quantity threeFeet = new Quantity(new BigDecimal("3"), Unit.FEET);
        assertFalse(twoFeet.isEqual(threeFeet));
    }

    @Test
    void shouldReturnTrueForFeetValueEquivalentToInchValue() {
        Quantity oneFeet = new Quantity(new BigDecimal("1"), Unit.FEET);
        Quantity twelveInches = new Quantity(new BigDecimal("12"), Unit.INCH);

        assertTrue(oneFeet.isEqual(twelveInches));
    }

    @Test
    void shouldReturnFalseWhenFeetValueInNotEquivalentToInchValue() {
        Quantity twoFeet = new Quantity(new BigDecimal("2"), Unit.FEET);
        Quantity twelveInches = new Quantity(new BigDecimal("12"), Unit.INCH);
        assertFalse(twoFeet.isEqual(twelveInches));
    }
}