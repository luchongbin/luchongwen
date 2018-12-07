package com.luchongbin.mycashbook.activity;
import android.content.Intent;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.luchongbin.mycashbook.MainActivity;
import com.luchongbin.mycashbook.R;
import com.luchongbin.mycashbook.base.BaseActivity;
import com.luchongbin.mycashbook.base.BaseViewModel;

public class WelcomeActivity extends BaseActivity<BaseViewModel> {


    @Override
    protected int getLayoutResource() {
        requestWindowFeature(Window.FEATURE_NO_TITLE); // 设置无标题
        // 设置全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        return R.layout.activity_welcome;
    }

    @Override
    protected BaseViewModel onInitLogicImpl(ViewDataBinding binding) {
        return null;
    }

    @Override
    protected void onLoadData2Remote(Bundle savedInstanceState) {
        new Handler().postDelayed(new Runnable(){
            public void run() {
                jump(MainActivity.class);
            }
        }, 1500);   //5秒
    }
    private void jump(Class mClass) {
        Intent intent = new Intent();
        intent.setClass(this, mClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        startActivity(intent);
        finish();
    }
}
