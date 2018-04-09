package com.example.jhuang.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Button submit;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit = (Button) findViewById(R.id.submitButton);
        submit.setOnClickListener(submitButtonOnClickListener);
    }

    private void resetCounterCorrectAnswers(){
        score = 0;
    }

    private void checkQuestionOneAnswer(){
        RadioButton radioButtonAnswer = (RadioButton) findViewById(R.id.radio_george_washington);
        if (radioButtonAnswer.isChecked()){
            score += 1;
        }
    }

    private void checkQuestionTwoAnswer(){
        EditText userAnswer = (EditText) findViewById(R.id.question_2_edit_text);
        if (Integer.parseInt(String.valueOf(userAnswer.getText())) == 1870){
            score += 1;
        }
    }

    private void checkQuestionThreeAnswer(){
        CheckBox questionThreeOptionOne = (CheckBox) findViewById(R.id.question_3_option_one);
        CheckBox questionThreeOptionTwo = (CheckBox) findViewById(R.id.question_3_option_two);
        CheckBox questionThreeOptionThree = (CheckBox) findViewById(R.id.question_3_option_three);
        if (questionThreeOptionOne.isChecked() && questionThreeOptionTwo.isChecked() && questionThreeOptionThree.isChecked()){
            score += 1;
        }
    }
    private void checkQuestionFourAnswer(){
        RadioButton radioButtonAnswer = (RadioButton) findViewById(R.id.radio_boston);
        if (radioButtonAnswer.isChecked()){
            score += 1;
        }
    }
    private void checkQuestionFiveAnswer(){
        RadioButton radioButtonAnswer = (RadioButton) findViewById(R.id.radio_roosevelt);
        if (radioButtonAnswer.isChecked()){
            score += 1;
        }
    }

    private void checkAllQuestions(){
        checkQuestionOneAnswer();
        checkQuestionTwoAnswer();
        checkQuestionThreeAnswer();
        checkQuestionFourAnswer();
        checkQuestionFiveAnswer();
    }

    final View.OnClickListener submitButtonOnClickListener = new View.OnClickListener() {
        public void onClick(final View v){
            checkAllQuestions();
            Toast.makeText(MainActivity.this, "Correct Answers: " + score + "/5",
                    Toast.LENGTH_LONG).show();
            resetCounterCorrectAnswers();
        }
    };
}
