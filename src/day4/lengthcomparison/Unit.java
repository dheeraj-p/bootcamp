package day4.lengthcomparison;

import java.math.BigDecimal;

class Unit {
    static final Unit INCH = new Unit(new BigDecimal("1"));
    static final Unit FEET = new Unit(new BigDecimal("12"));
    private final BigDecimal ratio;

    private Unit(BigDecimal ratio) {
        this.ratio = ratio;
    }

    BigDecimal toBaseUnit(BigDecimal value) {
        return value.multiply(ratio);
    }
}
