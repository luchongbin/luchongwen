package com.luchongbin.mycashbook.utils;

import android.util.Log;

import com.luchongbin.mycashbook.BuildConfig;


public class MLog {
    private static int maxLogSize = 1000;

    public static void i(String tag, String text) {
        if (BuildConfig.DEBUG) {
            for (int i = 0; i <= text.length() / maxLogSize; i++) {
                int start = i * maxLogSize;
                int end = (i + 1) * maxLogSize;
                end = end > text.length() ? text.length() : end;
                Log.i(tag, text.substring(start, end));
            }
        }
    }

    public static void e(String tag, String text) {
        if (BuildConfig.DEBUG) {
            Log.e(tag, text);
        }
    }

    public static void d(String tag, String text) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, text);
        }
    }

    public static void w(String tag, String text) {
        if (BuildConfig.DEBUG) {
            for (int i = 0; i <= text.length() / maxLogSize; i++) {
                int start = i * maxLogSize;
                int end = (i + 1) * maxLogSize;
                end = end > text.length() ? text.length() : end;
                Log.w(tag, text.substring(start, end));
            }
        }

    }
}
