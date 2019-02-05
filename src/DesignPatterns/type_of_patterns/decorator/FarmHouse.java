package DesignPatterns.type_of_patterns.decorator;

public class FarmHouse extends Pizza {

    public FarmHouse()  {
        description = "Farm house";
    }
    @Override
    public int getCost() {
        return 200;
    }
}
