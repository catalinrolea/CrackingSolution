package DesignPatterns.type_of_patterns.decorator;

public class Chicken extends Pizza {

    public Chicken(){
        description = "Chicken";
    }
    @Override
    public int getCost() {
        return 350;
    }
}
