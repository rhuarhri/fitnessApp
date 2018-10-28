package com.example.rhuarhri.fitnessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button saveBTN;
    Button statsBTN;
    Button startBTN;
    EditText WeightET;

    UWDBController wdbController;


    int test = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            wdbController = new UWDBController(getApplicationContext());
        }
        catch(Exception e)
        {
            Toast.makeText(getApplicationContext(), "controller error", Toast.LENGTH_LONG);
        }

        saveBTN = (Button) findViewById(R.id.saveWeightBTN);
        statsBTN = (Button) findViewById(R.id.statsBTN);
        startBTN = (Button) findViewById(R.id.startBTN);

        WeightET = (EditText) findViewById(R.id.weightET);

        saveBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double weight = Double.parseDouble(WeightET.getText().toString());

                //wdbController.addWeight(weight);
                test = 1;
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

    private void toStatsScreen() {
        Intent toStats = new Intent(this, overAllStatsActivity.class);

        startActivity(toStats);
    }

    private void toChooseExerciseScreen() {
        Intent toChoose = new Intent(this, choiceActivity.class);

        startActivity(toChoose);


    }


    int exmapleFunction() {
        int testValue = 0;

        for (int i = 0; i < 10; i++) {
            testValue++;
        }

        return testValue;

    }

    boolean exampleFunction2(int number) {
        int i = 0;

        if (i == number) {
            return true;
        } else {
            return false;}

    }


}


