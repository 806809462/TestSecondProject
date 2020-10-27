package com.qidong.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.concurrent.ThreadPoolExecutor;

public class MainActivity extends AppCompatActivity {
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testReturn();
   /*     String txContent="jdasjdka-ass";
        String beylid= txContent.substring(txContent.indexOf("-"));
        Log.e("gg","==================beylid==="+beylid);*/
      /*  handler = new MyHandler(this);
        sendMyMessage();
        new AsyncTask<Void,Void,Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                return null;
            }
        };*/
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
