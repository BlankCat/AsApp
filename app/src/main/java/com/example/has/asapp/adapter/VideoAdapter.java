package com.example.has.asapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.has.asapp.R;
import com.example.has.asapp.bean.CsGkListBean;

import java.util.List;

/**
 * Created by has on 2018/3/28.
 *
 */
public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder>{
    private static final String TAG = "VideoAdapter";
    private Context mContext;
    private List<CsGkListBean> mList;
    private int index;
    private static final int SHOW_NUM=4;

    private OnListItemClickListener mListener;
    //点击事件
    public interface OnListItemClickListener{
        void onListItemClick(CsGkListBean item);
    }
    public void setOnListItemClickListener(OnListItemClickListener listener) {
        mListener = listener;
    }

    //构造
    public  VideoAdapter(Context context,List<CsGkListBean> list){
        mContext=context;
        mList=list;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder = new ViewHolder(LayoutInflater.from(mContext)
                .inflate(R.layout.item_start_activity_new_recycler_video
                ,parent,false));
        return holder;
    }

    @Override
    public int getItemCount() {
        return Math.min(SHOW_NUM,mList.size());
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int p) {
        final int position = (SHOW_NUM * index + p) % mList.size();
        Log.i(TAG, "----position:" + position);
        holder.title.setText(mList.get(position).csName);
        holder.name.setText(mList.get(position).tchNames);
        holder.time.setText(((int) mList.get(position).csHour) + "分钟");
        if(mListener!=null){
            holder.img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onListItemClick(mList.get(position));
                }
            });
        }

    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        private ImageView img;
        private TextView title;
        private TextView name;
        private TextView time;

        public ViewHolder(View itemView){
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.iv_img);
            title = (TextView) itemView.findViewById(R.id.tv_title);
            name = (TextView) itemView.findViewById(R.id.tv_name);
            time = (TextView) itemView.findViewById(R.id.tv_time);
        }

    }


    public void change(){
        index ++;
        this.notifyDataSetChanged();
    }
}
