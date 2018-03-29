package com.example.has.asapp.Page.act;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.has.asapp.R;
import com.example.has.asapp.ui.UPMarqueeView;
import com.example.has.asapp.ui.floatview.FloatViewHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by has on 2018/3/22.
 */
public class MainActivity extends Activity {
    private FloatViewHelper mFloatViewHelper;// 悬浮按钮帮助类
    /**
     * 头条滚动view
     */
    private UPMarqueeView mUpmvVipInfoView;
    private ArrayList<View> mVipViews;
    private List<String> mKeywordList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        mFloatViewHelper = FloatViewHelper.getInstance(this);
        initData();
        mUpmvVipInfoView = (UPMarqueeView) findViewById(R.id.upmv_market_home_vips_info);
        initUPMarqueeViews( mKeywordList);
        mFloatViewHelper.setPhoneNo("13838389438");
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mFloatViewHelper != null) {
            mFloatViewHelper.show();
        }
    }

    private void initUPMarqueeViews(final List<String> mKeywordList){
        mVipViews = new ArrayList<View>();
        ForegroundColorSpan redSpan=new ForegroundColorSpan(Color.RED);
        for (int i=0;i<mKeywordList.size();i++){
            String titleStr=mKeywordList.get(i);
            String bodyStr = mKeywordList.get(i);
            SpannableString spannableString=new SpannableString(bodyStr);
            spannableString.setSpan(redSpan,0,bodyStr.length()-1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            RelativeLayout moreView=(RelativeLayout) LayoutInflater.from(this).inflate(R.layout.item_market_home_vipinfo_news, null);
            //初始化布局的控件
            TextView title = (TextView) moreView.findViewById(R.id.tv_item_market_home_vipinfo_title);
            TextView body = (TextView) moreView.findViewById(R.id.tv_item_market_home_vipinfo_boby);
            title.setText(titleStr);
            body.setText(spannableString);
            mVipViews.add(moreView);
        }

        mUpmvVipInfoView.setViews(mVipViews);
        mUpmvVipInfoView.setOnItemClickListener(new UPMarqueeView.OnItemClickListener() {
            @Override
            public void onIntemClick(int postion, View view) {
                Toast.makeText(MainActivity.this, mKeywordList.get(postion), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData(){
        mKeywordList.add("热收");
        mKeywordList.add("热收哈哈");
        mKeywordList.add("热收关键词");
        mKeywordList.add("热收131321");
        mKeywordList.add("热收");
        mKeywordList.add("热收哈哈");
        mKeywordList.add("热收关键词");
        mKeywordList.add("热收131321");
        mKeywordList.add("热收");
        mKeywordList.add("热收哈哈");
        mKeywordList.add("热收关键词");
        mKeywordList.add("热收131321");
        mKeywordList.add("热收");
        mKeywordList.add("热收哈哈");
        mKeywordList.add("热收关键词");
        mKeywordList.add("热收131321");
    }
}
