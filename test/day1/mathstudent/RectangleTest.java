package day1.mathstudent;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
    @Test
    void shouldReturnAreaOfRectangle() throws InvalidDimensionException {
        Rectangle rectangle = new Rectangle(Dimension.create(1),Dimension.create(2));
        double area = rectangle.calculateArea();

        assertEquals(2D, area);
    }

    @Test
    void shouldReturnPerimeterOfRectangle() throws InvalidDimensionException {
        Rectangle rectangle = new Rectangle(Dimension.create(1),Dimension.create(2));
        double perimeter = rectangle.calculatePerimeter();
        assertEquals(6D, perimeter);
    }
}