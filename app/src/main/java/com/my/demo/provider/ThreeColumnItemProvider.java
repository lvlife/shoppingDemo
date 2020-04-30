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


public class ThreeColumnItemProvider extends BaseItemProvider<TestBean, BaseViewHolder> {
    @Override
    public int viewType() {
        return TestHomeAdapter.TYPE_THREE_COLUMN;
    }

    @Override
    public int layout() {
        return R.layout.app_item_home_three_column;
    }

    @Override
    public void convert(BaseViewHolder helper, TestBean data, int position) {
        helper.setText(R.id.item_tv, data.getGoodsName() + "");
        Glide.with(mContext)
                .load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1588249105533&di=6a73f7f23b5f23545c5161d05f3c4809&imgtype=0&src=http%3A%2F%2Fimg.tupianzj.com%2Fuploads%2Fallimg%2F150919%2F9-150919205I5.jpg")
                .dontAnimate()
                .into((AppCompatImageView) helper.getView(R.id.item_img));


    }
}
