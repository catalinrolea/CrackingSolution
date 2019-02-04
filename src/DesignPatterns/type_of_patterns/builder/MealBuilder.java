package DesignPatterns.type_of_patterns.builder;

public class MealBuilder {

    public Meal prepareVegetal()    {
        Meal meal = new Meal();
        meal.add(new VegBurger());
        meal.add(new Coke());
        return meal;
    }

    public Meal prepareNonVegetal() {
        Meal meal = new Meal();
        meal.add(new ChickenBurger());
        meal.add(new Pepsi());
        return meal;
    }
}
