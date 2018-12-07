package com.luchongbin.mycashbook.base;

import android.app.Activity;
import android.view.View;

import com.luchongbin.mycashbook.R;
import com.luchongbin.mycashbook.bean.CashBook;
import com.luchongbin.mycashbook.bean.User;
import com.luchongbin.mycashbook.model.CashBookModel;
import com.luchongbin.mycashbook.model.CashUsersModel;
import com.luchongbin.mycashbook.utils.StringUtils;
import com.luchongbin.mycashbook.utils.TimeUtils;

/**
 * Created by luchongbin on 2018/3/9.
 */

public class BaseViewModel {
    protected Activity mActivity;
    public BaseViewModel(Activity activity){
        this.mActivity = activity;
    }
    public void onClickLiftBack(View view){
        mActivity.finish();
    }
    public void onClickRightView(View view){}
    public void onClickRightImageView(View view){}


    protected CashUsersModel ConvertCashUsersModel(User mUser){
        CashUsersModel mCashUsersModel = new CashUsersModel();
        mCashUsersModel.setId(mUser.getId());
        mCashUsersModel.setUserId(mUser.getUserId());
        mCashUsersModel.setUserName(mUser.getUserName());
        mCashUsersModel.setNickName(mUser.getNickName());
        mCashUsersModel.setMobilePhone(mUser.getMobilePhone());
        mCashUsersModel.setRemarks(mUser.getRemarks());
        mCashUsersModel.setCompany(mUser.getCompany());
//        double mUnpaidAmount= mUser.getUnpaidAmount();
//        mCashUsersModel.setUnpaidAmount(mUnpaidAmount > 0? StringUtils.formatDouble(mUnpaidAmount):"111110.00");
//        double mDigFlatTotalHour= mUser.getDigFlatTotalHour();
//        mCashUsersModel.setDigFlatTotalHour(mDigFlatTotalHour > 0? StringUtils.formatDouble1(mDigFlatTotalHour):"3333.0");
//        double mDigFlatTotalAmount= mUser.getDigFlatTotalAmount();
//        mCashUsersModel.setDigFlatTotalAmount(mDigFlatTotalAmount > 0? StringUtils.formatDouble(mDigFlatTotalAmount):"1111110.00");
//        double mFractureTotalHour= mUser.getFractureTotalHour();
//        mCashUsersModel.setFractureTotalHour(mFractureTotalHour > 0? StringUtils.formatDouble1(mFractureTotalHour):"0.0");
//        double mFractureTotalAmount= mUser.getFractureTotalAmount();
//        mCashUsersModel.setFractureTotalAmount(mFractureTotalAmount > 0? StringUtils.formatDouble(mFractureTotalAmount):"0.00");
        return mCashUsersModel;
    }


//    //数据库CashBook对象转换成UI显示所需要的CashBookModel对象
//    protected CashBookModel ConvertCashBookModel(CashBook mCashBook){
//
//        CashBookModel mCashBookModel = new CashBookModel();
//        mCashBookModel.setCashBookId(mCashBook.getCashBookId());
//        double mDigFlatHour = mCashBook.getDigFlatHour();
//        mCashBookModel.setDigFlatHour(mDigFlatHour > 0? StringUtils.formatDouble(mDigFlatHour):"0.00");
//        double mDigFlatTotalAmount = mCashBook.getDigFlatTotalAmount();
//        mCashBookModel.setDigFlatTotalAmount(mDigFlatTotalAmount > 0?StringUtils.formatDouble(mDigFlatTotalAmount):"0.00");
//        double mFractureHour = mCashBook.getFractureHour();
//        mCashBookModel.setFractureHour(mFractureHour > 0?StringUtils.formatDouble(mFractureHour):"0.00");
//        double mFractureTotalAmount = mCashBook.getFractureTotalAmount();
//        mCashBookModel.setFractureTotalAmount(mFractureTotalAmount > 0?StringUtils.formatDouble(mFractureTotalAmount):"0.00");
//        mCashBookModel.setRemarks(mCashBook.getRemarks());
//        mCashBookModel.setDateTime(mCashBook.getDate());
//        return mCashBookModel;
//    }

}
