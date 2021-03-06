package DesignPatterns.type_of_patterns.singleton;

public class SingleObject {
    private static SingleObject instance = new SingleObject();
    private SingleObject()  {

    }
    public static SingleObject getInstance()    {
        return instance;
    }
    public void showMsg()   {
        System.out.println("Acces to Singleton class");
    }
}
