package com.my.demo.adapter;

import android.support.v7.widget.AppCompatImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.my.demo.R;
import com.my.demo.bean.TestBean;


/**
 * Created by Administrator on 2018/7/4.
 * Describe:
 */

public class TestItemAdapter extends BaseQuickAdapter<TestBean.GoodsInfoBean, BaseViewHolder> {
    public TestItemAdapter() {
        super(R.layout.app_item_home_scroll_item);
    }

    @Override
    protected void convert(BaseViewHolder helper, TestBean.GoodsInfoBean item) {
        Glide.with(mContext)
                .load(item.getGoodsUrl())
                .dontAnimate()
                .into((AppCompatImageView) helper.getView(R.id.item_img_item));
    }
}
