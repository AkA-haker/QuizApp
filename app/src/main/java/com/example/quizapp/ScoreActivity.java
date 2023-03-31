package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {
    TextView correctRes, wrongRes, finalRes;
    Button restart;
    String getCorrectScore, getWrongScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        correctRes = findViewById(R.id.text_view_result_score);
        wrongRes = findViewById(R.id.text_view_wrong_score);
        finalRes = findViewById(R.id.text_view_final_score);
        restart = findViewById(R.id.button_restart);
        //--------------------For setting the values in the screen-----------------------
        Intent intent = getIntent();
        getCorrectScore = intent.getStringExtra("CorrectScore");
        getWrongScore = intent.getStringExtra("WrongScore");
        correctRes.setText(getCorrectScore);
        wrongRes.setText(getWrongScore);
        finalRes.setText(getCorrectScore);
        //------------------------------------------------------------------------------

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });


    }
}