package com.luchongbin.mycashbook.model;

import android.databinding.Bindable;

import com.luchongbin.mycashbook.BR;

public class CashBookModel extends TitleModel {

    @Bindable
    private long cashBookId;
    @Bindable
    private String digFlatUnitPrice;//挖平单价（元）
    @Bindable
    private String digFlatHour;//挖平时间（小时）
    @Bindable
    private String digFlatTotalAmount;//挖平合同金额（元）
    @Bindable
    private String fractureUnitPrice;//破碎单价（元）
    @Bindable
    private String fractureHour;//破碎时间（小时）
    @Bindable
    private String fractureTotalAmount;//合同总金额

    @Bindable
    private String dateTime;//时间

    @Bindable
    private String remarks;
    @Bindable
    private boolean isEditable;
    @Bindable
    private String autograph;//施工签名
    public String getDigFlatHour() {
        return digFlatHour;
    }

    public void setDigFlatHour(String digFlatHour) {
        this.digFlatHour = digFlatHour;
        notifyPropertyChanged(BR.digFlatHour);
    }
    public String getFractureHour() {
        return fractureHour;
    }

    public void setFractureHour(String fractureHour) {
        this.fractureHour = fractureHour;
        notifyPropertyChanged(BR.fractureHour);
    }
    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
        notifyPropertyChanged(BR.dateTime);
    }

    public String getDigFlatTotalAmount() {
        return digFlatTotalAmount;
    }

    public void setDigFlatTotalAmount(String digFlatTotalAmount) {
        this.digFlatTotalAmount = digFlatTotalAmount;
        notifyPropertyChanged(BR.digFlatTotalAmount);
    }


    public String getFractureTotalAmount() {
        return fractureTotalAmount;
    }

    public void setFractureTotalAmount(String fractureTotalAmount) {
        this.fractureTotalAmount = fractureTotalAmount;
        notifyPropertyChanged(BR.fractureTotalAmount);

    }


    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
        notifyPropertyChanged(BR.remarks);
    }

    public boolean isEditable() {
        return isEditable;
    }

    public void setEditable(boolean editable) {
        isEditable = editable;
        notifyPropertyChanged(BR.isEditable);
    }
    public long getCashBookId() {
        return cashBookId;
    }

    public void setCashBookId(long cashBookId) {
        this.cashBookId = cashBookId;
    }

    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph;
        notifyPropertyChanged(BR.autograph);
    }

    public String getDigFlatUnitPrice() {
        return digFlatUnitPrice;
    }

    public void setDigFlatUnitPrice(String digFlatUnitPrice) {
        this.digFlatUnitPrice = digFlatUnitPrice;
        notifyPropertyChanged(BR.digFlatUnitPrice);
    }

    public String getFractureUnitPrice() {
        return fractureUnitPrice;
    }

    public void setFractureUnitPrice(String fractureUnitPrice) {
        this.fractureUnitPrice = fractureUnitPrice;
        notifyPropertyChanged(BR.fractureUnitPrice);
    }
}
