package com.example.has.asapp.Page.act;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.WindowManager;

import com.example.has.asapp.Page.constant.PageConstant;
import com.example.has.asapp.Page.fgt.Fragment01;
import com.example.has.asapp.Page.fgt.Fragment02;
import com.example.has.asapp.Page.fgt.Fragment03;
import com.example.has.asapp.R;

/**
 * Created by has on 2018/3/23.
 * 聚合Fragment，首页面设置跳转类型，
 * 跳转到目标的fragment页面
 */
public class CenterAct extends FragmentActivity {

    private Intent mRIntent;
    private int targetPageId;
    private FragmentManager mFmanager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_center);
        initstatus();
        inin();
        initView();
    }

    /**
     * 加载状态栏目
     * ctl+alt+m
     */
    private void initstatus() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT
		/*
		 * && android.os.Build.VERSION.SDK_INT <
		 * android.os.Build.VERSION_CODES.LOLLIPOP
		 */) {
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    private void initView() {
        switch (targetPageId){
            case PageConstant.FGT_1://显示页面1
                Fragment01 fgt01 = new Fragment01();
                addFragment(fgt01, false, R.id.fl_fragment_replace_list_layout);
                showFragment(fgt01);
                break;
            case PageConstant.FGT_2://显示页面2
                Fragment02 fgt2 = new Fragment02();
                addFragment(fgt2, false, R.id.fl_fragment_replace_home_layout);
                showFragment(fgt2);
                break;
            case PageConstant.FGT_3://显示页面3
                Fragment03 fgt03 = new Fragment03();
                addFragment(fgt03, false, R.id.fl_fragment_replace_package_detail_layout);
                showFragment(fgt03);
                break;


        }
    }

    private void inin() {
        mRIntent=getIntent();
        targetPageId = mRIntent.getIntExtra(PageConstant.TO_PAGE_TAG,PageConstant.FGT_1);
        mFmanager = getSupportFragmentManager();
    }

    /**
     * 添加fragment;
     *
     * @param fm
     * @param isAddToStack
     *            是否添加到回退栈;
     * @param  isReplaces
     *            是否替换当前的frame布局;
     */
    private void addFragment(Fragment fm, boolean isAddToStack, int resourceId) {

        if (fm != null) {

            FragmentTransaction beginTransaction = mFmanager.beginTransaction();
            beginTransaction.add(resourceId, fm, fm.getClass().toString());
            if (isAddToStack) {
                beginTransaction.addToBackStack(null);
            }
            beginTransaction.hide(fm);
            beginTransaction.commit();
        }
    }

    /**
     * 隐藏fragment;
     *
     * @param fm
     */
    private void hideFragment(Fragment fm) {
        if (fm != null) {
            FragmentTransaction beginTransaction = mFmanager.beginTransaction();
            beginTransaction.hide(fm);
            beginTransaction.commit();
        }
    }

    /**
     * 显示fragment;
     *
     * @param fm
     */
    private void showFragment(Fragment fm) {
        if (fm != null) {
            FragmentTransaction beginTransaction = mFmanager.beginTransaction();
            beginTransaction
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
            // beginTransaction.setCustomAnimations(R.anim.fragment_push_left_in,
            // R.anim.fragment_push_left_out);
            beginTransaction.show(fm);
            beginTransaction.commit();
        }
    }
}
