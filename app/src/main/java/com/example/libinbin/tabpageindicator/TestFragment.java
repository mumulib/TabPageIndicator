package com.example.libinbin.tabpageindicator;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by libinbin on 16/7/2.
 */
public class TestFragment extends Fragment {

    private TextView mTextView;

    private int mPageIndex;

    public static TestFragment newPage(int pageIndex){
        TestFragment testFragment=new TestFragment();
        testFragment.mPageIndex=pageIndex;

        return testFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FrameLayout fl=new FrameLayout(getActivity());
        fl.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mTextView=new TextView(getActivity());
        mTextView.setText("这是第"+mPageIndex+"页");
        fl.addView(mTextView);

        return fl;
    }


}
