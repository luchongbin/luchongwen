package com.luchongbin.mycashbook.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
/**
 * 本地SharedPreferences形式保存的所有数据
 */
public class JPrefreUtil<T> {

    private static JPrefreUtil sInstance=null;
    private SharedPreferences mPref;
    private Editor mEditor;
    private Context mContext;

    private static final String USER_INFO = "com.luchongbin.mycashbook.playerprefs";
    private static final String USERID = "UserId";

    public synchronized static JPrefreUtil getInstance(Context context) {
        if (null == sInstance) {
            sInstance = new JPrefreUtil(context);
        }
        return sInstance;
    }

    private JPrefreUtil(Context context) {
        mContext = context;
    }
    /**
     * 保存userid
     *
     */
    public boolean setUserId(long userId) {
        Editor editor = getEditor();
        editor.putLong(USERID, userId);
        return editor.commit();
    }
    /**
     * 获取Userid
     */
    public long getUserId() {
        return getSharedPreferences().getLong(USERID, -1);
    }
    private Editor getEditor() {
        if (null == mEditor) {
            mEditor = getSharedPreferences().edit();
        }
        return mEditor;
    }


    private SharedPreferences getSharedPreferences() {
        if (null == mPref) {
            mPref = mContext.getSharedPreferences(USER_INFO, Context.MODE_PRIVATE);
        }
        return mPref;
    }
}
