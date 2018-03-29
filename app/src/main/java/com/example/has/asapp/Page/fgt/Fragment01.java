package com.example.has.asapp.Page.fgt;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;

import com.example.has.asapp.Page.act.CenterAct;
import com.example.has.asapp.R;

/**
 * Created by has on 2018/3/23.
 * 实现父类方法 ctrl+o
 */
public class Fragment01 extends LazyFragment {
    public static final String TAG="Fragment01";
    CenterAct mCenterAct;
    private LinearLayout rootView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        mCenterAct = (CenterAct) getActivity();
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mRootView = inflater.inflate(R.layout.fgt_01, container, false);
        rootView=(LinearLayout)mRootView.findViewById(R.id.rooview);

        return mRootView;
    }

    private void startAnim() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f,
                1.0f, 0.0f, 1.0f, ScaleAnimation.RELATIVE_TO_SELF,
                0.5f, ScaleAnimation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(800);
        rootView.setAnimation(scaleAnimation);
        scaleAnimation.startNow();
    }

    @Override
    public void onResume() {
        super.onResume();
        startAnim();
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
