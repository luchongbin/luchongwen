package com.luchongbin.mycashbook.base;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luchongbin.mycashbook.utils.MLog;

/**
 * Created by luchongbin on 2017/6/23.
 */

public abstract class BaseFragment<P extends BaseViewModel> extends Fragment{
    protected abstract int getLayoutResource();

    protected abstract void onLoadData2Remote();

    protected View rootView;
    protected Context mContext = null;//context
    protected P mViewModel;
    /**
     * this context activity
     */
    protected Activity activity;


    protected abstract P onInitLogicImpl(ViewDataBinding binding);

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int rs = getLayoutResource();
        ViewDataBinding binding = DataBindingUtil.inflate(inflater, rs,container,false);
        if (mViewModel == null) {
            mViewModel = onInitLogicImpl(binding);
        }
        return binding.getRoot();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MLog.d("name (%s.java:0)", getClass().getSimpleName());
        mContext = getActivity();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        onLoadData2Remote();
    }




    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mViewModel != null)
            mViewModel=null;
    }



    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
