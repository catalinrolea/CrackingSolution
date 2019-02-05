package DesignPatterns.type_of_patterns.adapter;

public class Vrabie implements Bird {
    @Override
    public void fly() {
        System.out.println("Vrabie fly");
    }

    @Override
    public void makeSound() {
        System.out.println("Vrabie make sound");
    }
}
