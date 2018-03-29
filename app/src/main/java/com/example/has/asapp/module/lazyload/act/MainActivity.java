package com.example.has.asapp.module.lazyload.act;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.has.asapp.R;
import com.example.has.asapp.module.lazyload.adapter.ContentAdapter;
import com.example.has.asapp.module.lazyload.fgt.FragmentFive;
import com.example.has.asapp.module.lazyload.fgt.FragmentFour;
import com.example.has.asapp.module.lazyload.fgt.FragmentOne;
import com.example.has.asapp.module.lazyload.fgt.FragmentThree;
import com.example.has.asapp.module.lazyload.fgt.FragmentTwo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by has on 2018/3/28
 * 懒加载数据
 * https://www.jianshu.com/p/6888bd8c1102.
 * https://www.jianshu.com/p/c5d29a0c3f4c
 */
public class MainActivity  extends AppCompatActivity {

    private ViewPager mContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_lazy_main);
        mContent = (ViewPager) findViewById(R.id.content);

        mContent.setOffscreenPageLimit(5);//设置为全部预加载

        List<Fragment> listData = new ArrayList<>();
        FragmentOne one = new FragmentOne();
        FragmentTwo two = new FragmentTwo();
        FragmentThree three = new FragmentThree();
        FragmentFour four = new FragmentFour();
        FragmentFive five = new FragmentFive();
        listData.add(one);
        listData.add(two);
        listData.add(three);
        listData.add(four);
        listData.add(five);
//		ContentAdapter adapter = new ContentAdapter(getSupportFragmentManager(), listData);
//		mContent.setAdapter(adapter);

        ContentAdapter adapter1 = new ContentAdapter(getSupportFragmentManager());
        mContent.setAdapter(adapter1);
        adapter1.setListData(listData);
    }
}

