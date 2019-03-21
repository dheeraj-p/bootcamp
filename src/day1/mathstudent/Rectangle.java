package day1.mathstudent;

public class Rectangle  {

    private final Dimension length;
    private final Dimension breadth;

    public Rectangle(Dimension length, Dimension breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public double calculateArea() {
        return this.length.getValue() * this.breadth.getValue();
    }

    public double calculatePerimeter() {
        return (this.length.getValue() + this.breadth.getValue()) * 2;
    }
}
