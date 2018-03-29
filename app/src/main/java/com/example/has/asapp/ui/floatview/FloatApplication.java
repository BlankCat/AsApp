package com.example.has.asapp.ui.floatview;

import android.app.Application;
import android.view.WindowManager;

/**
 * 
 * 
 * @author lavon
 *
 */
public class FloatApplication extends Application{
	private WindowManager.LayoutParams windowParams = new WindowManager.LayoutParams(WindowManager.LayoutParams.TYPE_TOAST);

	public WindowManager.LayoutParams getWindowParams() {
		return windowParams;
	}
}
