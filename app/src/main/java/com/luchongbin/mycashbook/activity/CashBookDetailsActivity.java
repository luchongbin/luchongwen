package com.luchongbin.mycashbook.activity;

import android.content.Intent;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.luchongbin.mycashbook.R;
import com.luchongbin.mycashbook.base.BaseActivity;
import com.luchongbin.mycashbook.databinding.ActivityBashbookDetailsBinding;
import com.luchongbin.mycashbook.utils.ToastUtils;
import com.luchongbin.mycashbook.viewModel.CashBookDetailsViewModel;

public class CashBookDetailsActivity extends BaseActivity<CashBookDetailsViewModel>implements  AdapterView.OnItemSelectedListener{
    private ActivityBashbookDetailsBinding mBinding;
    @Override
    protected int getLayoutResource() {
        return R.layout.activity_bashbook_details;
    }

    @Override
    protected CashBookDetailsViewModel onInitLogicImpl(ViewDataBinding binding) {
        this.mBinding = (ActivityBashbookDetailsBinding) binding;
        return new CashBookDetailsViewModel(this, mBinding);
    }

    @Override
    protected void onLoadData2Remote(Bundle savedInstanceState) {
        mViewModel.onLoadData2Remote();
        mViewModel.getCashBookModels();
    }

    @Override
    protected void setListener() {
        super.setListener();
        mBinding.spinner.setOnItemSelectedListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mViewModel.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView mTextView = (TextView)view;
        String str = mTextView.getText().toString();
        mViewModel.onItemSelected(str);
        str = str.replace("-","年");
        ToastUtils.popUpToast("已经为你筛选出"+str+"月所有的记录");
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
