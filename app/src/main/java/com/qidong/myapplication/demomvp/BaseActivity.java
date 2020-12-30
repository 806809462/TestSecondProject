package com.qidong.myapplication.demomvp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
/**
 * Activity都要继承该类
 * @param <V>
 * @param <P>
 */
public abstract class BaseActivity<V extends BaseView, P extends BasePresenter<V>> extends AppCompatActivity implements IView {
    private P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        if (mPresenter != null) {
            //绑定View
            mPresenter.attachView((V) this);
        }
    }


    /**
     * 要求子类创建Presenter
     */
    protected abstract P createPresenter();
    @Override
    public void loadingFailed() {

    }
    public P getPresenter(){
        return mPresenter;
    }
}
