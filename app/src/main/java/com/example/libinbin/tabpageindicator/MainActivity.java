package com.example.libinbin.tabpageindicator;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;

import com.example.libinbin.tabpageindicator.view.TabPageIndicator;

public class MainActivity extends FragmentActivity {

    private String[] titles={"上衣","裤子","衬衫","鞋子","外衣","背包","箱子","皮鞋","牛仔","鞋子","外衣","背包","箱子","皮鞋","牛仔"};

    private ViewPager mViewPager;
    private TabPageIndicator mIndicator;
    private int mScreenWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        updateUI();
    }

    private void initData() {
        DisplayMetrics metrics=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        mScreenWidth=metrics.widthPixels;
    }

    private void updateUI() {
        mViewPager.setAdapter(new TestAdapter(getSupportFragmentManager()));
        mIndicator.setViewPager(mViewPager);
    }

    private void initView() {
        mViewPager= (ViewPager) findViewById(R.id.vp);
        mIndicator= (TabPageIndicator) findViewById(R.id.indicator);
        mIndicator.setTextSize(mScreenWidth/22);
        mIndicator.setTabPadding(mScreenWidth/22);

    }

    public class TestAdapter extends FragmentPagerAdapter{

        public TestAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return TestFragment.newPage(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

        @Override
        public int getCount() {
            return titles.length;
        }
    }


}
