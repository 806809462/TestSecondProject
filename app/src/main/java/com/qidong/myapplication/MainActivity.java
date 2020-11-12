package com.qidong.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import org.greenrobot.eventbus.EventBus;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {
    Handler handler;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment1);
        textView = findViewById(R.id.text1);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EventBusActivity.class);
                startActivity(intent);
                EventBus.getDefault().post("ssss");
            }
        });
/*        test(5);
        String txContent = "jdasjdka-ass";
        String beylid = txContent.substring(txContent.indexOf("-"));
        Log.e("gg", "==================beylid===" + beylid);*/
      /*  handler = new MyHandler(this);
        sendMyMessage();
        new AsyncTask<Void,Void,Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                return null;
            }
        };*/
    }

    private void test(int a) {
        if (a == 5) {
            Log.e("gg", "==================test==11=");
            return;
        }
        Log.e("gg", "==================test==222=");
    }

    private void testReturn() {
        String txContent = "jdasjdkaass";
        try {
            String beylid = txContent.substring(txContent.indexOf("-"));
            Log.d("gg", "========beylid=======try=======");
        } catch (Exception e) {
            Log.d("gg", "========beylid=======catch=======");
        } finally {
            Log.d("gg", "========finally==============");
        }
        Log.d("gg", "========beylid==============");
    }

    private void sendMyMessage() {
        Message message = new Message();
        message.what = 1;
        handler.sendMessage(message);
    }

    private static class MyHandler extends Handler {
        private WeakReference<Activity> weakReference;

        private MyHandler(Activity activity) {
            weakReference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }

}
