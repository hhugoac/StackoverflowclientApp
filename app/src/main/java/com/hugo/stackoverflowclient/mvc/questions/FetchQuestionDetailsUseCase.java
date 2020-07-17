package com.hugo.stackoverflowclient.mvc.questions;

import com.hugo.stackoverflowclient.mvc.common.BaseObservable;
import com.hugo.stackoverflowclient.mvc.networking.questions.QuestionSchema;
import com.hugo.stackoverflowclient.mvc.networking.questions.QuestionsDetailsResponseSchema;
import com.hugo.stackoverflowclient.mvc.networking.StackoverflowApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FetchQuestionDetailsUseCase extends BaseObservable<FetchQuestionDetailsUseCase.Listener> {

    private final StackoverflowApi mStackoverflowApi;

    public FetchQuestionDetailsUseCase(StackoverflowApi mStackoverflowApi) {
        this.mStackoverflowApi = mStackoverflowApi;
    }


    public interface Listener {

        void onQuestionDetailsFetched(QuestionDetails questionDetails);

        void onQuestionsDetailsFetchFailed();
    }

    public void fetchQuestionDetailsAndNotify(String questionId) {
        mStackoverflowApi.fetchQuestionDetails(questionId).enqueue(new Callback<QuestionsDetailsResponseSchema>() {
            @Override
            public void onResponse(Call<QuestionsDetailsResponseSchema> call, Response<QuestionsDetailsResponseSchema> response) {
                if (response.isSuccessful()) {
                    notifySuccess(response.body().getQuestion());
                } else {
                    notifyFailed();
                }
            }

            @Override
            public void onFailure(Call<QuestionsDetailsResponseSchema> call, Throwable t) {
                notifyFailed();
            }
        });
    }

    private void notifySuccess(QuestionSchema question) {
        for (Listener listener : getListeners()) {
            listener.onQuestionDetailsFetched(
                    new QuestionDetails(
                            question.getId(),
                            question.getTitle(),
                            question.getBody()
                    )
            );
        }
    }

    private void notifyFailed() {
        for (Listener listener : getListeners()) {
            listener.onQuestionsDetailsFetchFailed();
        }


    }
}
