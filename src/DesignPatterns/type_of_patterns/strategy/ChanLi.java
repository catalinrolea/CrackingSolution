package DesignPatterns.type_of_patterns.strategy;

public class ChanLi extends Fighter {

    public ChanLi(KickBehaviour kickBehaviour, JumpBehaviour jumpBehaviour) {
        super(kickBehaviour,jumpBehaviour);
    }
    @Override
    public void display() {
        System.out.println("Chan Li");
    }
}
