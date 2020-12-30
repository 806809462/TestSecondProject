package com.qidong.myapplication.demomvp;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends BaseView> implements IPresenter<V> {
    private WeakReference<V> view;

    @Override
    public void attachView(V v) {
        view = new WeakReference<>(v);
    }

    public WeakReference<V> getView() {
        return view;
    }

}
