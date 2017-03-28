package com.magic.dusan.indicatorview;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.magic.dusan.indicatorview.indicator.IndicatorView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mPager;
    private View mPage1,mPage2,mPage3;
    private List<View> mPageList;

    private IndicatorView mIndicatorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initViewPager();
    }

    private void initView() {
        mPager = (ViewPager) findViewById(R.id.id_main_vp);
        mIndicatorView = (IndicatorView) findViewById(R.id.id_view_indicator);

        mPage1 = new View(this);
        mPage2 = new View(this);
        mPage3 = new View(this);
        mPage1.setBackgroundResource(android.R.color.holo_blue_light);
        mPage2.setBackgroundResource(android.R.color.holo_red_light);
        mPage3.setBackgroundResource(android.R.color.holo_orange_light);
    }

    private void initData() {
        mPageList = new ArrayList<>();
        mPageList.add(mPage1);
        mPageList.add(mPage2);
        mPageList.add(mPage3);
    }

    private void initViewPager() {
        MyPagerAdapter pagerAdapter = new MyPagerAdapter();
        mPager.setAdapter(pagerAdapter);
        mIndicatorView.setViewPager(mPager);
    }

    class MyPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mPageList.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            // TODO Auto-generated method stub
            return arg0 == arg1;
        }


        @Override
        public void destroyItem(ViewGroup container, int position,
                                Object object) {
            // TODO Auto-generated method stub
            container.removeView(mPageList.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            // TODO Auto-generated method stub
            container.addView(mPageList.get(position));


            return mPageList.get(position);
        }
    }

}
