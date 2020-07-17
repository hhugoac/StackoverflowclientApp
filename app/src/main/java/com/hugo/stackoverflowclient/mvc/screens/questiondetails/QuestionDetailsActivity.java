package com.hugo.stackoverflowclient.mvc.screens.questiondetails;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.hugo.stackoverflowclient.mvc.questions.FetchQuestionDetailsUseCase;
import com.hugo.stackoverflowclient.mvc.questions.QuestionDetails;
import com.hugo.stackoverflowclient.mvc.screens.common.controllers.BaseActivity;
import com.hugo.stackoverflowclient.mvc.screens.common.toasthelper.ToastHelper;

public class QuestionDetailsActivity extends BaseActivity implements FetchQuestionDetailsUseCase.Listener {

    public static final String EXTRA_QUESTION_ID = "EXTRA_QUESTION_ID";


    private QuestionDetailsViewMvc mViewMvc;

    private FetchQuestionDetailsUseCase mFetchQuestionDetailsUseCase;

    private ToastHelper mToastHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFetchQuestionDetailsUseCase = getCompositionRoot().getFetchQuestionDetailsUseCase();
        mToastHelper = getCompositionRoot().getMessageDisplayer();
        mViewMvc = getCompositionRoot().getViewMvcFactory().getQuestionDetailsViewMvc(null);
        setContentView(mViewMvc.getRootView());
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFetchQuestionDetailsUseCase.registerListener(this);
        mViewMvc.showProgressIndication();
        mFetchQuestionDetailsUseCase.fetchQuestionDetailsAndNotify(getQuestionId());
    }

    @Override
    protected void onStop() {
        super.onStop();
        mFetchQuestionDetailsUseCase.unregisterListener(this);
    }


    private void bindQuestionDetails(QuestionDetails questionDetails) {
        mViewMvc.hideProgressIndication();
        mViewMvc.bindQuestion(questionDetails);
    }

    private String getQuestionId() {
        return getIntent().getStringExtra(EXTRA_QUESTION_ID);
    }

    public static void start(Context context, String questionId) {
        Intent intent = new Intent(context, QuestionDetailsActivity.class);
        intent.putExtra(EXTRA_QUESTION_ID, questionId);
        context.startActivity(intent);
    }


    @Override
    public void onQuestionDetailsFetched(QuestionDetails questionDetails) {
        bindQuestionDetails(questionDetails);
    }

    @Override
    public void onQuestionsDetailsFetchFailed() {
        mViewMvc.hideProgressIndication();
        mToastHelper.showUseCaseError();
    }
}
