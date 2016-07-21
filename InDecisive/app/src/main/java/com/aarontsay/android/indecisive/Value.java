package com.aarontsay.android.indecisive;

/**
 * Created by aaron on 7/20/16.
 */
public class Value {
    private String name;
    private int weight;

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
}
