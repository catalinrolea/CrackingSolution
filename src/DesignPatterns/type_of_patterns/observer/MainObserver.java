package DesignPatterns.type_of_patterns.observer;

import org.junit.Test;

public class MainObserver {

    @Test
    public void testObserver() {

        AverageScoreDisplay averageScoreDisplay = new AverageScoreDisplay();
        CricketData cricketData = new CricketData();
        cricketData.registerObserver(averageScoreDisplay);
        cricketData.dataChanged();
        averageScoreDisplay.update(100,200,300);
        cricketData.registerObserver(averageScoreDisplay);
        System.out.println("-------------------");
       // cricketData.unregisterObserver(averageScoreDisplay);
       // cricketData.dataChanged();
    }
}
