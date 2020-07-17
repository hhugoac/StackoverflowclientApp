package com.hugo.stackoverflowclient.mvc.screens.questionslist;

import android.view.View;

import com.hugo.stackoverflowclient.mvc.questions.Question;
import com.hugo.stackoverflowclient.mvc.screens.common.ObservableViewMvc;
import com.hugo.stackoverflowclient.mvc.screens.common.ViewMvc;

public interface QuestionsListItemViewMvc
        extends ObservableViewMvc<QuestionsListItemViewMvc.Listener> {

    public interface Listener {
        void onQuestionClicked(Question question);
    }

    void bindQuestion(Question question);
}
