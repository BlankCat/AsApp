package com.example.has.asapp.Page.act;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.has.asapp.R;
import com.example.has.asapp.adapter.VideoAdapter;
import com.example.has.asapp.bean.CsGkListBean;
import com.example.has.asapp.bean.StartActvityListTitleBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by has on 2018/3/28.
 *  StartActivityNew
 * 下拉刷新view
 * listview 添加头
 * 头数据和布局分离
 * 动态组合页面布局
 */
public class DemoAct extends Activity {
    private Context context=DemoAct.this;
    private LinearLayout mContainer;

    public List<CsGkListBean> csGkList=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_demo);
        init();
        applyPermission();
    }

    private void applyPermission() {
    }

    private void init() {
        initView();
        initData();

        getPhoneInfo();
        beginService();
        checkUpdate();
        showWelcome();
        jumpToLogin();
    }

    private void initData() {

        csGkList=new ArrayList<CsGkListBean>();
        for (int i=0;i<12;i++){
            CsGkListBean vo=new CsGkListBean();
            vo.courseId=i;
            vo.csName="律师专业课"+i;
            vo.csHour=Double.valueOf(i+"0");
            csGkList.add(vo);
        }
        setVideoData(csGkList);


    }
    private void initView() {
        findView();
        addListener();
        // initStatusBar();
        initBanner();
    }
    private void getPhoneInfo() {
    }
    private void beginService() {
    }
    private void showWelcome() {
    }
    private void checkUpdate() {
    }
    private void jumpToLogin() {
    }
    private void findView() {
        mContainer = (LinearLayout) findViewById(R.id.item_container);
    }
    private void addListener() {
    }
    private void initBanner() {
    }

    private void setVideoData(List<CsGkListBean> list) {
        final VideoAdapter adapter = new VideoAdapter(this, list);
        StartActvityListTitleBean bean = new StartActvityListTitleBean();
        bean.drawableId=R.drawable.img_start_activity_new_video;
        bean.name = "点视";
        bean.content = "精彩视频  每周更新";
        bean.listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.change();
            }
        };
        View.OnClickListener listener = new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"点击去跳转",Toast.LENGTH_SHORT).show();
            }
        };
        //填充头部header
        addVideoTitle(bean, listener);
        //填充体body
        addVideoNew(adapter);
        //填充尾部end
        addMore(listener);


    }



    /**
     * 绑定视图和数据
     * @param bean
     * @param listener
     * 做这种布局找页面的既是
     * 可以把布局文件复制到sublime上面，可以快速定位到资源id
     *
     *
     */
    private void addVideoTitle(StartActvityListTitleBean bean, View.OnClickListener listener) {
        if(null == bean)
            return;
        View titleView = View.inflate(this, R.layout.item_start_activity_new_video_title, null);
        TextView title = (TextView) titleView.findViewById(R.id.tv_item_name);
        title.setText(bean.name);

        Drawable drawable = getResources().getDrawable(bean.drawableId);
        drawable.setBounds(0,0,drawable.getMinimumWidth(),drawable.getMinimumHeight());
        title.setCompoundDrawables(drawable,null,null,null);//设置左边为图标

        TextView content = ((TextView) titleView.findViewById(R.id.tv_item_content));
        content.setText(bean.content);

        TextView change = (TextView) titleView.findViewById(R.id.tv_item_change);
        change.setOnClickListener(bean.listener);

        title.setOnClickListener(listener);
        content.setOnClickListener(listener);
        mContainer.addView(titleView);
    }

    /**
     * 填充适配器视图
     * @param adapter
     */
    private void addVideoNew(VideoAdapter adapter) {
        View view = View.inflate(context,R.layout.item_start_activity_new_video_new,null);
//        View view = LayoutInflater.from(context).inflate(R.layout.item_start_activity_new_video_new,null,false);
        RecyclerView rv =(RecyclerView) view.findViewById(R.id.rv_grid);
        GridLayoutManager mgr = new GridLayoutManager(context,2){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        rv.setLayoutManager(mgr);
        rv.setAdapter(adapter);
        mContainer.addView(view);
        adapter.setOnListItemClickListener(new VideoAdapter.OnListItemClickListener(){
            @Override
            public void onListItemClick(CsGkListBean item) {
                videoSkip(item);
            }


        });
    }

    /**
     * 跳转到课程详情页面
     * @param item
     */
    private void videoSkip(CsGkListBean item) {
        Toast.makeText(context,item.csName+"",Toast.LENGTH_SHORT).show();
    }

    /**
     * 填充体
     * @param listener
     */
    private void addMore(View.OnClickListener listener) {
        View view = View.inflate(context,R.layout.item_start_activity_new_video_more,null);
        LinearLayout more = (LinearLayout)view.findViewById(R.id.ll_more);
        more.setOnClickListener(listener);
        mContainer.addView(view);
    }

}
