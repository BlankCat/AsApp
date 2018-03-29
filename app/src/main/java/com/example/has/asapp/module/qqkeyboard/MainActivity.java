package com.example.has.asapp.module.qqkeyboard;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.has.asapp.R;

import java.util.ArrayList;
/**
 * Created by has on 2018/3/28.
 * 仿qq软键盘
 * 特效就是
 * 向上滑动就会弹出键盘
 * 向下滑动软件盘消失
 * https://github.com/lijingzhao2008/QQKeyBoard
 */
public class MainActivity  extends BaseKeyBoardActivity {

    private ListView mLV;
    private RelativeLayout content;
    private EditText et;
    private ArrayList<String> list;

    @Override
    public int setLayoutID() {
        return R.layout.act_qq_keyboard;
    }

    @Override
    public ViewGroup findRootView() {
        content = (RelativeLayout) findViewById(R.id.content);
        mLV = (ListView) findViewById(R.id.lv);
        return content;
    }

    @Override
    public EditText findEditText() {
        et = (EditText) findViewById(R.id.et);

        return et;
    }

    @Override
    public boolean isShowKeyboard() {
        int lastVisiblePosition = mLV.getLastVisiblePosition();
        if (lastVisiblePosition == list.size() - 1) {
            return true;
        }
        return false;
    }

    @Override
    public void initView() {


        list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("data" + i);
        }
        mLV.setAdapter(new MyAdapter());

        mLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), list.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                switch (getItemViewType(position)) {
                    case 0:
                        convertView = View.inflate(getApplicationContext(), R.layout.item_right, null);
                        break;
                    case 1:
                        convertView = View.inflate(getApplicationContext(), R.layout.item_left, null);
                        break;
                }
            }
            switch (getItemViewType(position)) {
                case 0:
                    TextView tv = (TextView) convertView.findViewById(R.id.tv_me);
                    tv.setText(list.get(position));
                    break;
                case 1:
                    TextView tv2 = (TextView) convertView.findViewById(R.id.tv_other);
                    tv2.setText(list.get(position));
                    break;
            }
            return convertView;
        }

        @Override
        public int getViewTypeCount() {
            return 2;
        }

        @Override
        public int getItemViewType(int position) {
            if (position % 2 == 0) {
                return 0;
            } else {
                return 1;
            }
        }
    }

}
