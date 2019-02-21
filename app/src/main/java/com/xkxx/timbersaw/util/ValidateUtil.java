package com.xkxx.timbersaw.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.json.JSONObject;

import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 校验工具
 * @author K-9999
 * @date 2019/02/21
 */
public class ValidateUtil {

    /**
     * 检测手机号码
     *
     * @param mobiles
     * @return
     */
    public static boolean isMobileNO(String mobiles) {
        if (isNotEmptyObjectOrString(mobiles)) {
            Pattern p = Pattern.compile("^(1[0-9])\\d{9}$");
            Matcher m = p.matcher(mobiles);
            return m.matches();
        } else {
            return false;
        }
    }

    /**
     * 校验是否为空字符串
     *
     * @param validateStr 待校验的字符串
     * @return boolean
     */
    public static boolean isEmptyString(String validateStr) {
        return null == validateStr || StringConstans.STR_EMPTY.equals(validateStr)
                || StringConstans.STR_NULL_EN.equals(validateStr) || validateStr.length() == 0;
    }

    /**
     * 校验是否不为空字符串
     *
     * @param validateStr 待校验的字符串
     * @return boolean
     */
    public static boolean isNotEmptyString(String validateStr) {
        return !isEmptyString(validateStr);
    }

    /**
     * 校验是否为空json对象
     *
     * @param jo 待校验的json对象
     */
    public static boolean isEmptyOrgJsonObj(JSONObject jo) {
        return null == jo || jo.equals("[]") || StringConstans.STR_EMPTY.equals(jo);
    }

    /**
     * 校验是否不为空json对象
     *
     * @param jo 待校验的json对象
     */
    public static boolean isNotEmptyOrgJsonObj(JSONObject jo) {
        return !isEmptyOrgJsonObj(jo);
    }

    /**
     * 校验: 为空对象或者空字符串
     *
     * @param validateObj 待校验的对象
     * @return boolean
     */
    public static boolean isEmptyObjectOrString(Object validateObj) {
        return null == validateObj || StringConstans.STR_EMPTY.equals(validateObj.toString().trim());
    }

    /**
     * 校验: 不为为空对象或者空字符串
     *
     * @param validateObj 待校验的对象
     * @return boolean
     */
    public static boolean isNotEmptyObjectOrString(Object validateObj) {
        return !isEmptyObjectOrString(validateObj);
    }

    /**
     * 校验是否为空collection
     *
     * @param validateColl 待校验的collection
     * @return boolean
     */
    public static boolean isEmptyCollection(Collection<?> validateColl) {
        return null == validateColl || validateColl.size() == 0;
    }

    /**
     * 校验是否不为空collection
     *
     * @param validateColl 待校验的collection
     * @return boolean
     */
    public static boolean isNotEmptyCollection(Collection<?> validateColl) {
        return !isEmptyCollection(validateColl);
    }

    /**
     * 校验：为空Map
     *
     * @param validateMap 待校验的Map
     * @return boolean
     */
    public static boolean isEmptyMap(Map<?, ?> validateMap) {
        return null == validateMap || 0 == validateMap.entrySet().size() || validateMap.size() == 0;
    }

    /**
     * 校验: 不为空Map
     *
     * @param validateMap 待校验的Map
     * @return boolean
     */
    public static boolean isNotEmptyMap(Map<?, ?> validateMap) {
        return !isEmptyMap(validateMap);
    }


    /**
     * 判断网络连接是否可用
     *
     * @param context
     * @return
     */
    public static boolean isNetworkAvailable(Context context) {
        boolean result = false;
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null) {
            // 如果仅仅是用来判断网络连接
            NetworkInfo[] info = cm.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        result = true;
                        break;
                    }
                }
            }
        }

        return result;
    }


    private static long lastClickTime;

    public static boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        // 两次点击间隔小于500毫秒
        if (time - lastClickTime < 500) {
            return true;
        }
        lastClickTime = time;
        return false;
    }

    /**
     * @param times
     * @return
     * @方法说明:防止控件被重复点击，如果点击间隔时间小于指定时间就点击无 * @方法名称:isFastDoubleClick
     * @返回 boolean
     */
    public static boolean isFastDoubleClick(long times) {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if (0 < timeD && timeD < times) {
            return true;
        }
        lastClickTime = time;
        return false;
    }


    /**
     * 检测是否不为空字符串
     *
     * @param object
     * @return
     */
    public static String isCheck(String object) {
        if (isNotEmptyString(object)) {
            return object;
        } else {
            return "";
        }
    }

    public static String isCheck_1(String object) {
        if (isNotEmptyString(object)) {
            return object;
        } else {
            return "-1";
        }
    }

    /**
     * 检测是否不为空字符串
     *
     * @param s
     * @return
     */
    public static String isCheckInt(String s) {
        if (isNotEmptyString(s)) {
            return s;
        } else {
            return "0";
        }
    }

    public static String isCheckNo(String s){
        if (isNotEmptyString(s)) {
            return s;
        } else {
            return "未设置";
        }
    }

    /**
     * 没有选择数据
     *
     * @param s
     * @return
     */
    public static String noSelect(String s) {
        if (isNotEmptyString(s) && !"请选择".equals(isCheck(s))) {
            return s;
        } else {
            return "";
        }
    }

    public static String numToString(String s, String type) {
        if (isEmptyString(s)) {
            return "";
        }
        if ("Binddocumentis".equals(type)) {

            if ("1".equals(s)) {
                s = "已购买";
            } else {
                s = "未购买";
            }

        } else if ("Bindsumis".equals(type)) {

            if ("1".equals(s)) {
                s = "已缴纳";
            } else {
                s = "未缴纳";
            }

        } else if ("Businessbind".equals(type)) {
            if ("1".equals(s)) {
                s = "已完成";
            } else {
                s = "准备中";
            }


        } else if ("Technologybindis".equals(type)) {
            if ("1".equals(s)) {
                s = "已完成";
            } else {
                s = "准备中";
            }

        } else if ("Authorizationis".equals(type)) {
            if ("1".equals(s)) {
                s = "已完成";
            } else {
                s = "准备中";
            }
        }
        return s;
    }


}
