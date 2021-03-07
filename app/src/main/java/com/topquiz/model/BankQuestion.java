package com.topquiz.model;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by Helmy JEDDI
 */

public class BankQuestion {
    private List<Question> mListeQuestions;
    private int mNextQuestionIndex;

    public BankQuestion(List<Question> questionList){}

    //Shuffle the list before each game
    public void ShuffleBankQuestion(){
        Collections.shuffle(mListeQuestions);
        mNextQuestionIndex = 0;
    }

    public Question getQuestion(){
        if (mNextQuestionIndex == mListeQuestions.size()){
            mNextQuestionIndex = 0;
        }
        return mListeQuestions.get(mNextQuestionIndex++);
    }




}
