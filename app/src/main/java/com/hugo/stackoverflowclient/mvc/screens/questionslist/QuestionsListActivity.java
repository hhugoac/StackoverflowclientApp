package com.hugo.stackoverflowclient.mvc.screens.questionslist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.hugo.stackoverflowclient.mvc.screens.common.controllers.BaseActivity;

public class QuestionsListActivity extends BaseActivity {

    public static void startClearTop(Context context) {
        Intent intent = new Intent(context, QuestionsListActivity.class);
        intent.setFlags(intent.getFlags() | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }

    private QuestionsListController mQuestionsListController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        QuestionsListViewMvc mViewMvc = getCompositionRoot().getViewMvcFactory().getQuestionListViewMvc(null);
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

    @Override
    public void onBackPressed() {
        if (!mQuestionsListController.onBackPressed()) {
            super.onBackPressed();
        }
    }


}
