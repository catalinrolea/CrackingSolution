package DesignPatterns.type_of_patterns.decorator;

public class FreshTomato extends ToppingDecorator {
     Pizza pizza;

     public FreshTomato(Pizza pizza)   {
         this.pizza = pizza;
     }
    @Override
    public String getDescription() {
        return pizza.getDescription() + " with fresh tomato";
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 10;
    }
}
