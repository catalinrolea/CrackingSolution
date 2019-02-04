package DesignPatterns.type_of_patterns.builder;

public abstract class ColdDrink implements FoodItem {

    @Override
    public Packing foodPacking()    {
        return new Sticla();
    }
    @Override
    public abstract float foodPrice();
}
