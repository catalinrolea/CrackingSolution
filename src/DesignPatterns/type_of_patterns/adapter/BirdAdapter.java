package DesignPatterns.type_of_patterns.adapter;

public class BirdAdapter implements ToyDuck{
    Bird bird;
    public BirdAdapter(Bird bird) {
        this.bird = bird;
    }

    @Override
    public void square() {
        bird.makeSound();
    }
}
