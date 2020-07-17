package com.hugo.stackoverflowclient.mvc.screens.questionslist;


import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hugo.stackoverflowclient.R;
import com.hugo.stackoverflowclient.mvc.questions.Question;
import com.hugo.stackoverflowclient.mvc.screens.common.views.BaseObservableViewMvc;

import java.util.List;

public class QuestionsListViewMvcImpl extends BaseObservableViewMvc<QuestionsListViewMvc.Listener>
        implements
        QuestionsRecyclerAdapter.Listener,
        QuestionsListViewMvc {


    private RecyclerView mRecyclerQuestions;
    private QuestionsRecyclerAdapter mAdapter;
    private ProgressBar mProgressBar;


    public QuestionsListViewMvcImpl(LayoutInflater inflater, ViewGroup parent) {
        setmRootView(inflater.inflate(R.layout.layout_questions_list, parent, false));
        mRecyclerQuestions = findViewById(R.id.recycler_questions);
        mRecyclerQuestions.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new QuestionsRecyclerAdapter(inflater, this);
        mRecyclerQuestions.setAdapter(mAdapter);
        mProgressBar = findViewById(R.id.progress);
    }

    @Override
    public void onQuestionClicked(Question question) {
        for(Listener listener: getListeners()) {
            listener.onQuestionClicked(question);
        }
    }

    @Override
    public void bindQuestions(List<Question> questions) {
        mAdapter.bindQuestions(questions);
    }

    @Override
    public void showProgressIndication() {

    }

    @Override
    public void hideProgressIndication() {

    }

}
