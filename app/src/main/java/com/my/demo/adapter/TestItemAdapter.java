package com.my.demo.adapter;

import android.support.v7.widget.AppCompatImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.my.demo.R;
import com.my.demo.bean.TestBean;


/**
 * Created by 吕氏春秋i 2020/4/30
 * Describe:
 */


public class TestItemAdapter extends BaseQuickAdapter<TestBean.GoodsInfoBean, BaseViewHolder> {
    public TestItemAdapter() {
        super(R.layout.app_item_home_scroll_item);
    }

    @Override
    protected void convert(BaseViewHolder helper, TestBean.GoodsInfoBean item) {
        Glide.with(mContext)
                .load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1588249106007&di=c9d25fe1bddd384305880ae889754608&imgtype=0&src=http%3A%2F%2Fn.sinaimg.cn%2Fent%2F4_img%2Fupload%2Fbebc130b%2F20170711%2FAbND-fyhwret1519871.jpg")
                .dontAnimate()
                .into((AppCompatImageView) helper.getView(R.id.item_img_item));
    }
}
