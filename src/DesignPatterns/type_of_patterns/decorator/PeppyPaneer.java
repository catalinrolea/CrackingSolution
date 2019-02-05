package DesignPatterns.type_of_patterns.decorator;

public class PeppyPaneer extends Pizza {

    public PeppyPaneer(){
        description = "Peppy panner";
    }
    @Override
    public int getCost() {
        return 100;
    }
}
