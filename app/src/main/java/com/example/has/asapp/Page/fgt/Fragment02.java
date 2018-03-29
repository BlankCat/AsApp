package com.example.has.asapp.Page.fgt;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.has.asapp.Page.act.CenterAct;
import com.example.has.asapp.R;

/**
 * Created by has on 2018/3/23.
 * 实现父类方法 ctrl+o
 */
public class Fragment02 extends LazyFragment {
    public static final String TAG="Fragment02";
    CenterAct mCenterAct;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        mCenterAct = (CenterAct) getActivity();
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mRootView = inflater.inflate(R.layout.fgt_02, container, false);
        return mRootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG,TAG+"--onStart");
    }


    @Override
    protected void lazyLoad() {

    }
}
