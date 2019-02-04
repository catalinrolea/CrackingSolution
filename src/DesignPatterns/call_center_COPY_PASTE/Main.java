package DesignPatterns.call_center_COPY_PASTE;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        CallManager manager = new CallManager();

        manager.addRespondant(new Employee("R1", manager));
        manager.addRespondant(new Employee("R2", manager));
        manager.addRespondant(new Employee("R3", manager));

        manager.addManager(new Employee("M1", manager));
        manager.addManager(new Employee("M2", manager));
        manager.addManager(new Employee("M3", manager));

        manager.addDirector(new Employee("D1", manager));
        manager.addDirector(new Employee("D2", manager));

        Caller foo = new Caller("foo");

        manager.dispatch(foo); // should be R1
        manager.dispatch(new Call()); // should be R2
        manager.dispatch(new Call()); // should be R3
        manager.dispatch(new Call()); // should be M1
        manager.dispatch(new Call()); // M2


    }
}

