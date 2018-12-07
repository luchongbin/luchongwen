package com.luchongbin.mycashbook.viewModel;
import android.content.Intent;
import android.databinding.ViewDataBinding;
import android.view.View;

import com.luchongbin.mycashbook.DataBase.DataBaseTool;
import com.luchongbin.mycashbook.R;
import com.luchongbin.mycashbook.activity.AddCashBookActivity;
import com.luchongbin.mycashbook.activity.AddCashUserActivity;
import com.luchongbin.mycashbook.base.BaseViewModel;
import com.luchongbin.mycashbook.bean.User;
import com.luchongbin.mycashbook.databinding.ActivityAddCashUserBinding;
import com.luchongbin.mycashbook.model.TitleModel;
import com.luchongbin.mycashbook.utils.Constants;
import com.luchongbin.mycashbook.utils.StringUtils;
import com.luchongbin.mycashbook.utils.ToastUtils;
import com.luchongbin.mycashbook.view.TabStripView;

public class AddCashUserViewModel extends BaseViewModel {
    private ActivityAddCashUserBinding mBinding;
    private AddCashUserActivity mAddCashUserActivity;
    public AddCashUserViewModel(AddCashUserActivity mActivity, ViewDataBinding binding) {
        super(mActivity);
        this.mAddCashUserActivity = mActivity;
        this.mBinding = (ActivityAddCashUserBinding) binding;
        mBinding.setMAddCashUserViewModel(this);
    }
    public void onLoadData2Remote(){
        mBinding.icTitle.action.setVisibility(View.VISIBLE);
        TitleModel mTitleModel = new TitleModel();
        mTitleModel.setTitle(mActivity.getString(R.string.add_cashUser));
        mTitleModel.setRightText(mActivity.getString(R.string.save));
        mBinding.setMTitleModel(mTitleModel);
    }
    public void onClickRightView(View view){
        String userName = mBinding.etUserName.getText().toString();
        String nickName = mBinding.etNickName.getText().toString();
        String mobilePhone = mBinding.etMobilePhone.getText().toString();
        String company = mBinding.etCompany.getText().toString();
        String remarks = mBinding.etRemarks.getText().toString();
        if(StringUtils.isEmpty(userName)){
            ToastUtils.popUpToast("请输入账户名");
            return;
        }
        if(StringUtils.isEmpty(mobilePhone)){
            ToastUtils.popUpToast("请输入电话号码");
            return;
        }

        User mUser = new User();
        long userId = StringUtils.genItemId();
        mUser.setUserId(userId);
        mUser.setUserName(userName);
        mUser.setNickName(nickName);
        mUser.setMobilePhone(mobilePhone);
        mUser.setCompany(company);
        mUser.setRemarks(remarks);
        mUser.setIsManager(false);
        long id = DataBaseTool.getInstance().insertUser(mUser);
        Intent mIntent = new Intent();
        mIntent.putExtra(Constants.AddUsersBook.RESULTCODE,id);
        mAddCashUserActivity.setResult(Constants.MAINRRESULTCODE,mIntent);
        mAddCashUserActivity.finish();
    }
}
