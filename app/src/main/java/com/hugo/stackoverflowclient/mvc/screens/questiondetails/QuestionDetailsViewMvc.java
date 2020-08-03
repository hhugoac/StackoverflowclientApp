package com.hugo.stackoverflowclient.mvc.screens.questiondetails;

import com.hugo.stackoverflowclient.mvc.questions.QuestionDetails;
import com.hugo.stackoverflowclient.mvc.screens.common.navdrawer.DrawerItems;
import com.hugo.stackoverflowclient.mvc.screens.common.navdrawer.NavigationDrawerViewMvc;
import com.hugo.stackoverflowclient.mvc.screens.common.views.ObservableViewMvc;
import com.hugo.stackoverflowclient.mvc.screens.common.views.ViewMvc;

public interface QuestionDetailsViewMvc extends ObservableViewMvc<QuestionDetailsViewMvc.Listener>,
        NavigationDrawerViewMvc {

    public interface Listener {
        void onNavigateUpClicked();

        void onDrawerItemClick(DrawerItems item);
    }

    void bindQuestion(QuestionDetails question);

    void showProgressIndication();

    void hideProgressIndication();

}
