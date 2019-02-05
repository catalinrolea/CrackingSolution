package DesignPatterns.type_of_patterns.decorator;

public abstract class Pizza {
    String description = "unknown";
    public String getDescription()  {
        return description;
    }
    public abstract int getCost();
}
