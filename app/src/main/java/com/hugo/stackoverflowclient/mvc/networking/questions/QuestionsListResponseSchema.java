package com.hugo.stackoverflowclient.mvc.networking.questions;

import com.google.gson.annotations.SerializedName;
import com.hugo.stackoverflowclient.mvc.networking.questions.QuestionSchema;

import java.util.List;

public class QuestionsListResponseSchema {

    @SerializedName("items")
    private final List<QuestionSchema> mQuestions;

    public QuestionsListResponseSchema(List<QuestionSchema> questions) {
        mQuestions = questions;
    }

    public List<QuestionSchema> getQuestions() {
        return mQuestions;
    }
}
