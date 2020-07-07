package com.hugo.stackoverflowclient.mvc.screens.questionslist;

import android.view.View;

import com.hugo.stackoverflowclient.mvc.questions.Question;
import com.hugo.stackoverflowclient.mvc.screens.common.ViewMvc;

import java.util.List;

interface QuestionsLisViewMvc extends ViewMvc {

    public interface Listener {
        void onQuestionClicked(Question question);
    }

    void registerListener(Listener listener);

    void unregisterListener(Listener listener);

    void onQuestionClicked(Question question);

    void bindQuestions(List<Question> questions);
}
