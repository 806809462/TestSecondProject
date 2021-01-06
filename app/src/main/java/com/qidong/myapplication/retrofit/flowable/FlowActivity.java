package com.qidong.myapplication.retrofit.flowable;

import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.qidong.myapplication.R;
import com.qidong.myapplication.retrofit.base.BaseActivity;
import com.qidong.myapplication.retrofit.model.ArticleModel;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 作者： ch
 * 时间： 2019/11/19 17:51
 * 描述：
 * 来源：
 */
public class FlowActivity extends BaseActivity<FlowPresenter> implements FlowView {
    @BindView(R.id.btn_getdata)
    Button btnGetdata;
    @BindView(R.id.tv_json)
    TextView tvJson;

    @Override
    protected FlowPresenter createPresenter() {
        return new FlowPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_flow;
    }

    @Override
    protected void addListener() {

    }

    @Override
    protected void initView() {

    }

    @Override
    public void onGetListSucc(List<ArticleModel> o) {
        tvJson.setText(new Gson().toJson(o));
    }


    @OnClick(R.id.btn_getdata)
    public void onViewClicked() {
        presenter.getWxArticleList();
    }
}
