package com.luchongbin.mycashbook.utils;

import android.os.Build;

import com.luchongbin.mycashbook.application.MyCashBookApplication;

public class ToastUtils {
	private ToastUtils() {
	}

	private static TipsToast mToast;

	public static void popUpToast(String text) {
		try {
			if (mToast != null) {
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
                    mToast.cancel();
                }
            } else {
                mToast = TipsToast.makeText(MyCashBookApplication.getInstance().getContext(), text, TipsToast.LENGTH_SHORT);
            }
			mToast.show();
			mToast.setText(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void popUpToast(int resId) {
		popUpToast(MyCashBookApplication.getInstance().getResources().getString(resId));
	}
}
