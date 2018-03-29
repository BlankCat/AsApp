package com.example.has.asapp.module.lazyload.adapter;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by has on 2018/3/28.
 */
public class ContentAdapter extends FragmentPagerAdapter {

    private List<Fragment> mListData;

    public ContentAdapter(FragmentManager fm) {
        super(fm);
    }

    public ContentAdapter(FragmentManager fm, List<Fragment> listData) {
        super(fm);
        this.mListData = listData;
    }

    public void setListData(List<Fragment> listData) {
        if (listData == null) {
            return;
        }
        this.mListData = listData;
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return mListData.get(position);
    }

    @Override
    public int getCount() {
        return mListData == null ? 0 : mListData.size();
    }
}
