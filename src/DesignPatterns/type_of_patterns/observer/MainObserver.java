package DesignPatterns.type_of_patterns.observer;

import org.junit.Test;

public class MainObserver {

    @Test
    public void testObserver() {

        AverageScoreDisplay averageScoreDisplay = new AverageScoreDisplay();
        CricketData cricketData = new CricketData();
        cricketData.registerObserver(averageScoreDisplay);
        cricketData.dataChanged();
        System.out.println("-------------------");
        //cricketData.unregisterObserver(averageScoreDisplay);
        cricketData.dataChanged();
    }
}
