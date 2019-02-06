package DesignPatterns.type_of_patterns.observer;

import java.util.ArrayList;
import java.util.Iterator;

public class CricketData implements Subject {

    int runs;
    int wrickets;
    float overs;
    ArrayList<Observer> observerList;

    public CricketData() {
        observerList = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observerList.add(o);
    }

    @Override
    public void unregisterObserver(Observer o) {
        observerList.remove(o);
    }

    @Override
    public void notifyObserver() {
        for (Iterator<Observer> it  = observerList.iterator(); it.hasNext();) {
          Observer o = it.next();
          o.update(runs,wrickets,overs);
        }
    }

    public int getRuns() {
        return 90;
    }

    public int getWrickets() {
        return 2;
    }

    public float getOvers() {
        return (float)5.2;
    }
    public void dataChanged()   {
        runs = getRuns();
        wrickets = getWrickets();
        overs = getOvers();

        notifyObserver();
    }
}
