package com.hugo.stackoverflowclient.mvc.screens.common;

import android.content.Context;

import com.hugo.stackoverflowclient.mvc.screens.questiondetails.QuestionDetailsActivity;

public class ScreensNavigator {
    private final Context mContext;

    public ScreensNavigator(Context context) {
        mContext = context;
    }

    public void toDialogDetails(String questionId) {
        QuestionDetailsActivity.start(mContext, questionId);
    }
}
