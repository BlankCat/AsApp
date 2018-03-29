package com.example.has.asapp.ui.floatview;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

import com.example.has.asapp.R;
import com.example.has.asapp.ui.ServiceDialog;
import com.example.has.asapp.ui.dialog.DialogActivityView;
import com.example.has.asapp.utils.function.DataTools;


/**
 * 悬浮框显示帮助类
 *
 * @author Lavon
 */
public class FloatViewHelper {
    private String TAG = "FloatViewHelper";
    private static FloatViewHelper mFVH;
    private WindowManager windowManager = null;
    private LayoutParams windowManagerParams = null;
    private FloatView floatView = null;
    private Context mContext;
    private OnClickListener mOnClickListener;
    private boolean mIsShow;
    private ServiceDialog serviceDialog;
    private String phoneNo;

    private FloatViewHelper(Context context) {
        mContext = context;
        initFloatView();
    }

    public static FloatViewHelper getInstance(Context context) {
        if (mFVH == null) {
            mFVH = new FloatViewHelper(context);
        }
        return mFVH;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    private void initFloatView() {

        floatView = new FloatView(mContext.getApplicationContext(), 0, 0);
        floatView.setOnClickListener(mDefaultClickListener);
//		floatView.setImageResource(R.drawable.market_floating_service_normal_img); // 这里简单的用自带的icon来做演示
        floatView.setImageResource(R.drawable.market_floating_service_press_img); // 这里简单的用自带的icon来做演示
        floatView.setFloatingMode(true, false, true, false);

//		floatView.setmHBerthLength(400);
        floatView.setmVBerthLength(500);


//		floatView.setFloatingMode(false, FloatView.FLOATING_MODE_LEFT,
//				FloatView.FLOATING_MODE_RIGHT, FloatView.FLOATING_MODE_TOP);
        // 获取WindowManager
        windowManager = (WindowManager) mContext.getApplicationContext()
                .getSystemService(Context.WINDOW_SERVICE);
        // 设置LayoutParams(全局变量）相关参数
        // windowManagerParams =
        // ((FloatApplicatwindowManagerParams2windowManagerParams2windowManagerParams2windowManagerParams2windowManagerParams2windowManagerParams2windowManagerParams2windowManagerParams2windowManagerParams2ion)
        // mContext.getApplicationContext())
        // .getWindowParams();
        // windowManagerParams = new WindowManager.LayoutParams();

        // windowManagerParams.type = LayoutParams.TYPE_TOAST; // 设置window type
        // windowManagerParams.format = PixelFormat.RGBA_8888; // 设置图片格式，效果为背景透明
        // // 设置Window flag
        // windowManagerParams.flags = LayoutParams.FLAG_NOT_TOUCH_MODAL
        // | LayoutParams.FLAG_NOT_FOCUSABLE;
        /*
		 * 注意，flag的值可以为： 下面的flags属性的效果形同“锁定”。 悬浮窗不可触摸，不接受任何事件,同时不影响后面的事件响应。
		 * LayoutParams.FLAG_NOT_TOUCH_MODAL 不影响后面的事件
		 * LayoutParams.FLAG_NOT_FOCUSABLE 不可聚焦 LayoutParams.FLAG_NOT_TOUCHABLE
		 * 不可触摸
		 */
        // 调整悬浮窗口至左上角，便于调整坐标
        // 以屏幕左上角为原点，设置x、y初始值
        // windowManagerParams.x = 0;
        // windowManagerParams.y = 0;
        // 设置悬浮窗口长宽数据
        // windowManagerParams.width = LayoutParams.WRAP_CONTENT;
        // windowManagerParams.height = LayoutParams.WRAP_CONTENT;
        // // 显示myFloatView图像
        // windowManager.addView(floatView, windowManagerParams);

    }

    public void show() {
        if (DataTools.getServicePop(mContext)) {

            if (!isShow()) {
                // 显示悬浮窗口
                LayoutParams windowManagerParams2 = floatView
                        .getWindowManagerParams();
                floatView.setVisibility(View.VISIBLE);
                windowManager.addView(floatView, windowManagerParams2);
                mIsShow = true;
            }
        }
    }

    public void hide() {
        if (isShow()) {
            // 隐藏悬浮窗口
            try {
                if (floatView != null) {
                    floatView.setVisibility(View.GONE);
                    windowManager.removeView(floatView);
                    mIsShow = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

//			new Handler().postDelayed(new Runnable() {
//				
//				@Override
//				public void run() {
//					// TODO Auto-generated method stub
//					FragmentActivity fa = (FragmentActivity)mContext;
//					fa.runOnUiThread(new Runnable() {
//						
//						@Override
//						public void run() {
//							windowManager.removeView(floatView);
//							mIsShow = false;
//						}
//					});
//				}
//			}, 500);
        }
    }

    public boolean isShow() {
        return mIsShow;
    }

    public static void setContext(Context context) {

    }

    private OnClickListener mDefaultClickListener = new OnClickListener() {

        public void onClick(View v) {
//			if (serviceDialog!=null) {
//				serviceDialog.dismiss();
//			}
//			serviceDialog = new ServiceDialog(mContext);
//			serviceDialog.toggle();
            Intent intent = new Intent(mContext, DialogActivityView.class);
            intent.putExtra("phone",phoneNo);
            mContext.startActivity(intent);
			/*
			Toast.makeText(mContext, "Clicked", Toast.LENGTH_SHORT).show();
			Log.i(TAG, "onClick");
			TelephonyManager mTelephonyManager = (TelephonyManager) mContext
					.getSystemService(Service.TELEPHONY_SERVICE);
			if (mTelephonyManager.getSimState() != TelephonyManager.SIM_STATE_READY) {
				Toast.makeText(mContext, "请确认sim卡是否插入或者sim卡暂时不可用！",
						Toast.LENGTH_SHORT).show();
			} else {
				Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"
						+  "13671065998"  "13934545923" "18600833685"));
				mContext.startActivity(intent);
			}
		*/
        }
    };

}
