package com.luchongbin.mycashbook.fragment;

import android.app.Activity;
import android.databinding.ViewDataBinding;
import android.view.View;

import com.luchongbin.mycashbook.MainActivity;
import com.luchongbin.mycashbook.R;
import com.luchongbin.mycashbook.base.BaseFragment;
import com.luchongbin.mycashbook.viewModel.CashUsersViewModel;
import com.rmondjone.xrecyclerview.XRecyclerView;


public class CashUsersFragment extends BaseFragment<CashUsersViewModel> {
    private CashBookFragmentCall lister;
    private MainActivity mainActivity;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mainActivity = (MainActivity) activity;
        lister = (CashBookFragmentCall) activity;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.cashbook_fragment;
    }

    @Override
    protected void onLoadData2Remote() {
        lister.setCashBookTitle();
        mViewModel.onLoadData2Remote();
        mViewModel.getCashUsersModels();
    }

    @Override
    protected CashUsersViewModel onInitLogicImpl(ViewDataBinding binding) {
        return new CashUsersViewModel(getActivity(), binding);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            lister.setCashBookTitle();
        }
    }

    public void getCashBook(long id,boolean isAdd,int position) {
        mViewModel.getCashBook(id,isAdd,position);
    }
    public void getCashUserById(long id) {
        mViewModel.getCashUserById(id);
    }

    //用于标题设置的回调接口
    public interface CashBookFragmentCall {
        void setCashBookTitle(); //设置标题
    }


}
