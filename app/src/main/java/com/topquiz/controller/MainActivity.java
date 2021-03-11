package com.topquiz.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.topquiz.R;
import com.topquiz.model.BankQuestion;
import com.topquiz.model.Question;
import com.topquiz.model.User;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private TextView mGreetingText;
    private EditText mNameInput;
    private Button mPlayButton;
    private User mUser;
    private BankQuestion mBankQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGreetingText = findViewById(R.id.activity_main_greeting_txt);
        mNameInput = findViewById(R.id.activity_main_name_input);
        mPlayButton = findViewById(R.id.activity_main_play_btn);
        mUser = new User();

        //Create questions
        Question question1 = new Question("Who is the creator of Android?",
                Arrays.asList("Andy Rubin",
                        "Steve Wozniak",
                        "Jake Wharton",
                        "Paul Smith"),
                0);

        Question question2 = new Question("When did the first man land on the moon?",
                Arrays.asList("1958",
                        "1962",
                        "1967",
                        "1969"),
                3);

        Question question3 = new Question("What is the house number of The Simpsons?",
                Arrays.asList("42",
                        "101",
                        "666",
                        "742"),
                3);

        mBankQuestion = new BankQuestion(Arrays.asList(question1, question2, question3));

        mPlayButton.setEnabled(false);

        mNameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPlayButton.setEnabled(s.toString().length() != 0);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = mNameInput.getText().toString();
                mUser.setFirstName(firstName);
                Intent gameActivityIntent = new Intent(MainActivity.this, GameActivity.class);
                startActivity(gameActivityIntent);
            }
        });
    }
}