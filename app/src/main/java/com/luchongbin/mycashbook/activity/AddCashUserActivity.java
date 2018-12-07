package com.luchongbin.mycashbook.activity;

import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.luchongbin.mycashbook.R;
import com.luchongbin.mycashbook.base.BaseActivity;
import com.luchongbin.mycashbook.viewModel.AddCashUserViewModel;

public class AddCashUserActivity extends BaseActivity<AddCashUserViewModel> {


    @Override
    protected int getLayoutResource() {
        return R.layout.activity_add_cash_user;
    }

    @Override
    protected AddCashUserViewModel onInitLogicImpl(ViewDataBinding binding) {
        return new AddCashUserViewModel(this,binding);
    }

    @Override
    protected void onLoadData2Remote(Bundle savedInstanceState) {
        mViewModel.onLoadData2Remote();

    }
}
