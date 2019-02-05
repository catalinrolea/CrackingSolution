package DesignPatterns.type_of_patterns.adapter;

import org.junit.Test;

public class Main {

    @Test
    public void testAdapterPattern()    {
        Vrabie vrabie = new Vrabie();
        PlasticToyDuck plasticToyDuck = new PlasticToyDuck();
        ToyDuck birdAdapter = new BirdAdapter(vrabie);

        vrabie.fly();
        vrabie.makeSound();


        plasticToyDuck.square();
        System.out.println("Bird who make like square-->");
        birdAdapter.square();
    }
}
