package com.example.has.asapp.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by has on 2018/3/22.
 */
public class FlowLayout extends ViewGroup{
    private static final String TAG = "FlowLayout";

    /**
     * 存储所有的View，按行记录
     *
     */
    private List<List<View>> mAllViews=new ArrayList<List<View>>();

    /**
     * 记录每一行的最大高度
     */
    private List<Integer> mLineHight=new ArrayList<>();




    public FlowLayout(Context context){
        super(context);
    }
    public FlowLayout(Context context,AttributeSet attrs){
        super(context,attrs);
    }

    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        return new MarginLayoutParams(p);
    }
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(),attrs);
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int sizeWith=MeasureSpec.getSize(widthMeasureSpec);
        int sizeHight=MeasureSpec.getSize(heightMeasureSpec);
        int modeWidth=MeasureSpec.getMode(widthMeasureSpec);
        int modeHight=MeasureSpec.getMode(heightMeasureSpec);
        int width=0;
        int hight=0;
        /**
         * 记录每一行的宽度，width不断取最大宽度
         */
        int lineWidth=0;
        /**
         * 每一行的高度，累加至height
         */
        int lineHight=0;
        int cCount=getChildCount();
        for (int i=0;i<cCount;i++){
            View child=getChildAt(i);
            // 测量每一个child的宽和高
            measureChild(child,widthMeasureSpec,heightMeasureSpec);
            // 得到child的lp
            MarginLayoutParams lp=(MarginLayoutParams)child.getLayoutParams();
            // 当前子空间实际占据的宽度
            int childWidth=child.getMeasuredWidth()+lp.leftMargin+lp.rightMargin;
            // 当前子空间实际占据的高度
            int childHight=child.getMeasuredHeight()+lp.topMargin+lp.bottomMargin;
            /**
             * 如果加入当前child，则超出最大宽度，则的到目前最大宽度给width，类加height 然后开启新行
             */
            if(lineWidth+childHight>sizeHight){
                width=Math.max(lineWidth,childWidth);// 取最大的
                lineWidth=childWidth;// 重新开启新行，开始记录
                // 叠加当前高度，
                hight +=lineHight;
                // 开启记录下一行的高度
                lineHight=childHight;

            }else
            // 否则累加值lineWidth,lineHeight取最大高度
            {
                lineWidth +=childWidth;
                lineHight = Math.max(lineHight,childHight);

            }

            // 如果是最后一个，则将当前记录的最大宽度和当前lineWidth做比较
            if(i==cCount-1){
                width=Math.max(width,lineHight);
                hight += lineHight;
            }
        }
        setMeasuredDimension((modeWidth==MeasureSpec.EXACTLY)?sizeWith:width,
                (modeHight==MeasureSpec.EXACTLY)?sizeHight:hight);

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        mAllViews.clear();
        mLineHight.clear();
        int width=getWidth();
        int lineWidth=0;
        int lineHight=0;
        // 存储每一行所有的childView
        List<View> lineViews=new ArrayList<>();
        int cCount=getChildCount();
        // 遍历所有的孩子
        for (int i=0;i<cCount;i++){
            View child=getChildAt(i);
            MarginLayoutParams lp=(MarginLayoutParams)child.getLayoutParams();
            int childWidth=child.getMeasuredWidth();
            int childHight=child.getMeasuredHeight();
            if(childWidth+lp.leftMargin+lp.rightMargin+lineWidth>width){
                // 记录这一行所有的View以及最大高度
                mLineHight.add(lineHight);
                // 将当前行的childView保存，然后开启新的ArrayList保存下一行的childView
                mAllViews.add(lineViews);

                lineWidth=0;// 重置行宽
                lineViews=new ArrayList<>();

            }

            lineWidth +=childWidth+lp.leftMargin+lp.rightMargin;
            lineHight=Math.max(lineHight,childHight+lp.topMargin+lp.bottomMargin);
            lineViews.add(child);
        }

        // 记录最后一行
        mLineHight.add(lineHight);
        mAllViews.add(lineViews);


        int left=0;
        int top=0;
        // 得到总行数
        int lineNum=mAllViews.size();
        for (int i=0;i<lineNum;i++){
            // 每一行的所有的views
            lineViews=mAllViews.get(i);
            // 当前行的最大高度
            lineHight=mLineHight.get(i);

            for (int j=0;j<lineViews.size();j++){
                View child=lineViews.get(j);
                if(child.getVisibility() == View.GONE){
                    continue;
                }
                MarginLayoutParams lp=(MarginLayoutParams)child.getLayoutParams();
                //计算childView的left,top,right,bottom
                int lc=left+lp.leftMargin;
                int tc=top+lp.topMargin;
                int rc=lc+child.getMeasuredWidth();
                int bc=tc+child.getMeasuredHeight();
                child.layout(lc,tc,rc,bc);
                left +=child.getMeasuredWidth()+lp.rightMargin+lp.leftMargin;

            }
            left =0;
            top +=lineHight;
        }

    }
}
