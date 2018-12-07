package com.luchongbin.mycashbook.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.luchongbin.mycashbook.greendao.DaoSession;
import com.luchongbin.mycashbook.greendao.UserDao;
import com.luchongbin.mycashbook.greendao.CashBookDao;
import org.greenrobot.greendao.annotation.NotNull;

import java.io.Serializable;

@Entity
public class CashBook {
    @Id
    private Long id;
    private long cashBookId;
    private long userId;
    private double digFlatHour;//挖平时间（小时）
    private double digFlatTotalAmount;//挖平金额（元）
    private double fractureHour;//破碎时间（小时）
    private double fractureTotalAmount;//破碎金额（元）
    private String date;//日期
    private String remarks;//备注
    private String autograph;//施工签名
    @Generated(hash = 384587158)
    public CashBook(Long id, long cashBookId, long userId, double digFlatHour,
            double digFlatTotalAmount, double fractureHour,
            double fractureTotalAmount, String date, String remarks,
            String autograph) {
        this.id = id;
        this.cashBookId = cashBookId;
        this.userId = userId;
        this.digFlatHour = digFlatHour;
        this.digFlatTotalAmount = digFlatTotalAmount;
        this.fractureHour = fractureHour;
        this.fractureTotalAmount = fractureTotalAmount;
        this.date = date;
        this.remarks = remarks;
        this.autograph = autograph;
    }
    @Generated(hash = 1775725379)
    public CashBook() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public long getCashBookId() {
        return this.cashBookId;
    }
    public void setCashBookId(long cashBookId) {
        this.cashBookId = cashBookId;
    }
    public long getUserId() {
        return this.userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }
    public double getDigFlatHour() {
        return this.digFlatHour;
    }
    public void setDigFlatHour(double digFlatHour) {
        this.digFlatHour = digFlatHour;
    }
    public double getDigFlatTotalAmount() {
        return this.digFlatTotalAmount;
    }
    public void setDigFlatTotalAmount(double digFlatTotalAmount) {
        this.digFlatTotalAmount = digFlatTotalAmount;
    }
    public double getFractureHour() {
        return this.fractureHour;
    }
    public void setFractureHour(double fractureHour) {
        this.fractureHour = fractureHour;
    }
    public double getFractureTotalAmount() {
        return this.fractureTotalAmount;
    }
    public void setFractureTotalAmount(double fractureTotalAmount) {
        this.fractureTotalAmount = fractureTotalAmount;
    }
    public String getDate() {
        return this.date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getRemarks() {
        return this.remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public String getAutograph() {
        return this.autograph;
    }
    public void setAutograph(String autograph) {
        this.autograph = autograph;
    }



}
