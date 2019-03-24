package day6.pizza;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ToppingsTest {

    @Test
    void shouldCalculatePriceOfAddedToppings() {
        Toppings toppings = new Toppings();
        toppings.add(Topping.VEGETABLE);
        toppings.add(Topping.CHICKEN);
        double expectedPrice = 50;

        assertEquals(expectedPrice, toppings.calculatePrice());
    }

    @Test
    void shouldReturnDescriptionForAddedToppings() {
        String expectedDescription = "* Vegetable\n* Chicken\n";
        Toppings toppings = new Toppings();
        toppings.add(Topping.VEGETABLE);
        toppings.add(Topping.CHICKEN);

        assertEquals(expectedDescription, toppings.getDescription());
    }
}