package com.example.has.asapp.module.barrage;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.has.asapp.R;
import com.example.has.asapp.module.barrage.view.XCDanmuView;

import java.util.List;
/**
 * Created by has on 2018/3/29.
 * https://github.com/jczmdeveloper/XCDanmuView
 * 弹幕接口
 * https://www.cnblogs.com/JczmDeveloper/p/4872460.html
 */
public class MainActivity extends Activity {

    private XCDanmuView mDanmuView;
    private List<View> mViewList;
    private String[] mStrItems = {
            "搜狗","百度",
            "腾讯","360",
            "阿里巴巴","搜狐",
            "网易","新浪",
            "搜狗-上网从搜狗开始","百度一下,你就知道",
            "必应搜索-有求必应","好搜-用好搜，特顺手",
            "Android-谷歌","IOS-苹果",
            "Windows-微软","Linux"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_barrage_main);
        initDanmuView();
        initListener();
    }

    private void initListener() {
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mDanmuView.isWorking()) {
                    mDanmuView.hide();
                    ((Button) view).setText("开启弹幕");
                } else {
                    mDanmuView.start();
                    ((Button) view).setText("关闭弹幕");
                }
            }
        });
    }

    private void initDanmuView() {
        mDanmuView = (XCDanmuView)findViewById(R.id.danmu);
//        mDanmuView.setDirection(XCDanmuView.XCDirection.FORM_LEFT_TO_RIGHT);
        mDanmuView.initDanmuItemViews(mStrItems);
    }

}
