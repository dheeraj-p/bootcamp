package day4.lengthcomparison;

import java.math.BigDecimal;

class Quantity {
    private final BigDecimal value;
    private final Unit unit;

    Quantity(BigDecimal value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    BigDecimal toValueInBaseUnit(){
        return this.unit.toBaseUnit(this.value);
    }

    boolean isEqual(Quantity anotherQuantity){
        return this.toValueInBaseUnit().equals(anotherQuantity.toValueInBaseUnit());
    }

}
