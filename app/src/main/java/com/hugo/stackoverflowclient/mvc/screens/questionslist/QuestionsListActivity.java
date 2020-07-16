package com.hugo.stackoverflowclient.mvc.screens.questionslist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.hugo.stackoverflowclient.R;
import com.hugo.stackoverflowclient.mvc.common.Constants;
import com.hugo.stackoverflowclient.mvc.networking.QuestionSchema;
import com.hugo.stackoverflowclient.mvc.networking.QuestionsListResponseSchema;
import com.hugo.stackoverflowclient.mvc.networking.StackoverflowApi;
import com.hugo.stackoverflowclient.mvc.questions.Question;
import com.hugo.stackoverflowclient.mvc.screens.common.BaseActivity;
import com.hugo.stackoverflowclient.mvc.screens.questiondetails.QuestionDetailsActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class QuestionsListActivity extends BaseActivity implements QuestionsListViewMvcImpl.Listener {

    private StackoverflowApi mStackoverflowApi;

    private QuestionsListViewMvc mViewMvc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewMvc = getCompositionRoot().getViewMvcFactory().getQuestionListItemViewMvc(null);
        mViewMvc.registerListener(this);

        mStackoverflowApi = getCompositionRoot().getStackOverflowApi();
        setContentView(mViewMvc.getRootView());
    }

    @Override
    protected void onStart() {
        super.onStart();
        fetchQuestions();
    }

    private void fetchQuestions() {
        mStackoverflowApi.fetchLastActiveQuestions(Constants.QUESTIONS_LIST_PAGE_SIZE)
                .enqueue(new Callback<QuestionsListResponseSchema>() {
                    @Override
                    public void onResponse(Call<QuestionsListResponseSchema> call, Response<QuestionsListResponseSchema> response) {
                        if (response.isSuccessful()) {
                            bindQuestions(response.body().getQuestions());
                        } else {
                            networkCallFailed();
                        }
                    }

                    @Override
                    public void onFailure(Call<QuestionsListResponseSchema> call, Throwable t) {
                        networkCallFailed();
                    }
                } );
    }

    private void bindQuestions(List<QuestionSchema> questionSchemas) {
        List<Question> questions = new ArrayList<>(questionSchemas.size());
        for (QuestionSchema questionSchema : questionSchemas) {
            questions.add(new Question(questionSchema.getId(), questionSchema.getTitle()));
        }
        mViewMvc.bindQuestions(questions);
    }

    private void networkCallFailed() {
        Toast.makeText(this, R.string.error_network_call_failed, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onQuestionClicked(Question question) {
        QuestionDetailsActivity.start(this, question.getId());
    }
}
