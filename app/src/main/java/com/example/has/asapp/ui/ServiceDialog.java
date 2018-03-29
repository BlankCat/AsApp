package com.example.has.asapp.ui;

import android.app.Dialog;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

import com.example.has.asapp.R;
import com.example.has.asapp.ui.dialog.DialogActivityView;
import com.example.has.asapp.ui.floatview.FloatViewHelper;


public class ServiceDialog {

	private Dialog mDialog;
	private TextView mCancel;
	private TextView mCall;
	private Context mContext;

	public ServiceDialog(Context context) {
		this.mContext = context;
		View view = LayoutInflater.from(context).inflate(
				R.layout.dialog_market_service_tell, null);

		mCancel = (TextView) view
				.findViewById(R.id.market_dialog_service_cancel);
		mCall = (TextView) view.findViewById(R.id.market_dialog_service_call);

		mDialog = new Dialog(context, R.style.contract_detail);
//		mDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_DIALOG);
		mDialog.setContentView(view);
		mDialog.setCancelable(false);
		mDialog.setCanceledOnTouchOutside(false);
		LayoutParams layoutParams = view.getLayoutParams();
		int width = context.getResources().getDisplayMetrics().widthPixels;
		layoutParams.width = 4 * width / 5;
		layoutParams.height = LayoutParams.WRAP_CONTENT;
		view.setLayoutParams(layoutParams);

		mCancel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mDialog.dismiss();
				Context context2 = v.getContext();
				if (context2 != null && DialogActivityView.class.isInstance(context2)) {
					DialogActivityView dav = (DialogActivityView)context2;
					dav.finish();
				}
			}
		});

		mCall.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				TelephonyManager mTelephonyManager = (TelephonyManager) mContext
						.getSystemService(Service.TELEPHONY_SERVICE);
				if (mTelephonyManager.getSimState() != TelephonyManager.SIM_STATE_READY) {
					SuperToast.showToast(mContext, "请确认sim卡是否插入或者sim卡暂时不可用！");
				} else {
					FloatViewHelper.getInstance(v.getContext()).hide();
					Intent intent = new Intent(Intent.ACTION_DIAL, Uri
							.parse("tel:" + /*"13671065998"*/ /*"13934545923"*/"18600833685"));
					mContext.startActivity(intent);
				}
				mDialog.dismiss();
				Context context2 = v.getContext();
				if (context2 != null && DialogActivityView.class.isInstance(context2)) {
					DialogActivityView dav = (DialogActivityView)context2;
					dav.finish();
				}
			}
		});
	}

	public ServiceDialog(Context context, final String telenum) {
		this.mContext = context;
		View view = LayoutInflater.from(context).inflate(
				R.layout.dialog_market_service_tell, null);

		mCancel = (TextView) view
				.findViewById(R.id.market_dialog_service_cancel);
		mCall = (TextView) view.findViewById(R.id.market_dialog_service_call);
		TextView phone = (TextView) view.findViewById(R.id.market_dialog_title_tell);
		phone.setText(telenum);
		mDialog = new Dialog(context, R.style.contract_detail);
//		mDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_DIALOG);
		mDialog.setContentView(view);
		mDialog.setCancelable(false);
		mDialog.setCanceledOnTouchOutside(false);
		LayoutParams layoutParams = view.getLayoutParams();
		int width = context.getResources().getDisplayMetrics().widthPixels;
		layoutParams.width = 4 * width / 5;
		layoutParams.height = LayoutParams.WRAP_CONTENT;
		view.setLayoutParams(layoutParams);

		mCancel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mDialog.dismiss();
				Context context2 = v.getContext();
				if (context2 != null && DialogActivityView.class.isInstance(context2)) {
					DialogActivityView dav = (DialogActivityView)context2;
					dav.finish();
				}
			}
		});

		mCall.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				TelephonyManager mTelephonyManager = (TelephonyManager) mContext
						.getSystemService(Service.TELEPHONY_SERVICE);
				if (mTelephonyManager.getSimState() != TelephonyManager.SIM_STATE_READY) {
					SuperToast.showToast(mContext, "请确认sim卡是否插入或者sim卡暂时不可用！");
				} else {
					FloatViewHelper.getInstance(v.getContext()).hide();
					Intent intent = new Intent(Intent.ACTION_DIAL, Uri
							.parse("tel:" + /*"13671065998"*/ /*"13934545923"*/telenum));
					mContext.startActivity(intent);
				}
				mDialog.dismiss();
				Context context2 = v.getContext();
				if (context2 != null && DialogActivityView.class.isInstance(context2)) {
					DialogActivityView dav = (DialogActivityView)context2;
					dav.finish();
				}
			}
		});
	}

	public void toggle() {
		if (mDialog.isShowing()) {
			mDialog.dismiss();
		}else {
			mDialog.show();
		}
	}
	public void dismiss() {
			mDialog.dismiss();
	}

}
