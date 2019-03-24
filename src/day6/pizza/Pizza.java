package day6.pizza;

class Pizza {

    private static final double BASE_PRICE = 50;

    private Toppings toppings;

    Pizza() {
        this.toppings = new Toppings();
    }

    double calculatePrice() {
        return BASE_PRICE + this.toppings.calculatePrice();
    }

    void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    String getDescription() {
        return toppings.getDescription();
    }
}
