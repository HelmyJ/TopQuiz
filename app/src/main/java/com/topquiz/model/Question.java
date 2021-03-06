package com.topquiz.model;

import java.util.List;

/**
 * Created by Helmy JEDDI
 */

public class Question {
    private String mQuestion;
    private List<String> mChoiceList;
    private int mAnswerIndex;

    public String getQuestion() {
        return mQuestion;
    }

    public List<String> getChoiceList() {
        return mChoiceList;
    }

    public int getAnswerIndex() {
        return mAnswerIndex;
    }

    public Question(String question, List<String> choiceList, int answerIndex) {
        mQuestion = question;
        mChoiceList = choiceList;
        mAnswerIndex = answerIndex;
    }
}
