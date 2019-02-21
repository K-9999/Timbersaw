package com.xkxx.timbersaw.util;

import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Toast工具类
 * @author K-9999
 * @date 2019/02/21
 */
public class ToastUtil {

    private static Toast mToast = null;

    public static void showToast(Context context, int stringId) {
        showToast(context, context.getString(stringId));
    }

    public static void showToast(Context context, String string) {
        if (TextUtils.isEmpty(string)){
            return;
        }
        try {
            if (null == mToast) {
                mToast = Toast.makeText(context, string, Toast.LENGTH_SHORT);
            } else {
                mToast.setText(string);
            }
            mToast.setGravity(Gravity.CENTER, 0, 0);
            mToast.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
