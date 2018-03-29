package com.example.has.asapp.module.lazyload.fgt;
import com.example.has.asapp.R;
import com.example.has.asapp.module.lazyload.fgt.base.LazyFragment;
import android.os.SystemClock;
import android.util.Log;
import android.widget.TextView;
/**
/**
 * Created by has on 2018/3/28.
 */
public class FragmentFour extends LazyFragment {

    private static final String TAG = "DD";
    private TextView mTextView;
    private String mSimpleName;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_one;
    }

    @Override
    public void initview() {
        mTextView = (TextView) mFragment.findViewById(R.id.tv);
        mSimpleName = getClass().getSimpleName();
        mTextView.setText(mSimpleName);
    }

    @Override
    public void initLazyLodeData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    SystemClock.sleep(150);
                    Log.i(TAG, mSimpleName + "----->initLazyLodeData:懒加载数据 ");
                }
            }
        }).start();
    }

    @Override
    public void initData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    SystemClock.sleep(100);
                    Log.e(TAG, mSimpleName + "----->initData:普通加载数据 ");
                }
            }
        }).start();
    }

    @Override
    public void initEvent() {

    }

    @Override
    public void InVisibleEvent() {

    }
}