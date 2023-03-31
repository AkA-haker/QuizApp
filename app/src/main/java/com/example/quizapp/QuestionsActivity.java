package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.color.utilities.Score;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class QuestionsActivity extends AppCompatActivity {
    private TextView displayName, score, questions;
    private RadioButton option1Btn, option2Btn, option3Btn, option4Btn;
    private RadioGroup allBtn;
    private Button nextQuestionButton, quitButton;
    private ArrayList<QuestionLayout> questionList;
    private int currentScore = 0, currentPos = 0, questionCount = 0;
    String getName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        //-------------For Displaying the Name throughout the app------------
        displayName = findViewById(R.id.text_view_name);
        getName = getIntent().getExtras().getString("name");
        displayName.setText(getName);
        //--------------------------------------------------------------------
        questions = findViewById(R.id.text_view_Question);
        score = findViewById(R.id.text_view_score);
        allBtn=findViewById(R.id.radio_group_questions);
        option1Btn = findViewById(R.id.radio_button_op1);
        option2Btn = findViewById(R.id.radio_button_op2);
        option3Btn = findViewById(R.id.radio_button_op3);
        option4Btn = findViewById(R.id.radio_button_op4);
        nextQuestionButton = findViewById(R.id.button_next_question);
        quitButton = findViewById(R.id.button_quit);
        questionList = new ArrayList<>();
        getQuestions(questionList);
        setDataToView(currentPos);

        nextQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (option1Btn.isChecked()) {
                    if (questionList.get(currentPos).getAns().trim().equals(option1Btn.getText().toString().trim())) {
                        Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                        currentScore++;
                    } else {
                        Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                    }

                }
                if (option2Btn.isChecked()) {
                    if (questionList.get(currentPos).getAns().trim().equals(option2Btn.getText().toString().trim())) {
                        Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                        currentScore++;
                    } else {
                        Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                    }

                }
                if (option3Btn.isChecked()) {

                    if (questionList.get(currentPos).getAns().trim().equals(option3Btn.getText().toString().trim())) {
                        Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                        currentScore++;
                    } else {
                        Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                    }

                }
                if (option4Btn.isChecked()) {
                    if (questionList.get(currentPos).getAns().trim().equals(option4Btn.getText().toString().trim())) {
                        Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                        currentScore++;
                    } else {
                        Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                    }

                }
                questionCount++;
                currentPos++;
                allBtn.clearCheck();
                setDataToView(currentPos);
            }
        });

        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showResult();
            }
        });
    }

    private void showResult() {
        //For converting Correct score and Wrong score from int to String------------
        int wrongAnsScore = 5 - currentScore;
        String convertCorrectToString = Integer.toString(currentScore);
        String convertWrongToString = Integer.toString(wrongAnsScore);
        //-----------------------------------------------------------------------

        Intent intent = new Intent(QuestionsActivity.this, ScoreActivity.class);
        intent.putExtra("CorrectScore", convertCorrectToString);
        intent.putExtra("WrongScore", convertWrongToString);
        startActivity(intent);

    }

    private void setDataToView(int currentPos) {
        score.setText("" + currentScore);
        if (questionCount == 5) {
            showResult();
        } else {
            questions.setText(questionList.get(currentPos).getQuestion());
            option1Btn.setText(questionList.get(currentPos).getOp1());
            option2Btn.setText(questionList.get(currentPos).getOp2());
            option3Btn.setText(questionList.get(currentPos).getOp3());
            option4Btn.setText(questionList.get(currentPos).getOp4());
        }
    }


    private void getQuestions(ArrayList<QuestionLayout> questionList) {// For getting the questions
        questionList.add(new QuestionLayout("Q1.Which method can be defined only once in a program?", "finalize method", "main method", "static method", "private method", "main method"));
        questionList.add(new QuestionLayout("Q2.Which keyword is used by method to refer to the current object that invoked it?", "import", "this", "catch", "abstract", "this"));
        questionList.add(new QuestionLayout("Q3.Which of these access specifiers can be used for an interface?", "public", "protected", "private", "All of the mentioned", "public"));
        questionList.add(new QuestionLayout("Q4.Which of the following is correct way of importing an entire package ‘pkg’?", "Import pkg.", "import pkg.*", "Import pkg.*", "import pkg.", "import pkg.*"));
        questionList.add(new QuestionLayout("Q5.What is the return type of Constructors?", "int", "float", "void", "None of the mentioned", "None of the mentioned"));
    }
}