package com.hugo.stackoverflowclient.mvc.screens.questionslist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hugo.stackoverflowclient.R;
import com.hugo.stackoverflowclient.mvc.questions.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionsLisViewMvcImpl implements
        QuestionsRecyclerAdapter.Listener,
        QuestionsLisViewMvc {

    private final List<Listener> mListeners = new ArrayList<>(1);
    private final View rootView;

    private RecyclerView mRecyclerQuestions;
    private QuestionsRecyclerAdapter mAdapter;
    //private ListView mLstQuestions;
    //private QuestionsListAdapter mQuestionsListAdapter;

    public QuestionsLisViewMvcImpl(LayoutInflater inflater, ViewGroup parent) {
        rootView = inflater.inflate(R.layout.layout_questions_list, parent, false);
        /*mLstQuestions = findViewById(R.id.lst_questions);
        mQuestionsListAdapter = new QuestionsListAdapter(getContext(), this);
        mLstQuestions.setAdapter(mQuestionsListAdapter);*/
        mRecyclerQuestions = findViewById(R.id.recycler_questions);
        mRecyclerQuestions.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new QuestionsRecyclerAdapter(inflater, this);
        mRecyclerQuestions.setAdapter(mAdapter);
    }

    @Override
    public void registerListener(Listener listener) {
        mListeners.add(listener);
    }

    @Override
    public void unregisterListener(Listener listener) {
        mListeners.remove(listener);
    }

    private Context getContext() {
        return getRootView().getContext();
    }

    private <T extends View> T findViewById(int id) {
        return getRootView().findViewById(id);
    }

    @Override
    public View getRootView() {
        return rootView;
    }

    @Override
    public void onQuestionClicked(Question question) {
        for(Listener listener: mListeners) {
            listener.onQuestionClicked(question);
        }
    }

    @Override
    public void bindQuestions(List<Question> questions) {
        mAdapter.bindQuestions(questions);
        /*
        mQuestionsListAdapter.clear();
        mQuestionsListAdapter.addAll(questions);
        mQuestionsListAdapter.notifyDataSetChanged();*/
    }
}
