package com.hugo.stackoverflowclient.mvc.screens.questionslist;

import android.os.Bundle;

import com.hugo.stackoverflowclient.mvc.screens.common.controllers.BaseActivity;

public class QuestionsListActivity extends BaseActivity {

    private QuestionsListController mQuestionsListController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        QuestionsListViewMvc mViewMvc;
        mViewMvc = getCompositionRoot().getViewMvcFactory().getQuestionListItemViewMvc(null);
        mQuestionsListController = getCompositionRoot().getQuestionsListViewMvc();

        mQuestionsListController.bindView(mViewMvc);

        setContentView(mViewMvc.getRootView());
    }

    @Override
    protected void onStart() {
        super.onStart();
        mQuestionsListController.onStart();

    }

    @Override
    protected void onStop() {
        super.onStop();
        mQuestionsListController.onStop();
    }


}
