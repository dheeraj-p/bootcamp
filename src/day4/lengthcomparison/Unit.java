package day4.lengthcomparison;

import java.math.BigDecimal;

class Unit {
    public static final Unit CENTIMETER = new Unit(new BigDecimal("10"));
    public static final Unit MILLIMETER = new Unit(new BigDecimal("1"));
    static final Unit INCH = new Unit(new BigDecimal("25"));
    static final Unit FEET = new Unit(new BigDecimal("300"));
    private final BigDecimal ratio;

    private Unit(BigDecimal ratio) {
        this.ratio = ratio;
    }

    BigDecimal toBaseUnit(BigDecimal value) {
        return value.multiply(ratio);
    }
}
