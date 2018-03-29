package com.example.has.asapp.ui.dialog;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.LinearLayout;

import com.example.has.asapp.ui.ServiceDialog;


public class DialogActivityView extends FragmentActivity {

    private ServiceDialog serviceDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        LinearLayout layout2;
        layout2 = new LinearLayout(this);
        layout2.setBackgroundColor(Color.TRANSPARENT);
        setContentView(layout2);
        serviceDialog = new ServiceDialog(this, getIntent().getStringExtra("phone") + "");
        serviceDialog.toggle();
    }


}
