package com.xjp.myapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.Toast;

import com.xjp.myapp.application.MyApplication;
import com.xjp.myapp.utils.MyLog;

/**
 * User :xjp
 */
public  class BaseActivity extends ActionBarActivity {
    private String TAG;
    protected boolean isHideActionBar = false;
    protected ActionBar actionBar;


    @Override
    public ActionBar getSupportActionBar() {
        return super.getSupportActionBar();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TAG = this.getClass().getSimpleName();
        MyLog.d(TAG, "===onCreate===");
        MyApplication.instance.addActivity(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        MyLog.d(TAG, "===onStart===");
        actionBar = getSupportActionBar();
        //是否隐藏 ActionBar
        if (isHideActionBar) {
            actionBar.hide();
        }
        //显示返回图标
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        MyLog.d(TAG, "===onNewIntent===");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        MyLog.d(TAG, "===onRestart===");
    }

    @Override
    protected void onResume() {
        super.onResume();
        MyLog.d(TAG, "===onResume===");
    }

    @Override
    protected void onPause() {
        super.onPause();
        MyLog.d(TAG, "===onPause===");
    }

    @Override
    protected void onStop() {
        super.onStop();
        MyLog.d(TAG, "===onStop===");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MyLog.d(TAG, "===onDestroy===");
        MyApplication.instance.removeActivity(this);

    }

    /**
     * TODO 显示 Toast 提示
     *
     * @param msg
     */
    protected void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * TODO 显示 Toast 提示
     *
     * @param msgId
     */
    protected void showToast(int msgId) {
        Toast.makeText(this, msgId, Toast.LENGTH_SHORT).show();

    }

    /**
     * TODO 显示 Log 打印信息
     *
     * @param msg
     */
    protected void showLog(String msg) {
        MyLog.d(TAG, msg);
    }

    /**
     * Activity 的跳转
     *
     * @param cls
     */
    protected void startActivity(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
