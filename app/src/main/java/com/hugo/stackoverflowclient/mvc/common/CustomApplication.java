package com.hugo.stackoverflowclient.mvc.common;

import android.app.Application;

import com.hugo.stackoverflowclient.mvc.common.dependencyinjection.CompositionRoot;

public class CustomApplication extends Application {

    private CompositionRoot mCompositionRoot;

    @Override
    public void onCreate() {
        super.onCreate();
        mCompositionRoot = new CompositionRoot();
    }

    public CompositionRoot getCompositionRoot() {
        return mCompositionRoot;
    }
}
