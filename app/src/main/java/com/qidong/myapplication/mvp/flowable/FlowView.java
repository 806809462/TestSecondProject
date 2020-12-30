package com.qidong.myapplication.mvp.flowable;



import com.qidong.myapplication.mvp.base.BaseView;
import com.qidong.myapplication.mvp.model.ArticleModel;

import java.util.List;

/**
 * 作者： ch
 * 时间： 2019/11/19 17:57
 * 描述：
 * 来源：
 */
public interface FlowView extends BaseView {
    void onGetListSucc(List<ArticleModel> o);
}
