package com.example.rhuarhri.fitnessapp;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button saveBTN;
    Button statsBTN;
    Button startBTN;
    EditText WeightET;

    UWDBController wdbController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wdbController = new UWDBController(getApplicationContext());

        saveBTN = (Button) findViewById(R.id.saveWeightBTN);
        statsBTN = (Button) findViewById(R.id.statsBTN);
        startBTN = (Button) findViewById(R.id.startBTN);

        WeightET = (EditText) findViewById(R.id.weightET);

        saveBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double weight = Double.parseDouble( WeightET.getText().toString());

                wdbController.addWeight(weight);
            }
        });

        statsBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toStatsScreen();
            }
        });

        startBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toChooseExerciseScreen();
            }
        });
    }

    private void toStatsScreen()
    {
        Intent toStats = new Intent(this, overAllStatsActivity.class);

        startActivity(toStats);
    }

    private void toChooseExerciseScreen()
    {
        Intent toChoose = new Intent(this, choiceActivity.class);

        startActivity(toChoose);


    }
}


