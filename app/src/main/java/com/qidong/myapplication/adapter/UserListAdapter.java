package com.qidong.myapplication.adapter;

import android.content.Context;
import android.widget.TextView;

import com.qidong.myapplication.R;
import com.qidong.myapplication.mode.UserMessage;

import java.util.ArrayList;

public class UserListAdapter extends TestAdapter<UserMessage> {
    public UserListAdapter(ArrayList<UserMessage> datas, Context context) {
        super(datas, context);
    }

    @Override
    public int getViewItemType(ArrayList<UserMessage> datas, int position) {
        if (datas.get(position).type == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public int getLayoutId(int viewType) {
        if (viewType == 0) {
            return R.layout.item_user;
        } else {
            return R.layout.item_user2;
        }
    }

    @Override
    public void convert(TestViewHolder holder, UserMessage userMessage, int postion) {
        TextView textView = (TextView) holder.get(R.id.name_view);
        textView.setText(userMessage.getName());
    }
}
