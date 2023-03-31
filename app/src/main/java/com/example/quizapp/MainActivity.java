package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button startButton;
    public EditText enterName;
    private Button aboutButton;
    public String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enterName = findViewById(R.id.edit_text_enter_your_name);
        startButton = findViewById(R.id.button_start);
        aboutButton = findViewById(R.id.button_about);



        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=enterName.getText().toString().trim();
                if(name.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"First Enter Your Name to Start a Quiz",Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent=new Intent(MainActivity.this,QuestionsActivity.class);
                    intent.putExtra("name",name);
                    startActivity(intent);
                }
            }
        });

        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aboutIntent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(aboutIntent);
            }
        });
    }


}