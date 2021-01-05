package com.qidong.myapplication.recycleview;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.qidong.myapplication.R;
import com.qidong.myapplication.adapter.UserListAdapter;
import com.qidong.myapplication.mode.UserMessage;
import com.qidong.myapplication.util.StatusBarUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;

public class TestRefreshActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static boolean isFirstEnter = true;
    private SmartRefreshLayout mSmartRefreshLayout;
    private UserListAdapter userListAdapter;
    private ArrayList<UserMessage> userList;

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_refresh);

        final RefreshLayout refreshLayout = findViewById(R.id.refreshLayout);
        RecyclerView recyclerView = findViewById(R.id.scrollView);
        Toolbar toolbar = findViewById(R.id.toolbar);
        mSmartRefreshLayout = findViewById(R.id.refreshLayout);
        mSmartRefreshLayout.setEnableAutoLoadMore(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        //状态栏透明和间距处理
        StatusBarUtil.immersive(this);
        StatusBarUtil.setPaddingSmart(this, toolbar);

        userList = new ArrayList<>();
        userListAdapter = new UserListAdapter(userList, TestRefreshActivity.this);
        recyclerView.setAdapter(userListAdapter);
        mSmartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                refresh(refreshLayout);
            }
        });

        mSmartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                loadMore(refreshLayout);
            }
        });
        mSmartRefreshLayout.autoRefresh();

    }

    private void refresh(RefreshLayout refresh) {
        refresh.getLayout().postDelayed(() -> {
            //如果刷新成功
            //还有多的数据
            userList.clear();
            for (int i = 0; i < 15; i++) {
                userList.add(new UserMessage("小米" + i, i));
            }
            userListAdapter.notifyDataSetChanged();
            if (userListAdapter.getItemCount() <= 30) {
                refresh.finishRefresh();
            } else {
                //没有更多数据（上拉加载功能将显示没有更多数据）
                refresh.finishRefreshWithNoMoreData();
            }

        }, 2000);
    }

    private void loadMore(RefreshLayout layout) {
        layout.getLayout().postDelayed(() -> {
            //如果刷新成功
            for (int i = 0; i < 15; i++) {
                userList.add(new UserMessage("红米" + i, i));
            }
            userListAdapter.notifyDataSetChanged();
            if (userListAdapter.getItemCount() <= 90) {
                //还有多的数据
                layout.finishLoadMore();
            } else {
                //没有更多数据（上拉加载功能将显示没有更多数据）
                Toast.makeText(getApplication(), "数据全部加载完毕", Toast.LENGTH_SHORT).show();
                layout.finishLoadMoreWithNoMoreData();//将不会再次触发加载更多事件
            }

        }, 2000);
    }
}