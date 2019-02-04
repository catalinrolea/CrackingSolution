package DesignPatterns.type_of_patterns.builder;

public class Coke extends ColdDrink {
    @Override
    public String foodName() {
        return "Coke";
    }

    @Override
    public float foodPrice() {
        return 30.0f;
    }
}
