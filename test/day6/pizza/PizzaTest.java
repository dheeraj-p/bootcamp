package day6.pizza;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PizzaTest {

    @Test
    void shouldReturnTheBasePriceWhenNoToppingIsAdded() {
        double expectedPrice = 50;
        Pizza pizza = new Pizza();
        assertEquals(expectedPrice, pizza.calculatePrice());
    }

    @Test
    void shouldReturnTheTotalPriceWhenSomeToppingsAreAddedToPizza() {
        double expectedPrice = 100;
        Pizza pizza = new Pizza();
        pizza.addTopping(Topping.CHICKEN);
        pizza.addTopping(Topping.VEGETABLE);

        assertEquals(expectedPrice, pizza.calculatePrice());
    }
}