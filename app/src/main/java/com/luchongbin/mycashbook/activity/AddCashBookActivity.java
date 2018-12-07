package com.luchongbin.mycashbook.activity;

import android.databinding.ViewDataBinding;
import android.os.Bundle;

import com.luchongbin.mycashbook.R;
import com.luchongbin.mycashbook.base.BaseActivity;
import com.luchongbin.mycashbook.base.BaseViewModel;
import com.luchongbin.mycashbook.model.CashBookModel;
import com.luchongbin.mycashbook.viewModel.AddCashBookViewModel;

/**
 * 添加（或者详情）账本
 */
public class AddCashBookActivity extends BaseActivity<AddCashBookViewModel> {
    @Override
    protected int getLayoutResource() {
        return R.layout.activity_add_cash_book;
    }

    @Override
    protected AddCashBookViewModel onInitLogicImpl(ViewDataBinding binding) {
        return new AddCashBookViewModel(this,binding);
    }
    @Override
    protected void onLoadData2Remote(Bundle savedInstanceState) {
       mViewModel.onLoadData2Remote();
    }
}
