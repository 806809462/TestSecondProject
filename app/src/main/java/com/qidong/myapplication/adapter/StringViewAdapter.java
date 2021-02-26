package com.qidong.myapplication.adapter;

import android.content.Context;
import android.widget.TextView;

import com.qidong.myapplication.R;

import java.util.ArrayList;

public class StringViewAdapter extends TestAdapter<String> {

    public StringViewAdapter(ArrayList<String> datas, Context context) {
        super(datas, context);
    }

    @Override
    public int getViewItemType(ArrayList<String> datas, int position) {
        return 0;
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.item_user2;
    }

    @Override
    public void convert(TestViewHolder holder, String s, int postion) {
        TextView textView = (TextView) holder.get(R.id.name_view);
        textView.setText(s);
    }
}
