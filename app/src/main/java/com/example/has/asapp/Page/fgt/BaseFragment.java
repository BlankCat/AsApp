package com.example.has.asapp.Page.fgt;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by has on 2018/3/23.
 */
public class BaseFragment extends Fragment {
    public BaseFragment() {
        // TODO Auto-generated constructor stub
    }
    /**
     * 所有继承BackHandledFragment的子类都将在这个方法中实现物理Back键按下后的逻辑
     * FragmentActivity捕捉到物理返回键点击事件后会首先询问Fragment是否消费该事件
     * 如果没有Fragment消息时FragmentActivity自己才会消费该事件
     */
    public boolean onBackPressed() {
        return false;
    }

    protected BackHandledInterface mBackHandledInterface;
    protected BaseFragment mCurrentFragment = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!(getActivity() instanceof BackHandledInterface)) {
            mBackHandledInterface = null;
            // throw new
            // ClassCastException("Hosting Activity must implement BackHandledInterface");
        } else {
            this.mBackHandledInterface = (BackHandledInterface) getActivity();
        }
//		EventBus.getDefault().register(this);
    }

    @Override
    public void onStart() {
        // 告诉FragmentActivity，当前Fragment在栈顶
        mCurrentFragment = this;
        setSelectedFragment();
        super.onStart();
    }

    protected void setSelectedFragment() {
        if (mBackHandledInterface != null) {
            mBackHandledInterface.setSelectedFragment(this);
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
//		EventBus.getDefault().unregister(this);
    }
}
