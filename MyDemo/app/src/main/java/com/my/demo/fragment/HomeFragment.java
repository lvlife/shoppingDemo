package com.my.demo.fragment;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.ColorUtils;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.my.demo.R;
import com.my.demo.adapter.TestHomeAdapter;
import com.my.demo.base.BaseFragment;
import com.my.demo.bean.TestBean;
import com.my.demo.utils.GlideImageLoader;
import com.my.demo.widget.MarqueeView;
import com.youth.banner.Banner;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2018/7/6.
 * Describe:
 */

public class HomeFragment extends BaseFragment {
    private LinearLayout mToolbar;
    private RecyclerView mRecyclerView;
    private List<TestBean> data;
    private int height;

    @Override
    public int getLayoutId() {
        return R.layout.app_fragment_home;
    }


    @Override
    public void initView(View mView) {
        mToolbar = mView.findViewById(R.id.toolbar);
        mRecyclerView = mView.findViewById(R.id.app_home_list);
    }

    @Override
    public void lazyLoad() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 6);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        String jsonData = new String(getAssertsFile(getContext(), "content.json"));
        data = new Gson().fromJson(jsonData, new TypeToken<List<TestBean>>() {
        }.getType());
        TestHomeAdapter adapter = new TestHomeAdapter();
        adapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
            @Override
            public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
                int type = data.get(position).getType();
                if (type == 1 || type == 3 || type == 2 || type == 5 || type == 6) {
                    return 6;
                } else if (type == 4) {
                    return 2;
                } else if (type == 7) {
                    return 3;
                }
                return 0;
            }
        });
        mRecyclerView.setAdapter(adapter);
        adapter.setHeaderView(getHeaderView(mRecyclerView));
        adapter.setNewData(data);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            private int totalDy = 0;
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                totalDy += dy;
                if (totalDy <= height) {
                    float alpha = (float) totalDy / height;
                    mToolbar.setBackgroundColor(ColorUtils.blendARGB(Color.TRANSPARENT
                            , ContextCompat.getColor(getContext(), R.color.white), alpha));
                } else {
                    mToolbar.setBackgroundColor(ColorUtils.blendARGB(Color.TRANSPARENT
                            , ContextCompat.getColor(getContext(), R.color.white), 1));
                }
            }
        });
    }

    private View getHeaderView(RecyclerView v) {
        List<String> bannerImg = new ArrayList<>();
        bannerImg.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1530962561545&di=f6af0eb6d96e5540baf2ce3bc96dca38&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F0118a6576505160000018c1bc1c1d9.jpg%401280w_1l_2o_100sh.jpg");
        bannerImg.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1530962666446&di=d7d90171e1fd6cc69352b73e2f8df529&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F017338576505290000012e7e45db9f.jpg%401280w_1l_2o_100sh.jpg");
        bannerImg.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1531557498&di=5e4a5342ae724f219b004ccad7b6fa82&imgtype=jpg&er=1&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F017e0458212939a84a0e282bca0f71.jpg%401280w_1l_2o_100sh.jpg");
        bannerImg.add("http://58.87.71.247:8080/TestFile/banner.png");
        View convertView = LayoutInflater
                .from(getContext())
                .inflate(R.layout.app_include_home_header, (ViewGroup) v.getParent(), false);
        Banner mBanner = convertView.findViewById(R.id.app_home_header_banner);
        mBanner.setImages(bannerImg)
                .setImageLoader(new GlideImageLoader())
                .setDelayTime(3000)
                .start();


        MarqueeView marqueeView=convertView.findViewById(R.id.app_home_header_problem);

        List<String> problems=new ArrayList<>();
        problems.add("如何获取更多个人积分");
        problems.add("下单时服务费率规则");
        problems.add("大额预定商品详细交易流程");
        marqueeView.startWithList(problems);

        ViewGroup.LayoutParams bannerParams = mBanner.getLayoutParams();
        int resourceId = getContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
        int statusBarHeight = getContext().getResources().getDimensionPixelSize(resourceId);
        height = bannerParams.height - statusBarHeight - 104;

        return convertView;
    }


    public static byte[] getAssertsFile(Context context, String fileName) {
        InputStream inputStream = null;
        AssetManager assetManager = context.getAssets();
        try {
            inputStream = assetManager.open(fileName);
            if (inputStream == null) {
                return null;
            }

            BufferedInputStream bis = null;
            int length;
            try {
                bis = new BufferedInputStream(inputStream);
                length = bis.available();
                byte[] data = new byte[length];
                bis.read(data);

                return data;
            } catch (IOException e) {

            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (Exception e) {

                    }
                }
            }

            return null;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
