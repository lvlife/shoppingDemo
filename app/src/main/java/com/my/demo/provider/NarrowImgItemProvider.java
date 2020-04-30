package com.my.demo.provider;

import android.support.v7.widget.AppCompatImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.my.demo.R;
import com.my.demo.adapter.TestHomeAdapter;
import com.my.demo.bean.TestBean;

/**
 * Created by 吕氏春秋i 2020/4/30
 * Describe:
 */


public class NarrowImgItemProvider extends BaseItemProvider<TestBean, BaseViewHolder> {
    @Override
    public int viewType() {
        return TestHomeAdapter.TYPE_NARROW_IMG;
    }

    @Override
    public int layout() {
        return R.layout.app_item_home_narrow_img;
    }

    @Override
    public void convert(BaseViewHolder helper, TestBean data, int position) {
        Glide.with(mContext)
                .load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1588249105533&di=76752c6bfaeebce6f43720fcbc0f9db8&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201809%2F13%2F20180913095240_okjmu.jpg")
                .into((AppCompatImageView) helper.getView(R.id.item_narrow_img));
    }
}
