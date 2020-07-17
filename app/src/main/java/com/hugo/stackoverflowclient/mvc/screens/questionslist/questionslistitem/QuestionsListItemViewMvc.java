package com.hugo.stackoverflowclient.mvc.screens.questionslist.questionslistitem;

import com.hugo.stackoverflowclient.mvc.questions.Question;
import com.hugo.stackoverflowclient.mvc.screens.common.views.ObservableViewMvc;

public interface QuestionsListItemViewMvc
        extends ObservableViewMvc<QuestionsListItemViewMvc.Listener> {

    public interface Listener {
        void onQuestionClicked(Question question);
    }

    void bindQuestion(Question question);
}
