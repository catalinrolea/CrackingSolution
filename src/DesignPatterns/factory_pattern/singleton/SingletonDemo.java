package DesignPatterns.factory_pattern.singleton;

import org.junit.Test;

public class SingletonDemo {

    @Test
    public void testSingleton()    {
        //case 1
        //SingleObject obj = new SingleObject(); -- ERROR->constructor not visible
        SingleObject obj  = SingleObject.getInstance();
        SingleObject obj2  = SingleObject.getInstance(); //the same object
        obj.showMsg();

    }
}
