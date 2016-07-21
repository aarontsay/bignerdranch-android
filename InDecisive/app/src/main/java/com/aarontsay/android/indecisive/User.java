package com.aarontsay.android.indecisive;

/**
 * Created by aaron on 7/19/16.
 */
public class User {

    private int id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private int numOfDecisions;
    private Decision[] pastDecisionsArr;

    public User(String email, String firstName, String lastName, String password) {

        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;

        numOfDecisions = 0;
        pastDecisionsArr = new Decision[1];

    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNumOfDecisions() {
        return numOfDecisions;
    }

    public void setNumOfDecisions(int numOfDecisions) {
        this.numOfDecisions = numOfDecisions;
    }

    public Decision[] getPastDecisionsArr() {
        return pastDecisionsArr;
    }

    public void setPastDecisionsArr(Decision[] pastDecisionsArr) {
        this.pastDecisionsArr = pastDecisionsArr;
    }
}
