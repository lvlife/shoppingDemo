package com.my.demo.fragment;

import android.view.View;

import com.my.demo.R;
import com.my.demo.base.BaseFragment;

/**
 * Created by Administrator on 2018/7/6.
 * Describe:购物车
 */

public class ShoppingCartFragment extends BaseFragment {
    @Override
    public int getLayoutId() {
        return R.layout.app_fragment_shopping_cart;
    }


    @Override
    public void initView(View mView) {

    }

    @Override
    public void lazyLoad() {
        super.lazyLoad();
    }
}
