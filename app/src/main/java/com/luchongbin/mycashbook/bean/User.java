package com.luchongbin.mycashbook.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.luchongbin.mycashbook.greendao.DaoSession;
import com.luchongbin.mycashbook.greendao.CashBookDao;
import com.luchongbin.mycashbook.greendao.UserDao;

@Entity
public class User {
    @Id
    private Long id;

    private long userId;
    //账号
    private String userName;
    //密码
    private String password;
    //昵称
    private String nickName;
    private String company;//单位
    private String mobilePhone;//电话
    private boolean isManager;//是否管理员
    private String remarks;

    private double digFlatTotalHour;//挖平总时间（小时）
    private double digFlatTotalAmount;//挖平合同金额（元）
    private double fractureTotalHour;//破碎时间（小时）
    private double fractureTotalAmount;//破碎总金额
    private double unpaidAmount;//挖平和破碎加起来的未结金额（元）
    @Generated(hash = 1510277771)
    public User(Long id, long userId, String userName, String password,
            String nickName, String company, String mobilePhone, boolean isManager,
            String remarks, double digFlatTotalHour, double digFlatTotalAmount,
            double fractureTotalHour, double fractureTotalAmount,
            double unpaidAmount) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.nickName = nickName;
        this.company = company;
        this.mobilePhone = mobilePhone;
        this.isManager = isManager;
        this.remarks = remarks;
        this.digFlatTotalHour = digFlatTotalHour;
        this.digFlatTotalAmount = digFlatTotalAmount;
        this.fractureTotalHour = fractureTotalHour;
        this.fractureTotalAmount = fractureTotalAmount;
        this.unpaidAmount = unpaidAmount;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public long getUserId() {
        return this.userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return this.userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getNickName() {
        return this.nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getCompany() {
        return this.company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getMobilePhone() {
        return this.mobilePhone;
    }
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
    public boolean getIsManager() {
        return this.isManager;
    }
    public void setIsManager(boolean isManager) {
        this.isManager = isManager;
    }
    public String getRemarks() {
        return this.remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public double getDigFlatTotalHour() {
        return this.digFlatTotalHour;
    }
    public void setDigFlatTotalHour(double digFlatTotalHour) {
        this.digFlatTotalHour = digFlatTotalHour;
    }
    public double getDigFlatTotalAmount() {
        return this.digFlatTotalAmount;
    }
    public void setDigFlatTotalAmount(double digFlatTotalAmount) {
        this.digFlatTotalAmount = digFlatTotalAmount;
    }
    public double getFractureTotalHour() {
        return this.fractureTotalHour;
    }
    public void setFractureTotalHour(double fractureTotalHour) {
        this.fractureTotalHour = fractureTotalHour;
    }
    public double getFractureTotalAmount() {
        return this.fractureTotalAmount;
    }
    public void setFractureTotalAmount(double fractureTotalAmount) {
        this.fractureTotalAmount = fractureTotalAmount;
    }
    public double getUnpaidAmount() {
        return this.unpaidAmount;
    }
    public void setUnpaidAmount(double unpaidAmount) {
        this.unpaidAmount = unpaidAmount;
    }



}
