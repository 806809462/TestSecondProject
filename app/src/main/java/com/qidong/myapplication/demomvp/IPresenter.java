package com.qidong.myapplication.demomvp;
/**
 * 因为我们需要在BasePresenter中拿到 View的对象，所以定义个接口给BasePresenter的继承
 * @param <V>
 */
public interface IPresenter<V extends BaseView> {
    void attachView(V View);
}
