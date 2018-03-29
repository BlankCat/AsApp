package com.example.has.asapp.utils.function;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.has.asapp.utils.AppData;

/**
 * Created by has on 2018/3/22.
 */
public class DataTools {
    public static final String SERVICE_POP = "MAR_SERVICE_POP";
    /**
     * 获取点同服务悬浮是否显示;
     */
    public static boolean getServicePop(Context context) {

        SharedPreferences pref = context.getSharedPreferences(
                AppData.PREF_SETTING_FILENAME, Context.MODE_PRIVATE);
        boolean result = pref.getBoolean(SERVICE_POP, true);
        return result;

    }
}
