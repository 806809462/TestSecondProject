package com.qidong.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class TestBroadCast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String str = intent.getAction();
        if (str.equals("")) {
            intent.getExtras().getString("", "");
        }
    }
}
