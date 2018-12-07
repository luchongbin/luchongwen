package com.luchongbin.mycashbook.viewModel;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.luchongbin.mycashbook.DataBase.DataBaseTool;
import com.luchongbin.mycashbook.MainActivity;
import com.luchongbin.mycashbook.R;
import com.luchongbin.mycashbook.activity.AddCashUserActivity;
import com.luchongbin.mycashbook.base.BaseViewModel;
import com.luchongbin.mycashbook.bean.User;
import com.luchongbin.mycashbook.databinding.ActivityMainBinding;
import com.luchongbin.mycashbook.fragment.CashUsersFragment;
import com.luchongbin.mycashbook.fragment.MyFragment;
import com.luchongbin.mycashbook.model.TitleModel;
import com.luchongbin.mycashbook.utils.Constants;
import com.luchongbin.mycashbook.utils.JPrefreUtil;
import com.luchongbin.mycashbook.utils.StringUtils;
import com.luchongbin.mycashbook.view.TabStripView;
public class MainViewModel extends BaseViewModel {
    private ActivityMainBinding mainBinding;
    private TitleModel mTitleModel;
    private TabStripView navigateTabBar;

    public MainViewModel(MainActivity mActivity, ActivityMainBinding binding) {
        super(mActivity);
        this.mainBinding = binding;
        this.mainBinding.setMMainViewModel(this);
    }

    public void onLoadData2Remote() {
        mainBinding.icTitle.back.setVisibility(View.GONE);
        mainBinding.icTitle.action.setVisibility(View.VISIBLE);
        navigateTabBar = mainBinding.navigateTabBar;
        navigateTabBar.addTab(CashUsersFragment.class,
                new TabStripView.TabParam(R.mipmap.icon_tab_bar_home_normal,
                        R.mipmap.icon_tab_bar_home_selected, R.string.tab_bar_text_home));
        navigateTabBar.addTab(MyFragment.class,
                new TabStripView.TabParam(R.mipmap.icon_tab_bar_mine_normal,
                        R.mipmap.icon_tab_bar_mine_selected, R.string.tab_bar_text_profile));
        mTitleModel = new TitleModel();
        mTitleModel.setTitle(mActivity.getString(R.string.cashbook_tile));
        mTitleModel.setRightText(mActivity.getString(R.string.add_cashUser));
        mainBinding.setMTitleModel(mTitleModel);
    }
    public void setUser(){
        JPrefreUtil mJPrefreUtil = JPrefreUtil.getInstance(mActivity);
        long mUserId = mJPrefreUtil.getUserId();
        if(mUserId > 0){
           return;
        }
        User mUser = new User();
        long userId = StringUtils.genItemId();
        mUser.setUserId(userId);
        mUser.setUserName("13521959693");
        mUser.setPassword("123456");
        mUser.setIsManager(true);
        mUser.setNickName("孤狼");
        long id = DataBaseTool.getInstance().insertUser(mUser);
        mJPrefreUtil.setUserId(id>0?userId:0);
    }


    //设置账本信息的标题
    public void setCashBookTitle() {
        mTitleModel.setTitle(mActivity.getString(R.string.cashUser_tile));
        mainBinding.icTitle.action.setVisibility(View.VISIBLE);
    }

    //设置个人中心的标题
    public void setMyFragmentTitle() {
        mTitleModel.setTitle(mActivity.getString(R.string.personal_center_title));
        mainBinding.icTitle.action.setVisibility(View.GONE);
    }

    @Override
    public void onClickRightView(View view) {
        Intent mIntent = new Intent(mActivity, AddCashUserActivity.class);
        mActivity.startActivityForResult(mIntent, Constants.MAINREQUESTCODE);
    }


    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (data == null) {
            return;
        }
        CashUsersFragment mCashBookFragment=null;
        Fragment fragment = navigateTabBar.getFragmentByTag(mActivity.getString(R.string.tab_bar_text_home));
        if (fragment instanceof CashUsersFragment) {
            mCashBookFragment = (CashUsersFragment) fragment;
        }
        if (requestCode == Constants.MAINREQUESTCODE && resultCode == Constants.MAINRRESULTCODE) {//添加账户信息
            long id = data.getLongExtra(Constants.AddUsersBook.RESULTCODE,-1);
            mCashBookFragment.getCashUserById(id);
            return;
        }
        if(requestCode == Constants.CashBookDetails.QUESTCODE && resultCode == Constants.CashBookDetails.RRESULTCODE){
            long id = data.getLongExtra(Constants.CashBookDetails.RESULTCODE,-1);
            int position = data.getIntExtra(Constants.CashBookDetails.POSITION,-1);
            mCashBookFragment.getCashBook(id,false,position);
            return;
        }
    }
}
