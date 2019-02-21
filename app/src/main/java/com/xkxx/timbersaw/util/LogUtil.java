package com.xkxx.timbersaw.util;

import android.util.Log;

/**
 * log工具类
 * @author K-9999
 * @date 2019/02/21
 */
public class LogUtil {


    public static boolean isLogs = true;



    public static void d(String tag, String msg) {

        try {
            if (!msg.isEmpty() && isLogs) {
                Log.d(tag, msg);
            }
        }catch (Exception e){

        }

    }

    public static void e(String tag, String msg) {

        try {
            if (!msg.isEmpty() && isLogs) {
                Log.e(tag, msg);
            }
        }catch (Exception e){

        }

    }
}
