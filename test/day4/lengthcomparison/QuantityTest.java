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

    @Test
    void shouldReturnTrueForInchValueEquivalentToCentimeterValue() {
        Quantity twoInches = new Quantity(new BigDecimal("2"), Unit.INCH);
        Quantity fiveCentimeters = new Quantity(new BigDecimal("5"), Unit.CENTIMETER);
        assertTrue(twoInches.isEqual(fiveCentimeters));
    }

    @Test
    void shouldReturnTrueForCentimeterValueEquivalentToMillimeterValue() {
        Quantity oneCentimeter = new Quantity(new BigDecimal("1"), Unit.CENTIMETER);
        Quantity tenMillimeter = new Quantity(new BigDecimal("10"), Unit.MILLIMETER);
        assertTrue(oneCentimeter.isEqual(tenMillimeter));
    }
}