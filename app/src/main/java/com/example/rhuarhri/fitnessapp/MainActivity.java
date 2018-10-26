package com.example.rhuarhri.fitnessapp;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button saveBTN;
    EditText WeightET;

    UWDBController wdbController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wdbController = new UWDBController(getApplicationContext());

        saveBTN = (Button) findViewById(R.id.saveWeightBTN);

        WeightET = (EditText) findViewById(R.id.weightET);
        saveBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
