package com.qidong.myapplication.demomvp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.qidong.myapplication.R;

public class MvpActivity extends BaseActivity<IView, TestPresent> {
   // @BindView(R.id.btn_getdata)
    Button button;
    private TestPresent mTestPresent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_mvp);
        mTestPresent = getPresenter();
        button= findViewById(R.id.btn_getdata);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTestPresent.getDate();
            }
        });
    }

    @Override
    protected TestPresent createPresenter() {
        return new TestPresent();
    }

 /*   @OnClick(R.id.btn_getdata)
    public void onViewBtnClick() {
        mTestPresent.getDate();
    }*/

    @Override
    public void loadingView(Object o) {
        button.setText((String) o);
    }

}
