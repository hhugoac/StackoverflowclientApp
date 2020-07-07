package com.hugo.stackoverflowclient.mvc.screens.common;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class BaseObservableViewMvc <ListenerType> extends BaseViewMvc
        implements ObservableViewMvc<ListenerType>{

    private Set<ListenerType> mListener = new HashSet<>();

    @Override
    public void registerListener(ListenerType listener) {
        mListener.add(listener);
    }

    @Override
    public void unregisterListener(ListenerType listener) {
        mListener.remove(listener);
    }

    protected Set<ListenerType> getListeners() {
        return Collections.unmodifiableSet(mListener);
    }
}
