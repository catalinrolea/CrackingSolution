package DesignPatterns.type_of_patterns.strategy;

public class JumpLong implements JumpBehaviour {
    @Override
    public void jump() {
        System.out.println("Jump long");
    }
}
