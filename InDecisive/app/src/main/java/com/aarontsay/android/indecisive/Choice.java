package com.aarontsay.android.indecisive;

/**
 * Created by aaron on 7/20/16.
 */
public class Choice {

    private String name;
    private int score;

    public Choice(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
