package DesignPatterns.type_of_patterns.builder;

public class BuildPatternDemo {

    public static void main(String[] args)  {
        MealBuilder mealBuilder = new MealBuilder();
        Meal vegMealer = mealBuilder.prepareVegetal();
        System.out.println("Veg Meal: ");
        vegMealer.showItems();
        System.out.println("Cost: " + vegMealer.getCost());

        Meal nonVegMealer = mealBuilder.prepareNonVegetal();
        System.out.println("Non Veg Meal: ");
        nonVegMealer.showItems();
        System.out.println("Cost: " + nonVegMealer.getCost());
    }
}
