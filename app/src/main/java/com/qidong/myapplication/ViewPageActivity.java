package com.qidong.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class ViewPageActivity extends FragmentActivity {
    private List<Fragment> fragmentList;
    private ViewPager viewPager;
    private Object object;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
        TextView textView=findViewById(R.id.textView);
     //   EventBus.getDefault().register(this);
        object=new Object();
        object.hashCode();
        Log.d("gg", "=======onCreate=============="+object.hashCode());
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("gg", "=======onClick==============");
                finish();
                Intent intent = new Intent(ViewPageActivity.this, ViewPageActivity.class);
                startActivity(intent);
            }
        });
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

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("gg", "=======onNewIntent=============="+object.hashCode());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("gg", "=======onStart==============" );
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("gg", "=======onResume==============");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("gg", "=======onPause==============");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("gg", "=======onStop==============");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("gg", "=======onDestroy==============");
       // EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("gg", "=======onRestart==============");
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
