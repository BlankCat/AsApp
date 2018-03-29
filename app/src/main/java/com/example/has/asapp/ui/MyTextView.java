package com.example.has.asapp.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by has on 2018/3/22.
 */
public class MyTextView extends TextView {
    public MyTextView(Context context, AttributeSet attrs){
        super(context,attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //倾斜度45,上下左右居中倾斜角度-45，+45
        canvas.rotate(45,getMeasuredWidth()/2,getMeasuredHeight()/2);
        super.onDraw(canvas);

    }
}
