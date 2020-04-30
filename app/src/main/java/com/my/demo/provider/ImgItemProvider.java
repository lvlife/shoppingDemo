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


public class ImgItemProvider extends BaseItemProvider<TestBean, BaseViewHolder> {
    @Override
    public int viewType() {
        return TestHomeAdapter.TYPE_IMG;
    }

    @Override
    public int layout() {
        return R.layout.app_item_home_img;
    }

    @Override
    public void convert(BaseViewHolder helper, TestBean data, int position) {
        Glide.with(mContext)
                .load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1588249105529&di=89242c0224f7cb60fd652b4528941d88&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fpic%2Ff%2Fa6%2Fbdcf511511.jpg")
                .dontAnimate()
                .into((AppCompatImageView) helper.getView(R.id.item_img));
    }
}
