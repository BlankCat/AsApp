package com.example.has.asapp.module.sticky.fgt;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.has.asapp.R;

/**
 * Created by has on 2018/3/29.
 */
public class Fragment1 extends android.support.v4.app.Fragment{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static Fragment1 newInstance() {

        Fragment1 fragment = new Fragment1();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.two,null);
    }
}
