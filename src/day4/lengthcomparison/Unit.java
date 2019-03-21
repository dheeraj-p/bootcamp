package day4.lengthcomparison;

import java.math.BigDecimal;

class Unit {
    public static final Unit CENTIMETER = new Unit(new BigDecimal("1.0"));
    static final Unit INCH = new Unit(new BigDecimal("2.5"));
    static final Unit FEET = new Unit(new BigDecimal("30.0"));
    private final BigDecimal ratio;

    private Unit(BigDecimal ratio) {
        this.ratio = ratio;
    }

    BigDecimal toBaseUnit(BigDecimal value) {
        return value.multiply(ratio);
    }
}
