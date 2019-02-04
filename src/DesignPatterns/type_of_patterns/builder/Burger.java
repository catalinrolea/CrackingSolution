package DesignPatterns.type_of_patterns.builder;

public abstract class Burger implements FoodItem {
    //specify how the burger will be packed
   //specify the price for burger
    @Override
    public Packing foodPacking(){
         return new Ambalaj();
     }

    @Override
    public abstract float foodPrice();

}
