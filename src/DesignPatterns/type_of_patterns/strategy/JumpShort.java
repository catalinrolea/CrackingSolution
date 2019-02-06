package DesignPatterns.type_of_patterns.strategy;

public class JumpShort implements JumpBehaviour {
    @Override
    public void jump() {
        System.out.println("Short jump");
    }
}
