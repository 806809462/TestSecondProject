package com.qidong.myapplication.retrofit.mvp;


import com.qidong.myapplication.retrofit.base.BaseObserver;
import com.qidong.myapplication.retrofit.base.BasePresenter;
import com.qidong.myapplication.retrofit.model.ArticleModel;

import java.util.List;

/**
 * 作者： ch
 * 时间： 2019/11/19 17:29
 * 描述：
 * 来源：
 */
public class MvpPresenter extends BasePresenter<MvpView> {
    public MvpPresenter(MvpView baseView) {
        super(baseView);
    }

    /**
     * 获取文章列表
     */
    public void getWxArticleList() {
        addDisposable(apiServer.getWxArticleList(), new BaseObserver<List<ArticleModel>>(baseView) {
            @Override
            public void onSuccess(List<ArticleModel> o) {
                baseView.onGetListSucc(o);
            }

            @Override
            public void onError(String msg) {
                baseView.showError(msg);
            }
        });
    }
}
