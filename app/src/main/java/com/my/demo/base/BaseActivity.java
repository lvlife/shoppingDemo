package com.my.demo.base;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.jaeger.library.StatusBarUtil;
import com.my.demo.R;

/**
 * Created by 吕氏春秋i 2020/4/30
 * Describe:
 */


public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 竖屏锁定
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //初始化视图
        setContentView(setLayoutId());
        //设置沉浸式
        setStatusBar();
        //初始化View
        initView();
        //初始化数据
        initData();
        //初始化事件监听
        initEvent();
    }

    protected abstract int setLayoutId();

    protected void setStatusBar() {
        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary));
    }

    public abstract void initView();

    public abstract void initData();

    public abstract void initEvent();

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
        }
        return true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        View mView = getWindow().peekDecorView();
        if (mView != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            assert imm != null;
            imm.hideSoftInputFromWindow(mView.getWindowToken(), 0);
        }
    }
}
