package com.qidong.myapplication.shortcutstest;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.qidong.myapplication.MyTestActivity;
import com.qidong.myapplication.R;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnCreateDynamicShortcut;
    private Button btnUpdateShortcut;
    private Button btnRemoveShortcut;
    private Button btnDisableShortcut;
    private Button btnCreatePinnedShortcut;
    private ShortcutManager mShortcutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCreateDynamicShortcut = findViewById(R.id.btn_create_dynamic_shortcut);
        btnCreateDynamicShortcut.setOnClickListener(this);

        btnUpdateShortcut = findViewById(R.id.btn_update_shortcut);
        btnUpdateShortcut.setOnClickListener(this);

        btnRemoveShortcut = findViewById(R.id.btn_remove_shortcut);
        btnRemoveShortcut.setOnClickListener(this);

        btnDisableShortcut = findViewById(R.id.btn_disable_shortcut);
        btnDisableShortcut.setOnClickListener(this);

        btnCreatePinnedShortcut = findViewById(R.id.btn_create_pinned_shortcut);
        btnCreatePinnedShortcut.setOnClickListener(this);
        createPinnedShortcut();
    }

    /**
     * 创建动态快捷方式
     */
    @TargetApi(Build.VERSION_CODES.N_MR1)
    private void createDynamicShortcut() {
        if (mShortcutManager == null) {
            mShortcutManager = getSystemService(ShortcutManager.class);
        }
        Intent mainIntent = new Intent(this, MainActivity.class);
        mainIntent.setAction(Intent.ACTION_MAIN);
        Intent callIntent = new Intent(this, SettingActivity.class);
        callIntent.setAction("com.example.shortcutstest.CALL");
        ShortcutInfo callShortcut = new ShortcutInfo.Builder(this, "call")
                .setShortLabel("电话")
                .setLongLabel("电话")
                .setIcon(Icon.createWithResource(this, R.drawable.ic_call))
                .setIntents(new Intent[]{mainIntent, callIntent})
                .build();
        mShortcutManager.setDynamicShortcuts(Arrays.asList(callShortcut));
    }

    /**
     * 更新快捷方式
     */
    @TargetApi(Build.VERSION_CODES.N_MR1)
    private void updateShortcut() {
        if (mShortcutManager == null) {
            mShortcutManager = getSystemService(ShortcutManager.class);
        }
        Intent intent = new Intent(this, SettingActivity.class);
        intent.setAction("com.example.shortcutstest.CALL");
        ShortcutInfo shortcutInfo = new ShortcutInfo.Builder(this, "call")
                .setShortLabel("拨打电话")
                .setLongLabel("拨打电话")
                .setIcon(Icon.createWithResource(this, R.drawable.ic_call))
                .setIntent(intent)
                .build();
        mShortcutManager.updateShortcuts(Arrays.asList(shortcutInfo));
    }

    /**
     * 删除快捷方式
     */
    @TargetApi(Build.VERSION_CODES.N_MR1)
    private void removeShortcut() {
        if (mShortcutManager == null) {
            mShortcutManager = getSystemService(ShortcutManager.class);
        }
        mShortcutManager.removeDynamicShortcuts(Arrays.asList("navigation"));
//        mShortcutManager.removeAllDynamicShortcuts();
        // 获得所有的固定快捷方式
        List<ShortcutInfo> pinnedShortcutList = mShortcutManager.getPinnedShortcuts();
        for (ShortcutInfo shortcutInfo : pinnedShortcutList) {
            if (shortcutInfo.getId().equals("navigation")) {
                // 禁用被删除的快捷方式
                mShortcutManager.disableShortcuts(Arrays.asList("navigation"), "该快捷方式已被删除");
            }
        }
    }

    /**
     * 禁用快捷方式
     */
    @TargetApi(Build.VERSION_CODES.N_MR1)
    private void disableShortcut() {
        if (mShortcutManager == null) {
            mShortcutManager = getSystemService(ShortcutManager.class);
        }
        mShortcutManager.disableShortcuts(Arrays.asList("call"), "该快捷方式已被禁用");
    }

    /**
     * 创建固定快捷方式
     */
    @TargetApi(Build.VERSION_CODES.O)
    private void createPinnedShortcut() {
        if (mShortcutManager == null) {
            mShortcutManager = getSystemService(ShortcutManager.class);
        }
        List<ShortcutInfo> pinnedShortcutList = mShortcutManager.getPinnedShortcuts();
        for (ShortcutInfo shortcutInfo : pinnedShortcutList) {
            //判断是否已经创建过快捷方式
            if (shortcutInfo.getId().equals("navigation")) {
                Toast.makeText(MainActivity.this, "该快捷方式已经创建过", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        if (mShortcutManager.isRequestPinShortcutSupported()) {
            Intent intent = new Intent();
            intent.setAction("com.example.shortcutstest.SETTING");
            ShortcutInfo pinShortcutInfo = new ShortcutInfo.Builder(this, "navigation")
                    .setShortLabel("导航")
                    .setLongLabel("导航")
                    .setIcon(Icon.createWithResource(this, R.drawable.ic_navigation))
                    .setIntent(intent)
                    .build();
            // 注册固定快捷方式成功广播
   /*         IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.example.shortcutstest.PINNED_BROADCAST");
            PinnedReceiver receiver = new PinnedReceiver();
            registerReceiver(receiver, intentFilter);*/

            Intent pinnedShortcutCallbackIntent = new Intent("com.example.shortcutstest.PINNED_BROADCAST");
            PendingIntent successCallback = PendingIntent.getBroadcast(this, 0,
                    pinnedShortcutCallbackIntent, 0);
            mShortcutManager.requestPinShortcut(pinShortcutInfo, successCallback.getIntentSender());
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_create_dynamic_shortcut:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
                    // 创建动态快捷方式
                    createDynamicShortcut();
                }
                break;
            case R.id.btn_update_shortcut:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
                    // 更新快捷方式
                    updateShortcut();
                }
                break;
            case R.id.btn_remove_shortcut:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
                    // 删除快捷方式
                    removeShortcut();
                }
                break;
            case R.id.btn_disable_shortcut:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
                    // 禁用快捷方式
                    disableShortcut();
                }
                break;
            case R.id.btn_create_pinned_shortcut:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    // 创建固定快捷方式
                  //  createPinnedShortcut();
                    Bundle bundle=new Bundle();
                    Intent intent=new Intent(MainActivity.this, MyTestActivity.class);
                    bundle.putString("aa","aa");
                    bundle.putString("bb","vv");
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                break;
            default:
                break;
        }
    }
}
