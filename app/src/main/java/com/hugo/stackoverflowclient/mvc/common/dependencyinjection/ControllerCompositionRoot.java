package com.hugo.stackoverflowclient.mvc.common.dependencyinjection;

import android.app.Activity;
import android.view.LayoutInflater;

import com.hugo.stackoverflowclient.mvc.networking.StackoverflowApi;
import com.hugo.stackoverflowclient.mvc.questions.FetchQuestionDetailsUseCase;
import com.hugo.stackoverflowclient.mvc.screens.common.ViewMvcFactory;

public class ControllerCompositionRoot {
    
    private final CompositionRoot mCompositionRoot;
    private final Activity mActivity;

    public ControllerCompositionRoot(CompositionRoot compositionRoot, Activity activity) {
        mCompositionRoot = compositionRoot;
        mActivity = activity;
    }


    public StackoverflowApi getStackOverflowApi() {
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
}
