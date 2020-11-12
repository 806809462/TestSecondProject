package com.qidong.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.qidong.mylibrary.TestModule;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class EventBusActivity extends Activity {
    private TextView textView;
    private ImageView imageView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TestModule testModule=new TestModule();

        setContentView(R.layout.constraint_layout);
        textView = findViewById(R.id.view1);
        imageView=findViewById(R.id.image);
        EventBus.getDefault().register(this);
        TestBroadCast testBroadCast = new TestBroadCast();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("aa");
        registerReceiver(testBroadCast, intentFilter);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("aa");
                sendBroadcast(intent);
            }
        });
        RequestOptions requestOptions=new RequestOptions();

        Glide.with(this).load("").error(R.drawable.ic_launcher_background).diskCacheStrategy(DiskCacheStrategy.NONE).into(imageView);
    }

    @Subscribe
    public void onEvent(String s) {
        textView.setText(s);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
