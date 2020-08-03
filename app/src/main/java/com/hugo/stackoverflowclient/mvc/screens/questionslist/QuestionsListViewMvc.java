package com.hugo.stackoverflowclient.mvc.screens.questionslist;

import com.hugo.stackoverflowclient.mvc.questions.Question;
import com.hugo.stackoverflowclient.mvc.screens.common.navdrawer.NavigationDrawerViewMvc;
import com.hugo.stackoverflowclient.mvc.screens.common.views.ObservableViewMvc;

import java.util.List;

public interface QuestionsListViewMvc extends ObservableViewMvc<QuestionsListViewMvc.Listener>, NavigationDrawerViewMvc {

    public interface Listener {
        void onQuestionClicked(Question question);

        void onQuestionsClicked();
    }

    void bindQuestions(List<Question> questions);

    void showProgressIndication();

    void hideProgressIndication();
}
