package com.topquiz;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    private TextView mQuestionText;
    private Button mAnswer1Btn;
    private Button mAnswer2Btn;
    private Button mAnswer3Btn;
    private Button mAnswer4Btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mQuestionText = findViewById(R.id.activity_game_question);
        mAnswer1Btn = findViewById(R.id.activity_game_answer1);
        mAnswer2Btn = findViewById(R.id.activity_game_answer2);
        mAnswer3Btn = findViewById(R.id.activity_game_answer3);
        mAnswer4Btn = findViewById(R.id.activity_game_answer4);


    }
}