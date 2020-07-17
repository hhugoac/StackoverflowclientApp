package com.hugo.stackoverflowclient.mvc.questions;

import com.hugo.stackoverflowclient.mvc.common.BaseObservable;
import com.hugo.stackoverflowclient.mvc.common.Constants;
import com.hugo.stackoverflowclient.mvc.networking.questions.QuestionSchema;
import com.hugo.stackoverflowclient.mvc.networking.questions.QuestionsListResponseSchema;
import com.hugo.stackoverflowclient.mvc.networking.StackoverflowApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FetchLastActiveQuestionUseCase extends BaseObservable<FetchLastActiveQuestionUseCase.Listener> {

    public interface Listener {
        void onLastActiveQuestionsFetched(List<Question> questions);
        void onLastActiveQuestionsFetchFailed();
    }

    private final StackoverflowApi mStackoverflowApi;

    public FetchLastActiveQuestionUseCase(StackoverflowApi stackoverflowApi) {
        mStackoverflowApi = stackoverflowApi;
    }

    public void fetchLastActiveQuestionsAndNotify() {
        mStackoverflowApi.fetchLastActiveQuestions(Constants.QUESTIONS_LIST_PAGE_SIZE)
                .enqueue(new Callback<QuestionsListResponseSchema>() {
                    @Override
                    public void onResponse(Call<QuestionsListResponseSchema> call, Response<QuestionsListResponseSchema> response) {
                        if (response.isSuccessful()) {
                            notifySuccess(response.body().getQuestions());
                        } else {
                            notifyFailed();
                        }
                    }

                    @Override
                    public void onFailure(Call<QuestionsListResponseSchema> call, Throwable t) {
                        notifyFailed();
                    }
                } );
    }

    private void notifySuccess(List<QuestionSchema> questionSchemas) {
        List<Question> questions = new ArrayList<>(questionSchemas.size());
        for (QuestionSchema questionSchema: questionSchemas) {
            questions.add(new Question(questionSchema.getId(), questionSchema.getTitle()));
        }
        for (Listener listener: getListeners()) {
            listener.onLastActiveQuestionsFetched(questions);
        }
    }

    private void notifyFailed() {
        for (Listener listener: getListeners()) {
            listener.onLastActiveQuestionsFetchFailed();
        }
    }

}
