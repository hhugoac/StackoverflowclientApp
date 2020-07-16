package com.hugo.stackoverflowclient.mvc.screens.common;

import androidx.appcompat.app.AppCompatActivity;

import com.hugo.stackoverflowclient.mvc.CustomApplication;
import com.hugo.stackoverflowclient.mvc.common.dependencyinjection.ControllerCompositionRoot;

public class BaseActivity extends AppCompatActivity {

    private ControllerCompositionRoot mControllerCompositionRoot;

    protected ControllerCompositionRoot getCompositionRoot() {

        if (mControllerCompositionRoot == null) {
            mControllerCompositionRoot = new ControllerCompositionRoot(
                    ((CustomApplication)getApplication()).getCompositionRoot(),
                    this
            );
        }
        return mControllerCompositionRoot;
    }
}
