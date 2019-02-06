package DesignPatterns.type_of_patterns.strategy;

public class Ken extends Fighter {

    public Ken(KickBehaviour kickBehaviour, JumpBehaviour jumpBehaviour) {
        super(kickBehaviour,jumpBehaviour);
    }
    @Override
    public void display() {
        System.out.println("ken");
    }
}
