package DesignPatterns.type_of_patterns.builder;

import java.util.LinkedList;
import java.util.List;

public class Meal {
    private List<FoodItem> arrayOfFoodItems = new LinkedList<>();
    public void add(FoodItem item)  {
        arrayOfFoodItems.add(item);
    }

    public float getCost() {
        float cost = 0.0f;
        for (FoodItem items : arrayOfFoodItems ){
            cost +=items.foodPrice();
        }
        return cost;
    }

    public void showItems() {
        for (FoodItem item : arrayOfFoodItems)  {
            System.out.println("item: "+item.foodName());
            System.out.println(", Packing: "+item.foodPacking());
            System.out.println(", Price: "+item.foodPrice());
        }
    }
}
