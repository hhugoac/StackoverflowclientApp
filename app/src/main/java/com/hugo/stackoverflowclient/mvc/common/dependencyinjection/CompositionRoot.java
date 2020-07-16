package com.hugo.stackoverflowclient.mvc.common.dependencyinjection;

import android.app.Application;

import com.hugo.stackoverflowclient.mvc.common.Constants;
import com.hugo.stackoverflowclient.mvc.networking.StackoverflowApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CompositionRoot extends Application {

    private Retrofit mRetrofit;

    public StackoverflowApi getStackOverflowApi() {
        return getRetrofit().create(StackoverflowApi.class);
    }

    private Retrofit getRetrofit() {
        if (mRetrofit == null) {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return mRetrofit;
    }
}
