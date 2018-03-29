package com.example.has.asapp.module.textview;

import android.app.Activity;
import android.os.Bundle;

import com.example.has.asapp.R;

/**
 * Created by has on 2018/3/29.
 * https://github.com/droidwolf
 * https://github.com/droidwolf/superscriptview
 *
 */
public class MainActivity extends Activity {
    /**
     *  https://blog.csdn.net/p106786860/article/details/53943540
     *  android命名空间：xmlns:android="http://schemas.android.com/apk/res/android;
        tools命名空间：xmlns:tools="http://schemas.android.com/tools;
        自定义命名空间：xmlns:app="http://schemas.android.com/apk/res-auto"
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_tv_script);
    }
}
