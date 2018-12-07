package com.luchongbin.mycashbook.model;

import java.io.Serializable;

public class CashBookBean implements Serializable {
    private String digFlatName;//挖平
    private String digFlatHour;//挖平时间（小时）
    private String digFlatUnpaidMoney;//挖平未结金额（元）
    private String digFlatTotalAmount;//挖平合同金额（元）
    private String fractureName;//破碎
    private String fractureHour;//破碎时间（小时）
    private String fractureUnpaidMoney;//破碎未结金额（元）
    private String fractureTotalAmount;//合同总金额
    private String dateTime;//时间
    private String company;//单位
    private String head;//负责人
    private String unpaidAmount;//挖平和破碎加起来的未结金额（元）
    private String remarks;

    public String getDigFlatName() {
        return digFlatName;
    }

    public void setDigFlatName(String digFlatName) {
        this.digFlatName = digFlatName;
    }

    public String getDigFlatHour() {
        return digFlatHour;
    }

    public void setDigFlatHour(String digFlatHour) {
        this.digFlatHour = digFlatHour;
    }

    public String getDigFlatUnpaidMoney() {
        return digFlatUnpaidMoney;
    }

    public void setDigFlatUnpaidMoney(String digFlatUnpaidMoney) {
        this.digFlatUnpaidMoney = digFlatUnpaidMoney;
    }

    public String getDigFlatTotalAmount() {
        return digFlatTotalAmount;
    }

    public void setDigFlatTotalAmount(String digFlatTotalAmount) {
        this.digFlatTotalAmount = digFlatTotalAmount;
    }

    public String getFractureName() {
        return fractureName;
    }

    public void setFractureName(String fractureName) {
        this.fractureName = fractureName;
    }

    public String getFractureHour() {
        return fractureHour;
    }

    public void setFractureHour(String fractureHour) {
        this.fractureHour = fractureHour;
    }

    public String getFractureUnpaidMoney() {
        return fractureUnpaidMoney;
    }

    public void setFractureUnpaidMoney(String fractureUnpaidMoney) {
        this.fractureUnpaidMoney = fractureUnpaidMoney;
    }

    public String getFractureTotalAmount() {
        return fractureTotalAmount;
    }

    public void setFractureTotalAmount(String fractureTotalAmount) {
        this.fractureTotalAmount = fractureTotalAmount;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getUnpaidAmount() {
        return unpaidAmount;
    }

    public void setUnpaidAmount(String unpaidAmount) {
        this.unpaidAmount = unpaidAmount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
