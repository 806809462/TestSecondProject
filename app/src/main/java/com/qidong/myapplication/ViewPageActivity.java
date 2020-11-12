package com.qidong.myapplication;

import android.app.TaskInfo;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ViewPageActivity extends FragmentActivity {
    private List<Fragment> fragmentList;
    private ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
        int ssss=6%0;
        int sss=0%0;
        int ss=0%5;
        int s0=20%5;
        int s=21%5;
        int s1=22%5;
        int s2=23%5;
        int s3=24%5;
        int s4=25%5;
        Log.d("gg","===========ssss==============="+ssss);
        Log.d("gg","===========sss==============="+sss);
        Log.d("gg","===========ss==============="+ss);
        Log.d("gg","===========s0==============="+s0);
        Log.d("gg","===========s==============="+s);
        Log.d("gg","===========s1==============="+s1);
        Log.d("gg","===========s2==============="+s2);
        Log.d("gg","===========s3==============="+s3);
        Log.d("gg","===========s4==============="+s4);
       /* viewPager = findViewById(R.id.viewpager1);
        fragmentList = new ArrayList<>();
        fragmentList.add(new Fragment1());
        fragmentList.add(new Fragment2());
        viewPager.setAdapter(new TestViewPagerAdapter(getSupportFragmentManager()));
        int coolpoolsize;//核心线程池
        int maxmmumPoolSize;//线程池最大容量大小
        int keepAliveTime;//线程池空闲时，线程存活的时间
        int timeunit; //
        LinkedList<TaskInfo> taskInfos=new LinkedList<>();


       ExecutorService executorService= Executors.newFixedThreadPool(4);
        executorService.submit(new Runnable() {
            @Override
            public void run() {

            }
        });
       executorService.execute(new Runnable() {
           @Override
           public void run() {

           }
       });*/

    }
    private void ss(){

    }

    class TestViewPagerAdapter extends FragmentStatePagerAdapter {

        public TestViewPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }
}
