package com.luchongbin.mycashbook.model;

import android.databinding.Bindable;

import com.luchongbin.mycashbook.BR;

public class CashUsersModel extends TitleModel{
    private long id;
    private long userId;
    //姓名
    @Bindable
    private String userName;
    @Bindable
    private String nickName;
    @Bindable
    private String mobilePhone;//电话
    @Bindable
    private String remarks;
    @Bindable
    private String digFlatTotalHour;//挖平总时间（小时）
    @Bindable
    private String digFlatTotalAmount;//挖平合同金额（元）
    @Bindable
    private String fractureTotalHour;//破碎时间（小时）
    @Bindable
    private String fractureTotalAmount;//破碎总金额
    @Bindable
    private String unpaidAmount;//挖平和破碎加起来的未结金额（元）
    @Bindable
    private String company;//单位

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        notifyPropertyChanged(BR.userName);
    }

    public String getDigFlatTotalHour() {
        return digFlatTotalHour;
    }

    public void setDigFlatTotalHour(String digFlatTotalHour) {
        this.digFlatTotalHour = digFlatTotalHour;
        notifyPropertyChanged(BR.digFlatTotalHour);
    }

    public String getDigFlatTotalAmount() {
        return digFlatTotalAmount;
    }

    public void setDigFlatTotalAmount(String digFlatTotalAmount) {
        this.digFlatTotalAmount = digFlatTotalAmount;
        notifyPropertyChanged(BR.digFlatTotalAmount);
    }

    public String getFractureTotalHour() {
        return fractureTotalHour;
    }

    public void setFractureTotalHour(String fractureTotalHour) {
        this.fractureTotalHour = fractureTotalHour;
        notifyPropertyChanged(BR.fractureTotalHour);
    }

    public String getFractureTotalAmount() {
        return fractureTotalAmount;
    }

    public void setFractureTotalAmount(String fractureTotalAmount) {
        this.fractureTotalAmount = fractureTotalAmount;
        notifyPropertyChanged(BR.fractureTotalAmount);
    }

    public String getUnpaidAmount() {
        return unpaidAmount;
    }

    public void setUnpaidAmount(String unpaidAmount) {
        this.unpaidAmount = unpaidAmount;
        notifyPropertyChanged(BR.unpaidAmount);
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
        notifyPropertyChanged(BR.company);
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
        notifyPropertyChanged(BR.nickName);
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        notifyPropertyChanged(BR.mobilePhone);
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
        notifyPropertyChanged(BR.remarks);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
