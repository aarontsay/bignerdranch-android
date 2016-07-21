package com.aarontsay.android.indecisive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DecisionHome extends AppCompatActivity {

    public static String EXTRA_NUMBEROFOPTIONS = "com.aarontsay.android.indecisive.NUMBEROFOPTIONS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decision_home);
    }

    // Called when user clicks the Go! button
    public void createChoicesBasedOnNumberOfChoices(View view) {
        Intent intent = new Intent(this, ChoiceHandler.class);
        EditText editText = (EditText) findViewById(R.id.start_decision_edit_number_of_options);
        int numberOfOptions = Integer.parseInt(editText.getText().toString());
        intent.putExtra(EXTRA_NUMBEROFOPTIONS, numberOfOptions);
        startActivity(intent);
    }
}
