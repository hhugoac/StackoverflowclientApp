package com.hugo.stackoverflowclient.mvc.screens.questionslist;

import android.view.View;

import com.hugo.stackoverflowclient.mvc.questions.Question;

import java.util.List;

interface QuestionsLisViewMvc {

    public interface Listener {
        void onQuestionClicked(Question question);
    }

    void registerListener(Listener listener);

    void unregisterListener(Listener listener);

    View getRootView();

    void onQuestionClicked(Question question);

    void bindQuestions(List<Question> questions);
}
