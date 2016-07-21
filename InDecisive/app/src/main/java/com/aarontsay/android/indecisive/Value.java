package com.aarontsay.android.indecisive;

/**
 * Created by aaron on 7/20/16.
 */
public class Value {
    private String name;
    private int weight;
    private int decisionScore;
    private int totalPoints;

    public Value(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public int getDecisionScore() {
        return decisionScore;
    }

    public void setDecisionScore(int decisionScore) {
        this.decisionScore = decisionScore;
    }
}
