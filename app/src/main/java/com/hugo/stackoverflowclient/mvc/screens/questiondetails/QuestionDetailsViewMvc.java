package com.hugo.stackoverflowclient.mvc.screens.questiondetails;

import com.hugo.stackoverflowclient.mvc.questions.QuestionDetails;
import com.hugo.stackoverflowclient.mvc.screens.common.views.ObservableViewMvc;
import com.hugo.stackoverflowclient.mvc.screens.common.views.ViewMvc;

public interface QuestionDetailsViewMvc extends ObservableViewMvc<QuestionDetailsViewMvc.Listener> {

    public interface Listener {
        void onNavigateUpClicked();
    }

    void bindQuestion(QuestionDetails question);

    void showProgressIndication();

    void hideProgressIndication();

}
