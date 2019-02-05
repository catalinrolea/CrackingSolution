package DesignPatterns.type_of_patterns.adapter;

public class PlasticToyDuck implements ToyDuck {
    @Override
    public void square() {
        System.out.println("Square square toy duck");
    }
}
