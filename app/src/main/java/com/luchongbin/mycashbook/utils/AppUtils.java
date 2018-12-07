package com.luchongbin.mycashbook.utils;
import android.content.Context;

public class AppUtils {

    public static int dp2px(Context ctx, float dp) {
        float density = ctx.getResources().getDisplayMetrics().density;// 获取设备密度
        int px = (int) (dp * density + 0.5f);// 4.3, 4.9, 加0.5是为了四舍五入
        return px;
    }

    public static float px2dp(Context ctx, int px) {
        float density = ctx.getResources().getDisplayMetrics().density;// 获取设备密度
        float dp = px / density;
        return dp;
    }
}
