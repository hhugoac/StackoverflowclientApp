package com.hugo.stackoverflowclient.mvc.questions;

public class QuestionDetails {

    private final String mId;
    private final String mTitle;
    private final String mBody;

    public QuestionDetails(String mId, String mTitle, String mBody) {
        this.mId = mId;
        this.mTitle = mTitle;
        this.mBody = mBody;
    }

    public String getmId() {
        return mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmBody() {
        return mBody;
    }
}
