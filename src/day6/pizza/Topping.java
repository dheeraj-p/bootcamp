package day6.pizza;

enum Topping {
    VEGETABLE(20, "Vegetable"),
    MOZZARELLA(10, "Mozzarella"),
    TOMATOSAUCE(5, "Tomato Sauce"),
    EXTRACHEESE(25, "Extra Cheese"),
    JALAPENO(40, "Jalapeno"),
    CHICKEN(30, "Chicken");

    private double price;
    private String name;

    Topping(double price, String name) {
        this.price = price;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    double getPrice() {
        return this.price;
    }
}
