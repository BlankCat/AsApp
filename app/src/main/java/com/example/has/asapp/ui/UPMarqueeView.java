package com.example.has.asapp.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ViewFlipper;

import com.example.has.asapp.R;

import java.util.List;

/**
 * Created by has on 2018/3/22.
 *
 */
public class UPMarqueeView extends ViewFlipper {
    private Context context;
    private boolean isSetAnimainDuration=false;
    private int interval = 3000;
    /**
     * 动画的时间
     */
    private int animalDuration=1000;

    public UPMarqueeView(Context context, AttributeSet attrs){
        super(context,attrs);
        init(context,attrs,0);
    }
    private void init(Context context, AttributeSet attrs,int defaultStyleAttr){
        this.context=context;
        setFlipInterval(interval);
        Animation animIn = AnimationUtils.loadAnimation(context, R.anim.anim_marquee_in);
        if(isSetAnimainDuration)animIn.setDuration(animalDuration);
        setInAnimation(animIn);
        Animation animOut=AnimationUtils.loadAnimation(context,R.anim.anim_marquee_out);
        if(isSetAnimainDuration)animOut.setDuration(animalDuration);
        setOutAnimation(animOut);
    }

    public void setViews(final List<View> views){
        if(views==null || views.size()==0) return;;
        removeAllViews();
        for (int i=0;i<views.size();i++){
            final int postion=i;
            views.get(i).setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(onItemClickListener!=null){
                        onItemClickListener.onIntemClick(postion,views.get(postion));
                    }
                }
            });

            addView(views.get(i));
        }
        startFlipping();
    }
    private OnItemClickListener onItemClickListener;
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }
    public interface OnItemClickListener{
        void onIntemClick(int postion,View view);
    }

}
