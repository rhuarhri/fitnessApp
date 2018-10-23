package com.example.rhuarhri.fitnessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class choiceActivity extends AppCompatActivity {

    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        start = (Button) findViewById(R.id.StartBTN);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToNextScreen();
            }
        });
    }

    void ToNextScreen()
    {
        Intent toScreen = new Intent(this, instructionActivity.class);

        startActivity(toScreen);
    }
}
