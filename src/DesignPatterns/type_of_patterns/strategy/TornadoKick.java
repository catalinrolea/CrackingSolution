package DesignPatterns.type_of_patterns.strategy;

public class TornadoKick implements KickBehaviour {
    @Override
    public void kick() {
        System.out.println("Tornado kick");
    }
}
