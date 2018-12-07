package com.luchongbin.mycashbook.base;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.luchongbin.mycashbook.R;

/**
 * Created by luchongbin on 2018/3/9.
 */

public abstract class BaseActivity<P extends BaseViewModel> extends FragmentActivity {
    protected P mViewModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewDataBinding binding = DataBindingUtil.setContentView(this, getLayoutResource());

        if (mViewModel == null){
            mViewModel = onInitLogicImpl(binding);
        }
        onLoadData2Remote(savedInstanceState);
        setListener();
    }
    protected abstract int getLayoutResource();
    protected abstract P onInitLogicImpl(ViewDataBinding binding);
    protected abstract void onLoadData2Remote(Bundle savedInstanceState);
    protected void setListener(){}

    //关闭软键盘
    public void hideSoftInputFromWindow(){
        View view = getWindow().peekDecorView();
        if (view != null) {
            InputMethodManager inputmanger = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputmanger.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mViewModel != null ) {
            mViewModel=null;
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }
}
