package com.aarontsay.android.indecisive;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ChoiceHandler extends AppCompatActivity {

    private int choiceNumber;
    private Choice[] choiceArr;
    private int numOfChoices;

    private Button choiceNameNextButton;


    public void updateChoiceButton() {
        String choiceNameNextTextButtonView = "Next Choice";
        String choiceNameDoneTextButtonView = "Done";

        if(choiceNumber == numOfChoices && choiceArr[numOfChoices - 1] != null) {
            choiceNameNextButton.setText(choiceNameDoneTextButtonView);
        } else {
            choiceNameNextButton.setText(choiceNameNextTextButtonView);
        }
        choiceNumber++;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_handler);

        Intent intent = getIntent();
        numOfChoices = intent.getIntExtra(DecisionHome.EXTRA_NUMBEROFOPTIONS, 0);

        // shows on activity_choice_handler.xml as 'Choice ChoiceNumber'
        choiceNumber = 1;

        TextView choiceNumberTextView;
        choiceNumberTextView = (TextView) findViewById(R.id.choice_n_view);

        // this app will not deal with locale-specific digits nor fractions
        choiceNumberTextView.setText(Integer.toString(choiceNumber));

        // a Choice[] has a min of 2 and a max of 10
        choiceArr = new Choice[10];
        EditText editText = (EditText) findViewById(R.id.choice_title_input);
        String choiceName = editText.getText().toString();
        choiceArr[choiceNumber - 1] = new Choice(choiceName);

        choiceNameNextButton = (Button) findViewById(R.id.choice_name_next);
        updateChoiceButton();
    }

    // if choiceNumber == numOfChoices, then call next activity.
    // Otherwise add current Choice to choiceArr and ask for another Choice
    public void addChoiceOrMoveOnToValues() {
        if (choiceNumber == numOfChoices && choiceArr[choiceNumber - 1] != null) {
            // TODO
            // add choiceArr to Intent
            // add decisionName to Intent
            // startActivity(intent, ValuesHandler)
        } else {
            // TODO
            // add choice to choiceArr
            // increment choiceNumber
            // reset EditText
        }


    }
}
