package DesignPatterns.type_of_patterns.strategy;

public class Ryu extends Fighter {

    public Ryu(KickBehaviour kickBehaviour, JumpBehaviour jumpBehaviour) {
         super(kickBehaviour,jumpBehaviour);
    }
    @Override
    public void display() {
        System.out.println("This is Ryu");
    }
}
