package com.hugo.stackoverflowclient.mvc.common.dependencyinjection;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;

import com.hugo.stackoverflowclient.mvc.networking.StackoverflowApi;
import com.hugo.stackoverflowclient.mvc.questions.FetchLastActiveQuestionUseCase;
import com.hugo.stackoverflowclient.mvc.questions.FetchQuestionDetailsUseCase;
import com.hugo.stackoverflowclient.mvc.screens.common.toasthelper.ToastHelper;
import com.hugo.stackoverflowclient.mvc.screens.common.screensnavigator.ScreensNavigator;
import com.hugo.stackoverflowclient.mvc.screens.common.ViewMvcFactory;
import com.hugo.stackoverflowclient.mvc.screens.questionslist.QuestionsListController;

public class ControllerCompositionRoot {
    
    private final CompositionRoot mCompositionRoot;
    private final Activity mActivity;

    public ControllerCompositionRoot(CompositionRoot compositionRoot, Activity activity) {
        mCompositionRoot = compositionRoot;
        mActivity = activity;
    }

    private StackoverflowApi getStackOverflowApi() {
        return mCompositionRoot.getStackOverflowApi();
    }

    public LayoutInflater getLayoutInflater() {
        return LayoutInflater.from(mActivity);
    }

    public ViewMvcFactory getViewMvcFactory() {
        return new ViewMvcFactory(getLayoutInflater());
    }

    public FetchQuestionDetailsUseCase getFetchQuestionDetailsUseCase() {
        return new FetchQuestionDetailsUseCase(getStackOverflowApi());
    }

    public FetchLastActiveQuestionUseCase getfetchLastActiveQuestionUseCase() {
        return new FetchLastActiveQuestionUseCase(getStackOverflowApi());
    }

    public QuestionsListController getQuestionsListViewMvc() {
        return new QuestionsListController(
                getfetchLastActiveQuestionUseCase(),
                getScreenNavigator(),
                getMessageDisplayer()
        );
    }

    private Context getContext() {
        return mActivity;
    }

    public ToastHelper getMessageDisplayer() {
        return new ToastHelper(getContext());
    }

    public ScreensNavigator getScreenNavigator() {
        return new ScreensNavigator(getContext());
    }
}
