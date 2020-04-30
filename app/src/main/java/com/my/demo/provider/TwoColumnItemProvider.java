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


public class TwoColumnItemProvider extends BaseItemProvider<TestBean, BaseViewHolder> {
    @Override
    public int viewType() {
        return TestHomeAdapter.TYPE_TWO_COLUMN;
    }

    @Override
    public int layout() {
        return R.layout.app_item_home_two_column;
    }

    @Override
    public void convert(BaseViewHolder helper, TestBean data, int position) {
            helper.setText(R.id.item_goods_price, "￥："+data.getGoodsPrice())
                    .setText(R.id.item_goods_name, data.getGoodsId()+"");
            Glide.with(mContext)
                    .load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1588249105532&di=b6b110bc80827813b29f9f0a4a0d33f7&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201703%2F11%2F20170311234132_vFT8Z.thumb.700_0.jpeg")
                    .dontAnimate()
                    .into((AppCompatImageView) helper.getView(R.id.item_goods_img));

    }
}
