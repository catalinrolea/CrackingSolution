package DesignPatterns.type_of_patterns.observer;

public class AverageScoreDisplay implements Observer {

    private float runRate;
    private int predictedScore;


    public void update(int runs, int wrickets, float overs) {
        this.runRate = (float) runs/overs;
        this.predictedScore = (int) (this.runRate * 50);
        display();
    }

    public void display(){
        System.out.println("\nAverage Score Display: \n"
                + "Run Rate: " + runRate +
                "\nPredictedScore: " +
                predictedScore);
    }
}
