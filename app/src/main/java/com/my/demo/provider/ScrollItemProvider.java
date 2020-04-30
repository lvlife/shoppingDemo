package com.my.demo.provider;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.my.demo.R;
import com.my.demo.adapter.TestHomeAdapter;
import com.my.demo.adapter.TestItemAdapter;
import com.my.demo.bean.TestBean;

/**
 * Created by 吕氏春秋i 2020/4/30
 * Describe:
 */


public class ScrollItemProvider extends BaseItemProvider<TestBean, BaseViewHolder> {
    @Override
    public int viewType() {
        return TestHomeAdapter.TYPE_HORIZONTAL_SCROLL;
    }

    @Override
    public int layout() {
        return R.layout.app_item_home_scroll;
    }

    @Override
    public void convert(BaseViewHolder helper, TestBean data, int position) {
        RecyclerView mRecyclerView = helper.getView(R.id.item_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        TestItemAdapter adapter = new TestItemAdapter();
        adapter.setNewData(data.getGoodsInfo());
        mRecyclerView.setAdapter(adapter);
    }
}
