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


public class ImgAndTextItemProvider extends BaseItemProvider<TestBean, BaseViewHolder> {
    @Override
    public int viewType() {
        return TestHomeAdapter.TYPE_TEXT_AND_IMG;
    }

    @Override
    public int layout() {
        return R.layout.app_item_home_img_and_text;
    }

    @Override
    public void convert(BaseViewHolder helper, TestBean data, int position) {
        helper.setText(R.id.item_tv_main_title, data.getGoodsName() + "")
                .setText(R.id.item_tv_subtitle, data.getGoodsDesc() + "");

        Glide.with(mContext)
                .load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1588249106016&di=919593638bd75bae2eb00b50ccc581d8&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F0%2F57b7cb43ebb25.jpg")
                .dontAnimate()
                .into((AppCompatImageView) helper.getView(R.id.item_double_img));
    }
}
