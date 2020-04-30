package com.my.demo.adapter;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.MultipleItemRvAdapter;
import com.my.demo.bean.TestBean;
import com.my.demo.provider.ImgAndTextItemProvider;
import com.my.demo.provider.ImgItemProvider;
import com.my.demo.provider.NarrowImgItemProvider;
import com.my.demo.provider.ScrollItemProvider;
import com.my.demo.provider.TextItemProvider;
import com.my.demo.provider.ThreeColumnItemProvider;
import com.my.demo.provider.TwoColumnItemProvider;


/**
 * Created by Administrator on 2018/6/30.
 * Describe:
 */

public class TestHomeAdapter extends MultipleItemRvAdapter<TestBean, BaseViewHolder> {
    //通栏商品大图片
    public static final int TYPE_IMG = 100;
    //通栏图文
    public static final int TYPE_TEXT_AND_IMG = 200;
    //通栏文本
    public static final int TYPE_TEXT = 300;
    //三列
    public static final int TYPE_THREE_COLUMN = 400;
    //通栏水平拖动
    public static final int TYPE_HORIZONTAL_SCROLL = 500;
    //通栏窄图片
    public static final int TYPE_NARROW_IMG = 600;
    //两列
    public static final int TYPE_TWO_COLUMN = 700;
    public TestHomeAdapter() {
        super(null);
        finishInitialize();

    }

    @Override
    protected int getViewType(TestBean testBean) {
        int type = testBean.getType();
        if (type == 1) {
            return TYPE_IMG;
        } else if (type == 2) {
            return TYPE_TEXT_AND_IMG;
        } else if (type == 3) {
            return TYPE_TEXT;
        } else if (type == 4) {
            return TYPE_THREE_COLUMN;
        } else if (type == 5) {
            return TYPE_HORIZONTAL_SCROLL;
        } else if (type == 6) {
            return TYPE_NARROW_IMG;
        } else if (type == 7) {
            return TYPE_TWO_COLUMN;
        }
        return 0;
    }

    @Override
    public void registerItemProvider() {
        //通栏商品大图片
        mProviderDelegate.registerProvider(new ImgItemProvider());
        //通栏图文
        mProviderDelegate.registerProvider(new ImgAndTextItemProvider());
        //通栏文本
        mProviderDelegate.registerProvider(new TextItemProvider());
        //三列图文
        mProviderDelegate.registerProvider(new ThreeColumnItemProvider());
        //通栏横向滑动
        mProviderDelegate.registerProvider(new ScrollItemProvider());
        //通栏窄图片
        mProviderDelegate.registerProvider(new NarrowImgItemProvider());
        //两列图文
        mProviderDelegate.registerProvider(new TwoColumnItemProvider());
    }
}
