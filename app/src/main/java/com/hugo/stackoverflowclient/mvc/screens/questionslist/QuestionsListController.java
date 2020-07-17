package com.hugo.stackoverflowclient.mvc.screens.questionslist;

import com.hugo.stackoverflowclient.mvc.questions.FetchLastActiveQuestionUseCase;
import com.hugo.stackoverflowclient.mvc.questions.Question;
import com.hugo.stackoverflowclient.mvc.screens.common.toasthelper.ToastHelper;
import com.hugo.stackoverflowclient.mvc.screens.common.screensnavigator.ScreensNavigator;

import java.util.List;

public class QuestionsListController implements QuestionsListViewMvcImpl.Listener, FetchLastActiveQuestionUseCase.Listener {

    private final FetchLastActiveQuestionUseCase mFetchLastActiveQuestionUseCase;

    private final ScreensNavigator mScreensNavigator;
    private final ToastHelper mToastHelper;

    private QuestionsListViewMvc mViewMvc;

    public QuestionsListController(FetchLastActiveQuestionUseCase fetchLastActiveQuestionUseCase,
                                   ScreensNavigator screensNavigator,
                                   ToastHelper toastHelper) {
        mFetchLastActiveQuestionUseCase = fetchLastActiveQuestionUseCase;
        mScreensNavigator = screensNavigator;
        mToastHelper = toastHelper;
    }

    public void bindView(QuestionsListViewMvc viewMvc) {
        mViewMvc = viewMvc;
        mViewMvc.registerListener(this);
    }

    public void onStart() {
        mViewMvc.registerListener(this);
        mFetchLastActiveQuestionUseCase.registerListener(this);
        mViewMvc.showProgressIndication();
        mFetchLastActiveQuestionUseCase.fetchLastActiveQuestionsAndNotify();
    }

    public void onStop() {
        mViewMvc.unregisterListener(this);
        mFetchLastActiveQuestionUseCase.unregisterListener(this);
    }

    @Override
    public void onQuestionClicked(Question question) {
        mScreensNavigator.toDialogDetails(question.getId());
    }

    @Override
    public void onLastActiveQuestionsFetched(List<Question> questions) {
        mViewMvc.bindQuestions(questions);
    }

    @Override
    public void onLastActiveQuestionsFetchFailed() {
        mViewMvc.hideProgressIndication();
        mToastHelper.showUseCaseError();
    }
}
