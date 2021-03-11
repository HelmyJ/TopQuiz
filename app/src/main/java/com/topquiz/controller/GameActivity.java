package com.topquiz.controller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.topquiz.R;
import com.topquiz.model.BankQuestion;
import com.topquiz.model.Question;

import java.util.Arrays;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mQuestionText;
    private Button mAnswer1Btn;
    private Button mAnswer2Btn;
    private Button mAnswer3Btn;
    private Button mAnswer4Btn;
    private Question mCurrentQuestion;
    private BankQuestion mBankQuestion;
    private int mScore;
    private int mNumberOfQuestions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        this.generateQuestion();

        mQuestionText = findViewById(R.id.activity_game_question);
        mAnswer1Btn = findViewById(R.id.activity_game_answer1);
        mAnswer2Btn = findViewById(R.id.activity_game_answer2);
        mAnswer3Btn = findViewById(R.id.activity_game_answer3);
        mAnswer4Btn = findViewById(R.id.activity_game_answer4);

        mAnswer1Btn.setOnClickListener(this);
        mAnswer2Btn.setOnClickListener(this);
        mAnswer3Btn.setOnClickListener(this);
        mAnswer4Btn.setOnClickListener(this);

        //Use tag property to 'name' buttons
        mAnswer1Btn.setTag(0);
        mAnswer2Btn.setTag(1);
        mAnswer3Btn.setTag(2);
        mAnswer4Btn.setTag(3);

        mCurrentQuestion = mBankQuestion.getQuestion();

        mScore = 0;
        mNumberOfQuestions = 2;



        this.displayQuestion(mCurrentQuestion);
    }

    private void displayQuestion(final Question question){
        mQuestionText.setText(question.getQuestion());
        mAnswer1Btn.setText(question.getChoiceList().get(0));
        mAnswer2Btn.setText(question.getChoiceList().get(1));
        mAnswer3Btn.setText(question.getChoiceList().get(2));
        mAnswer4Btn.setText(question.getChoiceList().get(3));

    }

    private BankQuestion generateQuestion(){
        Question question1 = new Question("What is the name of the current French President?",
                Arrays.asList("Emmanuel Macron",
                        "François Hollande",
                        "Nicolas Sarkozy",
                        "Alain Delon"),
                0);

        Question question2 = new Question("Which NBA player has the most titles in history?",
                Arrays.asList("Michael Jordan",
                        "Larry Bird",
                        "Bill Russel",
                        "Kobe Bryant"),
                2);

        Question question3 = new Question("When did begin the First World War?",
                Arrays.asList("1913",
                        "1914",
                        "1915",
                        "1916"),
                1);

        return new BankQuestion(Arrays.asList(question1, question2, question3));
    }

    @Override
    public void onClick(View v) {
        int responseIndex = (int) v.getTag();
        if (responseIndex == mCurrentQuestion.getAnswerIndex()){
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
            mScore++;
        } else {
            Toast.makeText(this, "Wrong answer!", Toast.LENGTH_SHORT).show();
        }

        if (mNumberOfQuestions == 0){
            endGame();
        } else {
            mNumberOfQuestions--;
            mCurrentQuestion = mBankQuestion.getQuestion();
            displayQuestion(mCurrentQuestion);
        }
    }

    private void endGame(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Well done!")
                .setMessage("Your score is "+ mScore)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .create()
                .show();
    }
}