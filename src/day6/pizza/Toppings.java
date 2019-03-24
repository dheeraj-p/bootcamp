package day6.pizza;

import java.util.ArrayList;
import java.util.List;

class Toppings {


    private List<Topping> toppingList;

    Toppings() {
        this.toppingList = new ArrayList<>();
    }

    void add(Topping topping) {
        this.toppingList.add(topping);
    }

    double calculatePrice() {
        double totalPrice = 0;

        for (Topping topping : this.toppingList) {
            totalPrice += topping.getPrice();
        }

        return totalPrice;
    }

    String getDescription() {
        StringBuilder description = new StringBuilder();
        for (Topping topping : this.toppingList) {
            description.append("* ").append(topping.getName()).append('\n');
        }

        return description.toString();
    }
}
