package com.qidong.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.qidong.myapplication.R;
import com.qidong.myapplication.mode.UserMessage;
import com.qidong.myapplication.retrofit.mvp.MVPActivity;

import java.util.ArrayList;

public class UserListAdapter extends TestAdapter<UserMessage> {
    private Context mContext;

    public UserListAdapter(ArrayList<UserMessage> datas, Context context) {
        super(datas, context);
        mContext = context;
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
            return R.layout.item_user3;
        } else {
            return R.layout.item_user2;
        }
    }

    @Override
    public void convert(TestViewHolder holder, UserMessage userMessage, int postion) {
        if (postion == 0) {
            GameChildRecycleView recyclerView = (GameChildRecycleView) holder.get(R.id.recycler1);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
            recyclerView.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL));
            ArrayList<String> strings = new ArrayList<>();
            for (int i = 0; i < 8; i++) {
                strings.add(i + "recycle");
            }
            recyclerView.setAdapter(new StringViewAdapter(strings, mContext));
        } else {
            TextView textView = (TextView) holder.get(R.id.name_view);
            textView.setText(userMessage.getName());
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, MVPActivity.class);
                    mContext.startActivity(intent);
                }
            });
        }

    }
}
