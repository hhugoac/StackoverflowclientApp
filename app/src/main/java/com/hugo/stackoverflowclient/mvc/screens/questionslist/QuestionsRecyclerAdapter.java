package com.hugo.stackoverflowclient.mvc.screens.questionslist;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hugo.stackoverflowclient.mvc.questions.Question;
import com.hugo.stackoverflowclient.mvc.screens.questionslist.questionslistitem.QuestionsListItemViewMvc;
import com.hugo.stackoverflowclient.mvc.screens.questionslist.questionslistitem.QuestionsListItemViewMvcImpl;

import java.util.ArrayList;
import java.util.List;

public class QuestionsRecyclerAdapter extends
        RecyclerView.Adapter<QuestionsRecyclerAdapter.MyViewHolder>
        implements QuestionsListItemViewMvc.Listener{

    public interface Listener {
        void onQuestionClicked(Question question);
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        private final QuestionsListItemViewMvc mViewMvc;

        public MyViewHolder(QuestionsListItemViewMvc viewMvc) {
            super(viewMvc.getRootView());
            mViewMvc = viewMvc;
        }
    }

    private final LayoutInflater mInflater;
    private final Listener mListener;

    private List<Question> mQuestions = new ArrayList<>();

    public QuestionsRecyclerAdapter(LayoutInflater inflater, Listener listener) {
        mInflater = inflater;
        mListener = listener;
    }

    public void bindQuestions(List<Question> questions) {
       mQuestions = new ArrayList<>(questions);
       notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        QuestionsListItemViewMvc viewMvc = new QuestionsListItemViewMvcImpl(mInflater, parent);
        viewMvc.registerListener(this);
        return new MyViewHolder(viewMvc);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mViewMvc.bindQuestion(mQuestions.get(position));
    }

    @Override
    public int getItemCount() {
        return mQuestions.size();
    }

    @Override
    public void onQuestionClicked(Question question) {
        mListener.onQuestionClicked(question);
    }
}
