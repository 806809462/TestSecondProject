package com.qidong.myapplication.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

public class TestViewHolder<T> extends RecyclerView.ViewHolder {
    private View mContentView;
    //内存中缓存的view
    private SparseArray<View> views;
    private Context mContext;

    public TestViewHolder(Context context, View itemView) {
        super(itemView);
        mContentView = itemView;
        views = new SparseArray<>();
        mContext = context;
    }


    public static TestViewHolder getHolder(Context context, ViewGroup parent, int layoutId) {
        View itemView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        return new TestViewHolder(context, itemView);
    }

    /**
     * @param viewId 控件的id
     * @param <T>
     * @return 返回经强转成实际类型之后的view类型
     * 本方法一般是在具体adapter中comvert()方法通过id查找对应控件所用
     */
    public <T extends View> T get(int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = mContentView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }

    /**
     * 用于获取特定情况获取复用的itemView
     *
     * @return
     */
    public View getContentView() {
        return mContentView;
    }
}
