package day1.mathstudent;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {
    @Test
    void shouldReturnAreaOfSquare() throws InvalidDimensionException {
        Square square = new Square(Dimension.create(1));
        double area = square.calculateArea();

        assertEquals(1D, area);
    }

    @Test
    void shouldReturnPerimeterOfSquare() throws InvalidDimensionException {
        Square square = new Square(Dimension.create(1));
        double perimeter = square.calculatePerimeter();
        assertEquals(4D, perimeter);
    }

}