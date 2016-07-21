package com.aarontsay.android.indecisive;

/**
 * Created by aaron on 7/19/16.
 */
public class Decision {

    private String name;
    private Choice[] choiceArr;
    private int choiceArrSize;
    private Value[] valueArr;
    private int valueArrSize;

    public void Decision(String name) {
        this.name = name;
        choiceArr = new Choice[10];
        valueArr = new Value[20];
    }

    // adds a new Option to optionArr
    public void addOption(Choice c) {
        choiceArr[choiceArrSize] = c;
        choiceArrSize++;
    }

    // adds a new Value to valueArr
    public void addValue(Value v) {
        valueArr[valueArrSize] = v;
        valueArrSize++;
    }
}
