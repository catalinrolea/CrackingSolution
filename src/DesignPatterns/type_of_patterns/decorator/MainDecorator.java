package DesignPatterns.type_of_patterns.decorator;

import org.junit.Test;

public class MainDecorator {

    public static void main(String[] args)  {
        Pizza margherita = new Margherita();
        Pizza farmHouse = new FarmHouse();

        farmHouse = new FreshTomato(farmHouse);
        System.out.println("Pizza: "+farmHouse.getDescription() + " -->cost " + farmHouse.getCost());

        margherita = new Barbequeue(margherita);
        System.out.println("Pizza: "+margherita.getDescription() + " -->cost" + margherita.getCost());

    }

}
