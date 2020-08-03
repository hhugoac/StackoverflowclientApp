package com.hugo.stackoverflowclient.mvc.screens.common;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.hugo.stackoverflowclient.mvc.screens.common.toolbar.ToolbarViewMvc;
import com.hugo.stackoverflowclient.mvc.screens.questiondetails.QuestionDetailsViewMvc;
import com.hugo.stackoverflowclient.mvc.screens.questiondetails.QuestionDetailsViewMvcImpl;
import com.hugo.stackoverflowclient.mvc.screens.questionslist.QuestionsListViewMvc;
import com.hugo.stackoverflowclient.mvc.screens.questionslist.QuestionsListViewMvcImpl;
import com.hugo.stackoverflowclient.mvc.screens.questionslist.questionslistitem.QuestionsListItemViewMvc;
import com.hugo.stackoverflowclient.mvc.screens.questionslist.questionslistitem.QuestionsListItemViewMvcImpl;

public class ViewMvcFactory {

    private final LayoutInflater mLayoutInflater;

    public ViewMvcFactory(LayoutInflater mLayoutInflater) {
        this.mLayoutInflater = mLayoutInflater;
    }

    public QuestionsListViewMvc getQuestionListViewMvc(@Nullable ViewGroup parent) {
        return new QuestionsListViewMvcImpl(mLayoutInflater, parent, this);
    }

    public QuestionsListItemViewMvc getQuestionListItemViewMvc(@Nullable ViewGroup parent) {
        return new QuestionsListItemViewMvcImpl(mLayoutInflater, parent);
    }


    public QuestionDetailsViewMvc getQuestionDetailsViewMvc(@Nullable ViewGroup parent) {
        return new QuestionDetailsViewMvcImpl(mLayoutInflater, parent, this);
    }

    public ToolbarViewMvc getToolbarViewMvc(@Nullable ViewGroup parent) {
        return new ToolbarViewMvc(mLayoutInflater, parent);
    }
}
