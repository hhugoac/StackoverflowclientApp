package com.hugo.stackoverflowclient.mvc.screens.questionslist;

import com.hugo.stackoverflowclient.mvc.questions.Question;
import com.hugo.stackoverflowclient.mvc.screens.common.ObservableViewMvc;

import java.util.List;

interface QuestionsListViewMvc extends ObservableViewMvc<QuestionsListViewMvc.Listener> {

    public interface Listener {
        void onQuestionClicked(Question question);
    }

    void bindQuestions(List<Question> questions);
}
