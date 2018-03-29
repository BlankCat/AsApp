package com.example.has.asapp.module.design;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.example.has.asapp.R;

/**
 * Created by has on 2018/3/29.
 * TextInputLayout输入框悬浮标签的具体代码
 * 监听输入框的内容
 * 添加依赖
 * 使用控件
 * http://www.jb51.net/article/129691.htm
 */
public class TextInputLayoutAct extends Activity {
    /**
     * dependencies {
         compile 'com.android.support:design:23.3.0'
         }
     */
    EditText etUser;
    TextInputLayout tilUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_text_input);
        etUser= (EditText) findViewById(R.id.et_user);
        tilUser= (TextInputLayout) findViewById(R.id.til_user);
        //添加文本变化监听
        etUser.addTextChangedListener(new TextWatcher() {
            @Override
            //输入文本之前调用
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            //正在输入的时候调用
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()>6){
                    //打开TextInputLayout异常提示
                    tilUser.setErrorEnabled(true);
                    //设置TextInputLayout异常提示信息
                    tilUser.setError("账号最大长度为6");
                }else {
                    //关闭TextInputLayout异常提示
                    tilUser.setErrorEnabled(false);
                }
            }

            @Override
            //输入以后调用
            public void afterTextChanged(Editable s) {
            }
        });
    }
}
