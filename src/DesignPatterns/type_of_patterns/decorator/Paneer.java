package DesignPatterns.type_of_patterns.decorator;

public class Paneer extends ToppingDecorator {

    Pizza pizza;
    public  Paneer(Pizza pizza) {
        this.pizza = pizza;
    }
    @Override
    public String getDescription() {
        return pizza.getDescription() + " paneer";
    }

    @Override
    public int getCost() {
        return 20 + pizza.getCost();
    }
}
