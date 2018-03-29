package com.example.has.asapp.ui;

import android.content.Context;
import android.widget.Toast;

public class SuperToast {
	private static Toast mToast;

	public SuperToast() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 弹出唯一不重复的toast.
	 * 
	 * @param content
	 */
	public static void showToast(Context context, Object content) {
		String str = content instanceof String ? String.valueOf(content)
				: context.getResources().getString(
						Integer.parseInt(content.toString()));
		if (mToast == null) {
			mToast = MyToast.makeText(context, str, Toast.LENGTH_SHORT);
		} else {
			mToast.setText(str);
			mToast.setDuration(Toast.LENGTH_SHORT);
		}
		mToast.show();
		// mToast.makeText(context, str, Toast.LENGTH_SHORT).show();
	}

	public static class MyToast extends Toast {
		private Context mContext;

		public MyToast(Context context) {
			super(context);
			mContext = context;
			// TODO Auto-generated constructor stub
		}

		@Override
		public void show() {
			this.cancel();
			super.show();
		}

	}
}
