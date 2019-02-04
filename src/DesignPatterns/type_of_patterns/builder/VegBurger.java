package DesignPatterns.type_of_patterns.builder;

public class VegBurger extends Burger {
    @Override
    public String foodName() {
        return "Veg Burger";
    }

    @Override
    public float foodPrice() {
        return 25.0f;
    }
}
