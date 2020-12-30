package com.qidong.myapplication.demomvp;

import io.reactivex.functions.Consumer;

public class TestPresent extends BasePresenter<IView> {
    private TestMode mMdodel;

    public TestPresent() {
        mMdodel = new TestMode();
    }

    public void getDate() {
        mMdodel.getDataMode().subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                getView().get().loadingView(s);
            }
        });
    }

}
