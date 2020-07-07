package com.hugo.stackoverflowclient.mvc.screens.questionslist;

import android.view.View;

import com.hugo.stackoverflowclient.mvc.questions.Question;
import com.hugo.stackoverflowclient.mvc.screens.common.ViewMvc;

public interface QuestionsListItemViewMvc extends ViewMvc {

    public interface Listener {
        void onQuestionClicked(Question question);
    }


    void registerListener(Listener listener);
    void unregisterListener(Listener listener);
    void bindQuestion(Question question);
}
