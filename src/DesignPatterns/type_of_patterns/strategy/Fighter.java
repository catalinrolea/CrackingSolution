package DesignPatterns.type_of_patterns.strategy;

public abstract class Fighter {

    KickBehaviour kickBehaviour;
    JumpBehaviour jumpBehaviour;
    public Fighter(KickBehaviour kickBehaviour, JumpBehaviour jumpBehaviour) {
        this.kickBehaviour = kickBehaviour;
        this.jumpBehaviour = jumpBehaviour;
    }

     public void punch(){
        System.out.println("punch");
     }
     public void roll() {
         System.out.println("roll");
     }

     public void jump() {
        jumpBehaviour.jump();
     }

     public void kick() {
        kickBehaviour.kick();
     }

     public void setKickBehaviour(KickBehaviour kickBehaviour) {
        this.kickBehaviour = kickBehaviour;
     }
     public void setJumpBehaviour(JumpBehaviour jumpBehaviour) {
        this.jumpBehaviour = jumpBehaviour;
     }
     public abstract void display();


}
