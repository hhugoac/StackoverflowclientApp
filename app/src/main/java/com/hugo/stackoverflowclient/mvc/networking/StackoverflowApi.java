package com.hugo.stackoverflowclient.mvc.networking;

import com.hugo.stackoverflowclient.mvc.common.Constants;
import com.hugo.stackoverflowclient.mvc.networking.questions.QuestionsDetailsResponseSchema;
import com.hugo.stackoverflowclient.mvc.networking.questions.QuestionsListResponseSchema;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface StackoverflowApi {

    @GET("/questions?key=" + Constants.STACKOVERFLOW_API_KEY + "&sort=activity&order=desc&site=stackoverflow&filter=withbody")
    Call<QuestionsListResponseSchema> fetchLastActiveQuestions(@Query("pagesize") Integer pageSize);

    @GET("/questions/{questionId}?key=" + Constants.STACKOVERFLOW_API_KEY + "&site=stackoverflow&filter=withbody")
    Call<QuestionsDetailsResponseSchema>fetchQuestionDetails(@Path("questionId") String questionId);
}
