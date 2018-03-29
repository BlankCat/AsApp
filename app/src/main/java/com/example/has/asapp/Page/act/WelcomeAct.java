package com.example.has.asapp.Page.act;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.example.has.asapp.Page.constant.PageConstant;
import com.example.has.asapp.R;
import com.ldfeng.shadow.SuperShadow;
import com.ldfeng.shadow.componet.ShadowDirection;

/**
 * Created by has on 2018/3/23.
 */
public class WelcomeAct extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initstatus();
        setContentView(R.layout.ll_welcome);
//        SuperShadow  superWrapShadowDirectionExample = new SuperShadow.Builder()
//                .setContext(this)
//                .setDirection(ShadowDirection.LEFT)
//                .setShadowSize(dip2Px(8))
//                .setCorner(dip2Px(4))
//                .setBaseShadowColor(Color.parseColor("#99cc00"))
//                .setImpl(SuperShadow.WRAP)
//                .action(wrapShadowLeftExample);


    }



    /**
     * 加载状态栏目
     * ctl+alt+m
     */
    private void initstatus() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT
		/*
		 * && android.os.Build.VERSION.SDK_INT <
		 * android.os.Build.VERSION_CODES.LOLLIPOP
		 */) {
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    public void goFgt01(View view){
        Toast.makeText(WelcomeAct.this, "goFgt01", Toast.LENGTH_SHORT).show();
        Intent recommendIntent = new Intent();
        recommendIntent.setClass(this,
                CenterAct.class);
        recommendIntent.putExtra(PageConstant.TO_PAGE_TAG,
                PageConstant.FGT_1);
        startActivity(recommendIntent);

    }
      public void goFgt02(View view){
            Toast.makeText(WelcomeAct.this, "goFgt02", Toast.LENGTH_SHORT).show();
          Intent recommendIntent = new Intent();
          recommendIntent.setClass(this,
                  CenterAct.class);
          recommendIntent.putExtra(PageConstant.TO_PAGE_TAG,
                  PageConstant.FGT_2);
          startActivity(recommendIntent);
        }
      public void goFgt03(View view){
            Toast.makeText(WelcomeAct.this, "goFgt03", Toast.LENGTH_SHORT).show();
          Intent recommendIntent = new Intent();
          recommendIntent.setClass(this,
                  CenterAct.class);
          recommendIntent.putExtra(PageConstant.TO_PAGE_TAG,
                  PageConstant.FGT_3);
          startActivity(recommendIntent);
        }

}
