package com.my.demo;

import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.jaeger.library.StatusBarUtil;
import com.my.demo.adapter.ViewPagerAdapter;
import com.my.demo.base.BaseActivity;
import com.my.demo.fragment.ClassifyFragment;
import com.my.demo.fragment.HomeFragment;
import com.my.demo.fragment.MineFragment;
import com.my.demo.fragment.ShoppingCartFragment;
import com.my.demo.widget.NoScrollViewPager;

import java.util.ArrayList;

/**
 * Created by 吕氏春秋i 2020/4/30
 * Describe:主入口
 */


public class MainActivity extends BaseActivity implements View.OnClickListener{

    private NoScrollViewPager mViewPager;
    private LinearLayout mLlHome;
    private LinearLayout mLlClassify;
    private LinearLayout mLlShoppingCart;
    private LinearLayout mLlMine;

    @Override
    protected int setLayoutId() {
        return R.layout.app_act_main;
    }

    @Override
    public void initView() {
        mViewPager = findViewById(R.id.app_act_main_vp);
        mLlHome = findViewById(R.id.app_include_bottom_main_ll_home);
        mLlClassify = findViewById(R.id.app_include_bottom_main_ll_classify);
        mLlShoppingCart = findViewById(R.id.app_include_bottom_main_ll_cart);
        mLlMine = findViewById(R.id.app_include_bottom_main_ll_mine);
    }

    @Override
    public void initData() {
        //添加Fragment
        ArrayList<Fragment> mFragments = new ArrayList<>();
        mFragments.add(new HomeFragment());
        mFragments.add(new ClassifyFragment());
        mFragments.add(new ShoppingCartFragment());
        mFragments.add(new MineFragment());

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), mFragments);
        mViewPager.setAdapter(adapter);
        mViewPager.setScroll(false);
        mLlHome.setSelected(true);
    }

    @Override
    public void initEvent() {
        mLlHome.setOnClickListener(this);
        mLlClassify.setOnClickListener(this);
        mLlShoppingCart.setOnClickListener(this);
        mLlMine.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //首页
            case R.id.app_include_bottom_main_ll_home:
                StatusBarUtil.setTranslucentForImageViewInFragment(this, 0, null);
                StatusBarUtil.setLightMode(this);
                mViewPager.setCurrentItem(0);
                tabSelected(mLlHome);
                break;
            //分类
            case R.id.app_include_bottom_main_ll_classify:
                StatusBarUtil.setLightMode(this);
                StatusBarUtil.setColor(this, getResources().getColor(R.color.white), 0);
                mViewPager.setCurrentItem(1);
                tabSelected(mLlClassify);
                break;
            //购物车
            case R.id.app_include_bottom_main_ll_cart:
                StatusBarUtil.setLightMode(this);
                StatusBarUtil.setColor(this, getResources().getColor(R.color.white), 0);
                mViewPager.setCurrentItem(2);
                tabSelected(mLlShoppingCart);
                break;
            //我的
            case R.id.app_include_bottom_main_ll_mine:
                StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary), 0);
                StatusBarUtil.setDarkMode(this);
                mViewPager.setCurrentItem(3);
                tabSelected(mLlMine);
                break;
            default:
                StatusBarUtil.setTranslucentForImageViewInFragment(this, 0, null);
                mViewPager.setCurrentItem(0);
                tabSelected(mLlHome);
                break;
        }
    }

    /**
     * Tab选中
     *
     * @param linearLayout
     */
    private void tabSelected(LinearLayout linearLayout) {
        mLlHome.setSelected(false);
        mLlClassify.setSelected(false);
        mLlShoppingCart.setSelected(false);
        mLlMine.setSelected(false);
        linearLayout.setSelected(true);
    }

    /**
     * 退出应用
     */
    private long clickTime = 0; //记录第一次点击的时间

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - clickTime) > 2000) {
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                clickTime = System.currentTimeMillis();
            } else {
                this.finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void setStatusBar() {
        super.setStatusBar();
        StatusBarUtil.setTranslucentForImageViewInFragment(this, 0, null);
        StatusBarUtil.setLightMode(this);
    }
}
