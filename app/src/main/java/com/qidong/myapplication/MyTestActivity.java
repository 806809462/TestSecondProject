package com.qidong.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MyTestActivity extends Activity {
    private CircleRelativeLayout circleRelativeLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        circleRelativeLayout=findViewById(R.id.circle);
        circleRelativeLayout.setColor(getResources().getColor(R.color.colorAccent));
        circleRelativeLayout.setAlhpa(160);
        OkHttpClient okHttpClient=new OkHttpClient();
        FormBody formBody=new FormBody.Builder().add("key","value").build();
        Request request=new Request.Builder().url("").post(formBody).build();
        Call call=okHttpClient.newCall(request);
        ThreadPoolExecutor poolExecutor=new ThreadPoolExecutor(1, 2, 3000, null, new BlockingQueue<Runnable>() {
            @Override
            public boolean add(Runnable runnable) {
                return false;
            }

            @Override
            public boolean offer(Runnable runnable) {
                return false;
            }

            @Override
            public void put(Runnable runnable) throws InterruptedException {

            }

            @Override
            public boolean offer(Runnable runnable, long l, TimeUnit timeUnit) throws InterruptedException {
                return false;
            }

            @Override
            public Runnable take() throws InterruptedException {
                return null;
            }

            @Override
            public Runnable poll(long l, TimeUnit timeUnit) throws InterruptedException {
                return null;
            }

            @Override
            public int remainingCapacity() {
                return 0;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public int drainTo(Collection<? super Runnable> collection) {
                return 0;
            }

            @Override
            public int drainTo(Collection<? super Runnable> collection, int i) {
                return 0;
            }

            @Override
            public Runnable remove() {
                return null;
            }

            @Nullable
            @Override
            public Runnable poll() {
                return null;
            }

            @Override
            public Runnable element() {
                return null;
            }

            @Nullable
            @Override
            public Runnable peek() {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @NonNull
            @Override
            public Iterator<Runnable> iterator() {
                return null;
            }

            @NonNull
            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @NonNull
            @Override
            public <T> T[] toArray(@NonNull T[] ts) {
                return null;
            }

            @Override
            public boolean containsAll(@NonNull Collection<?> collection) {
                return false;
            }

            @Override
            public boolean addAll(@NonNull Collection<? extends Runnable> collection) {
                return false;
            }

            @Override
            public boolean removeAll(@NonNull Collection<?> collection) {
                return false;
            }

            @Override
            public boolean retainAll(@NonNull Collection<?> collection) {
                return false;
            }

            @Override
            public void clear() {

            }
        }, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable runnable) {
                return null;
            }
        });
        poolExecutor.execute(new Runnable() {
            @Override
            public void run() {

            }
        });
        //call.execute();

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                response.body().toString();
            }
        });

        Log.d("gg", "=======onCreate=============="+ getLocalClassName());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("gg", "=======onStart==============" + getLocalClassName());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("gg", "=======onResume=============="+ getLocalClassName());
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("gg", "=======onPause=============="+ getLocalClassName());
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("gg", "=======onStop=============="+ getLocalClassName());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("gg", "=======onRestart=============="+ getLocalClassName());
    }
}
