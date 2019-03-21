package day1.mathstudent;

public class Dimension {

    private double value;

    private Dimension(double value) {
        this.value = value;
    }

    public static Dimension create(double value) throws InvalidDimensionException {
        if (value > 0) {
            return new Dimension(value);
        }

        throw new InvalidDimensionException("Invalid Dimension");
    }

    public double getValue() {
        return this.value;
    }
}
