package com.luchongbin.mycashbook.viewModel;

import android.app.Activity;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.LinearLayoutManager;

import com.luchongbin.mycashbook.DataBase.DataBaseTool;
import com.luchongbin.mycashbook.adapter.CashUsersAdapter;
import com.luchongbin.mycashbook.base.BaseViewModel;
import com.luchongbin.mycashbook.bean.CashBook;
import com.luchongbin.mycashbook.bean.User;
import com.luchongbin.mycashbook.databinding.CashbookFragmentBinding;
import com.luchongbin.mycashbook.model.CashBookModel;
import com.luchongbin.mycashbook.model.CashUsersModel;
import com.luchongbin.mycashbook.utils.JPrefreUtil;

import java.util.ArrayList;
import java.util.List;

public class CashUsersViewModel extends BaseViewModel {
    private CashbookFragmentBinding mBinding;
    private CashUsersAdapter mCashBookAdapter;
    private List<CashUsersModel> mList;

    public CashUsersViewModel(Activity mActivity, ViewDataBinding binding) {
        super(mActivity);
        this.mBinding = (CashbookFragmentBinding) binding;
        mList = new ArrayList<>();
    }

    public void onLoadData2Remote() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(mActivity);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mBinding.xRcvItem.setLayoutManager(layoutManager);
        mCashBookAdapter = new CashUsersAdapter(mActivity,mList);
        mBinding.xRcvItem.setAdapter(mCashBookAdapter);
    }

    public void getCashUsersModels() {
        List<User> list = DataBaseTool.getInstance().findUsers();
       for(User mUser:list){
           mList.add(ConvertCashUsersModel(mUser));
       }
    }

    public void getCashBook(long id,boolean isAdd,int position){
//        CashBook mCashBook = DataBaseTool.getInstance().getCashBookById(id);
//        if(mCashBook==null){
//            return;
//        }
//        CashBookModel mCashBookModel = ConvertCashBookModel(mCashBook);
//        if(isAdd){
//            mList.add(0,mCashBookModel);
//            mCashBookAdapter.notifyDataSetChanged();
//        }else{
//            CashBookModel cashBookModel =  mList.get(position);
//            cashBookModel.setHead(mCashBookModel.getHead());
//            mCashBookAdapter.notifyItemChanged(position);
//        }

    }
    public void getCashUserById(long id){
        User mUser = DataBaseTool.getInstance().getUserById(id);
        CashUsersModel mCashUsersModel =ConvertCashUsersModel(mUser);
        mList.add(mCashUsersModel);
        mCashBookAdapter.notifyDataSetChanged();
    }
}
