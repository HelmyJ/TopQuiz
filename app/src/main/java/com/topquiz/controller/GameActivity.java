package com.topquiz.controller;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.topquiz.R;
import com.topquiz.model.BankQuestion;
import com.topquiz.model.Question;

import java.util.Arrays;

public class GameActivity extends AppCompatActivity {

    private TextView mQuestionText;
    private Button mAnswer1Btn;
    private Button mAnswer2Btn;
    private Button mAnswer3Btn;
    private Button mAnswer4Btn;
    private Question mCurrentQuestion;
    private BankQuestion mBankQuestion;


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

        //Use tag property to 'name' buttons
        mAnswer1Btn.setTag(0);
        mAnswer2Btn.setTag(1);
        mAnswer3Btn.setTag(2);
        mAnswer4Btn.setTag(3);

        mCurrentQuestion = mBankQuestion.getQuestion();

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

}