package com.example.has.asapp.module.textview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.has.asapp.R;
import com.example.has.asapp.module.textview.view.XCColorTrackTextView;

/**
 * Created by has on 2018/3/29.
 */
public class SecondAct extends Activity {

    private XCColorTrackTextView mView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_second_textview);
        mView = (XCColorTrackTextView) findViewById(R.id.color_track_view);
        mView.postDelayed(new Runnable() {
            @Override
            public void run() {
                mView.setProgress(mView.getWidth() / 2);
            }
        },100);
        init();
    }
    int mProgress = 0;
    private void init(){

        findViewById(R.id.btn_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mProgress = 0;
                new Thread(){
                    @Override
                    public void run() {
                        while(mProgress < mView.getMax()){
                            test();
                            try {
                                Thread.sleep(2);
                                mProgress ++;
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }.start();
            }
        });
    }
    private void test(){
        mView.setProgress(mProgress);
    }
}