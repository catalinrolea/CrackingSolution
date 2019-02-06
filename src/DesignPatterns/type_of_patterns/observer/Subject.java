package DesignPatterns.type_of_patterns.observer;

public interface Subject {
    public void registerObserver(Observer o);
    public void unregisterObserver(Observer o);
   public void notifyObserver();

}
