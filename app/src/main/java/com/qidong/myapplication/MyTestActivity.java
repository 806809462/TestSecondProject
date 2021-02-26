package com.qidong.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.qidong.myapplication.view.OvalImageView;

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
    private ImageView imageView;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private ImageView imageView5;
    private ImageView imageView6;
    private AnimationDrawable animationDrawable1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imageView = findViewById(R.id.image1);
        imageView2 = findViewById(R.id.image2);
        imageView3 = findViewById(R.id.image3);
        imageView4 = findViewById(R.id.image4);
        imageView5 = findViewById(R.id.image5);
        imageView6 = findViewById(R.id.image6);

        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        bundle.getString("cc");
        Log.d("gg","========bundle======="+bundle.getString("cc"));

       /* imageView.setBackgroundResource(R.drawable.testanim);
        imageView2.setBackgroundResource(R.drawable.testanim);
        imageView3.setBackgroundResource(R.drawable.testanim);
        imageView4.setBackgroundResource(R.drawable.testanim);
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();
        animationDrawable.start();//开启动画*/
     /*   animationDrawable1 = animationDrawable();
        imageView.setImageDrawable(animationDrawable1);
        animationDrawable1.start();

        animationDrawable1 = animationDrawable();
        imageView2.setImageDrawable(animationDrawable1);
        animationDrawable1.start();

        animationDrawable1 = animationDrawable();
        imageView3.setImageDrawable(animationDrawable1);
        animationDrawable1.start();

        animationDrawable1 = animationDrawable();
        imageView4.setImageDrawable(animationDrawable1);
        animationDrawable1.start();

        animationDrawable1 = animationDrawable();
        imageView5.setImageDrawable(animationDrawable1);
        animationDrawable1.start();

        animationDrawable1 = animationDrawable();
        imageView6.setImageDrawable(animationDrawable1);
        animationDrawable1.start();
*/

      /*  circleRelativeLayout=findViewById(R.id.circle);
        circleRelativeLayout.setColor(getResources().getColor(R.color.colorAccent));
        circleRelativeLayout.setAlhpa(160);*/
      /*  OkHttpClient okHttpClient=new OkHttpClient();
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
        });*/

        Log.d("gg", "=======onCreate==============" + getLocalClassName());
    }

    public AnimationDrawable animationDrawable() {
        AnimationDrawable animationDrawab = null;
        animationDrawab = new AnimationDrawable();
        animationDrawab.addFrame(getResources().getDrawable(R.drawable.bizgame_hall_ranking_icon), (int) (Math.random() * 12 + 1) * 100);
        animationDrawab.addFrame(getResources().getDrawable(R.drawable.jiaru_icon), (int) (Math.random() * 15 + 1) * 100);
        animationDrawab.addFrame(getResources().getDrawable(R.drawable.game_icon_5783), (int) (Math.random() * 20 + 1) * 100);
        animationDrawab.addFrame(getResources().getDrawable(R.drawable.game_icon_8421), (int) (Math.random() * 15 + 1) * 100);
        animationDrawab.addFrame(getResources().getDrawable(R.drawable.game_icon_8919), (int) (Math.random() * 10 + 1) * 100);
        animationDrawab.setOneShot(false);
        return animationDrawab;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("gg", "=======onStart==============" + getLocalClassName());
    }

    public int dip2px(float dpValue) {
        float scale = getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("gg", "=======onResume==============" + getLocalClassName());
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("gg", "=======onPause==============" + getLocalClassName());
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("gg", "=======onStop==============" + getLocalClassName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
       // animationDrawable1.stop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("gg", "=======onRestart==============" + getLocalClassName());
    }
}
