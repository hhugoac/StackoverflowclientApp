package com.hugo.stackoverflowclient.mvc.screens.questiondetails;

import com.hugo.stackoverflowclient.mvc.questions.QuestionDetails;
import com.hugo.stackoverflowclient.mvc.screens.common.views.ViewMvc;

public interface QuestionDetailsViewMvc extends ViewMvc {

    void bindQuestion(QuestionDetails question);

    void showProgressIndication();

    void hideProgressIndication();

}
