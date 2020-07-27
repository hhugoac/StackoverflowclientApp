package com.hugo.stackoverflowclient.mvc.screens.questionslist;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hugo.stackoverflowclient.R;
import com.hugo.stackoverflowclient.mvc.questions.Question;
import com.hugo.stackoverflowclient.mvc.screens.common.ViewMvcFactory;
import com.hugo.stackoverflowclient.mvc.screens.common.navdrawer.BaseNavDrawerViewMvc;
import com.hugo.stackoverflowclient.mvc.screens.common.navdrawer.DrawerItems;
import com.hugo.stackoverflowclient.mvc.screens.common.toolbar.ToolbarViewMvc;
import com.hugo.stackoverflowclient.mvc.screens.common.views.BaseObservableViewMvc;

import java.util.List;

public class QuestionsListViewMvcImpl extends BaseNavDrawerViewMvc<QuestionsListViewMvc.Listener>
        implements
        QuestionsRecyclerAdapter.Listener,
        QuestionsListViewMvc {

    private RecyclerView mRecyclerQuestions;
    private QuestionsRecyclerAdapter mAdapter;
    private ProgressBar mProgressBar;

    private final ToolbarViewMvc mToolbarViewMvc;
    private final Toolbar mToolbar;


    public QuestionsListViewMvcImpl(LayoutInflater inflater, ViewGroup parent, ViewMvcFactory viewMvcFactory) {
        super(inflater, parent);
        setmRootView(inflater.inflate(R.layout.layout_questions_list, parent, false));
        mRecyclerQuestions = findViewById(R.id.recycler_questions);
        mRecyclerQuestions.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new QuestionsRecyclerAdapter(inflater, this);
        mRecyclerQuestions.setAdapter(mAdapter);

        mProgressBar = findViewById(R.id.progress);

        mToolbar = findViewById(R.id.toolbar);
        mToolbarViewMvc = viewMvcFactory.getToolbarViewMvc(mToolbar);
        mToolbarViewMvc.setTitle(getString(R.string.questions_list_screen_title));
        mToolbar.addView(mToolbarViewMvc.getRootView());
        initToolbar();
    }

    private void initToolbar() {
        mToolbarViewMvc.setTitle(getString(R.string.questions_list_screen_title));
        mToolbar.addView(mToolbarViewMvc.getRootView());
        mToolbarViewMvc.enableHamburguerButtonAndListen(new ToolbarViewMvc.HamburgerClickListener() {
            @Override
            public void onHamburgerClicked() {
                openDrawer();
            }
        });
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
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressIndication() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    protected void onDrawerItemClicked(DrawerItems item) {
        for (Listener listener: getListeners()) {
            switch (item) {
                case QUESTIONS_LIST:
                    listener.onQuestionsClicked();
            }
        }
    }
}
