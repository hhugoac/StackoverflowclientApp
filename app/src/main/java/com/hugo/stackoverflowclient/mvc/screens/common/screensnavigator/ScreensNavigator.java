package com.hugo.stackoverflowclient.mvc.screens.common.screensnavigator;

import android.content.Context;

import com.hugo.stackoverflowclient.mvc.screens.questiondetails.QuestionDetailsActivity;
import com.hugo.stackoverflowclient.mvc.screens.questionslist.QuestionsListActivity;

public class ScreensNavigator {
    private final Context mContext;

    public ScreensNavigator(Context context) {
        mContext = context;
    }

    public void toDialogDetails(String questionId) {
        QuestionDetailsActivity.start(mContext, questionId);
    }

    public void toQuestionsListClearTop() {
        QuestionsListActivity.startClearTop(mContext);
    }
}
