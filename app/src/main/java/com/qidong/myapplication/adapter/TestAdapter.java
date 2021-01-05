package com.qidong.myapplication.adapter;

import android.content.Context;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public abstract class TestAdapter<T> extends RecyclerView.Adapter<TestViewHolder> implements MultiTypeSupportImp<T> {
    private ArrayList<T> datas;
    private Context context;

    public TestAdapter(ArrayList<T> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    @Override
    public TestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutId = getLayoutId(viewType);
        TestViewHolder holder = TestViewHolder.getHolder(context, parent, layoutId);
        return holder;
    }

    @Override
    public void onBindViewHolder(TestViewHolder holder, int position) {
        convert(holder, datas.get(position), position);
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public int getItemViewType(int position) {
        return getViewItemType(datas, position);
    }


    @Override
    public abstract int getViewItemType(ArrayList<T> datas, int position);

    @Override
    public abstract int getLayoutId(int viewType);

    public abstract void convert(TestViewHolder holder, T t, int postion);
}
