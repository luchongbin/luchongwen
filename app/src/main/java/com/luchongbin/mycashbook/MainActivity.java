package com.luchongbin.mycashbook;

import android.content.Intent;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.luchongbin.mycashbook.base.BaseActivity;
import com.luchongbin.mycashbook.databinding.ActivityMainBinding;
import com.luchongbin.mycashbook.fragment.CashUsersFragment;
import com.luchongbin.mycashbook.fragment.MyFragment;
import com.luchongbin.mycashbook.utils.ToastUtils;
import com.luchongbin.mycashbook.viewModel.MainViewModel;

public class MainActivity extends BaseActivity<MainViewModel> implements CashUsersFragment.CashBookFragmentCall,
        MyFragment.MyFragmentCall {
    private long time = 0;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    protected MainViewModel onInitLogicImpl(ViewDataBinding binding) {
        return new MainViewModel(this, (ActivityMainBinding) binding);
    }

    @Override
    protected void onLoadData2Remote(Bundle savedInstanceState) {
        mViewModel.onLoadData2Remote();
        mViewModel.setUser();
    }

    //设置账本信息的标题
    @Override
    public void setCashBookTitle() {
        mViewModel.setCashBookTitle();
    }

    //设置个人中心的标题
    @Override
    public void setMyFragmentTitle() {
        mViewModel.setMyFragmentTitle();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mViewModel.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onBackPressed() {
        if ((System.currentTimeMillis() - time) > 2000) {
            ToastUtils.popUpToast(getString(R.string.main_call));
            time = System.currentTimeMillis();
            return;
        }
        System.exit(0);
    }
}
