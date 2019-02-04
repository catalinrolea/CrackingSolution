package DesignPatterns.type_of_patterns.builder;

public class ChickenBurger extends Burger {
    @Override
    public String foodName() {
        return "Chicken burger";
    }

    @Override
    public float foodPrice() {
        return 50.5f;
    }
}
