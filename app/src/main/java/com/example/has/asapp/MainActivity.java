package com.example.has.asapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.has.asapp.ui.FlowLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    /** 最近搜索 */
    private FlowLayout mSearchLately;
    private List<String> mKeywordList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intDate(mKeywordList);
        mSearchLately = (FlowLayout) findViewById(R.id.market_search_lately);
        setFlowLayout(mKeywordList, mSearchLately);
    }
    private LinearLayout.LayoutParams setFlowLayout( List<String> wordList,
                                                    FlowLayout flowLayout) {
        flowLayout.removeAllViews();
        LinearLayout.LayoutParams ll=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT
        , ViewGroup.LayoutParams.WRAP_CONTENT);
        ll.setMargins(0,0,20,10);
        for(int i=0;i<wordList.size();i++){
            TextView tag_View=new TextView(this);
            tag_View.setLayoutParams(ll);
            tag_View.setText(wordList.get(i));
            tag_View.setTextColor(0xff838383);
            tag_View.setGravity(Gravity.CENTER);
//            tag_View.setBackgroundDrawable();
            tag_View.setSingleLine();
            tag_View.setMaxEms(20);
            tag_View.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            tag_View.setPadding(10,0,10,0);
            final String countText=wordList.get(i);
            tag_View.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this,countText, Toast.LENGTH_SHORT).show();
                }
            });
            flowLayout.addView(tag_View);
        }
        return  ll;
    }
    private void intDate(List<String> mKeywordList){
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
