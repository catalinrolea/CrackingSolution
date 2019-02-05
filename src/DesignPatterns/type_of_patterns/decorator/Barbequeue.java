package DesignPatterns.type_of_patterns.decorator;

public class Barbequeue extends ToppingDecorator {

    Pizza pizza;
    public Barbequeue(Pizza pizza){
        this.pizza = pizza;
    }
    @Override
    public String getDescription() {
        return pizza.getDescription() + "Barbequeue";
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 30;
    }
}
