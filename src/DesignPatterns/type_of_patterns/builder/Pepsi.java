package DesignPatterns.type_of_patterns.builder;

public class Pepsi extends ColdDrink {
    @Override
    public String foodName() {
        return "Pepsi";
    }

    @Override
    public float foodPrice() {
        return 35.0f;
    }
}
