package com.luchongbin.mycashbook.fragment;

import android.app.Activity;
import android.databinding.ViewDataBinding;
import android.os.Bundle;

import com.luchongbin.mycashbook.R;
import com.luchongbin.mycashbook.base.BaseFragment;
import com.luchongbin.mycashbook.base.BaseViewModel;


public class MyFragment extends BaseFragment {
    private MyFragmentCall lister;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        lister = (MyFragmentCall)activity;
    }
    @Override
    protected int getLayoutResource() {
        return R.layout.my_fragment;
    }


    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if(!hidden){
            lister.setMyFragmentTitle();
        }
    }

    @Override
    protected void onLoadData2Remote() {
        lister.setMyFragmentTitle();
    }

    @Override
    protected BaseViewModel onInitLogicImpl(ViewDataBinding binding) {
        return null;
    }
    //用于标题设置的回调接口
    public interface MyFragmentCall{
        void setMyFragmentTitle();//设置标题
    }
}
