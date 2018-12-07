package com.luchongbin.mycashbook.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
@Entity
public class CheQueLog {
    @Id
    private Long id;
    private long cashBookId;//账户的ID
    private double amount;//结账金额
    @Generated(hash = 1548621353)
    public CheQueLog(Long id, long cashBookId, double amount) {
        this.id = id;
        this.cashBookId = cashBookId;
        this.amount = amount;
    }
    @Generated(hash = 124443809)
    public CheQueLog() {
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
    public double getAmount() {
        return this.amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
}
