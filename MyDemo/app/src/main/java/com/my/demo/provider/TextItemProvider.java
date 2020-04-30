package com.my.demo.provider;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.my.demo.R;
import com.my.demo.adapter.TestHomeAdapter;
import com.my.demo.bean.TestBean;

/**
 * Created by Administrator on 2018/6/30.
 * Describe:
 */

public class TextItemProvider extends BaseItemProvider<TestBean, BaseViewHolder> {
    @Override
    public int viewType() {
        return TestHomeAdapter.TYPE_TEXT;
    }

    @Override
    public int layout() {
        return R.layout.app_item_home_text;
    }

    @Override
    public void convert(BaseViewHolder helper, TestBean data, int position) {
        helper.setText(R.id.item_tv_main_title, data.getGoodsName()+"")
                .setText(R.id.item_tv_subtitle, data.getGoodsDesc()+"");
    }
}
