package com.example.rhuarhri.fitnessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class startUpActivity extends AppCompatActivity {

    Button connectBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_up);

        connectBTN = (Button) findViewById(R.id.connectBTN);

        connectBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toMainMenu();
            }
        });
    }


    void toMainMenu()
    {
        Intent toMenu = new Intent(this, MainActivity.class);

        startActivity(toMenu);
    }
}
