package DesignPatterns.type_of_patterns.strategy;

import org.junit.Test;

public class MainStreetFighter {

    @Test
    public void mainStreetFighter() {
        KickBehaviour kickBehaviour = new TornadoKick();
        JumpBehaviour shortJump = new JumpShort();
        JumpBehaviour longJump = new JumpLong();


        Fighter ken = new Ken(kickBehaviour, longJump);
        System.out.println("*** Capibilities of fighter: ***");
        ken.display();
        ken.punch();
        ken.roll();
        ken.jump();

        System.out.println("*** Change state for ken ***");
        ken.setJumpBehaviour(shortJump);
        ken.jump();
    }
}
