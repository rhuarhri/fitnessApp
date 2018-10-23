package com.example.rhuarhri.fitnessapp;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class instructionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);

        //30 second count down
        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                toExerciseScreen();
            }
        }.start();
    }

    void toExerciseScreen()
    {
        Intent toScreen = new Intent(this, exerciseActivity.class);

        startActivity(toScreen);
    }
}
