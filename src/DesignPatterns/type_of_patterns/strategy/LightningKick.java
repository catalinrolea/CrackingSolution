package DesignPatterns.type_of_patterns.strategy;

public class LightningKick implements KickBehaviour {
    @Override
    public void kick() {
        System.out.println("Lightning kick");
    }
}
