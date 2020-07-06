package com.hugo.stackoverflowclient.mvc.screens.questionslist;

import android.view.View;

import com.hugo.stackoverflowclient.mvc.questions.Question;

public interface QuestionsListItemViewMvc {

    public interface Listener {
        void onQuestionClicked(Question question);
    }

    View getRootView();
    void registerListener(Listener listener);
    void unregisterListener(Listener listener);
    void bindQuestion(Question question);
}
