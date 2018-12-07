package com.luchongbin.mycashbook.base;

import com.luchongbin.mycashbook.model.CashBookModel;

/**
 * Created by Administrator on 2018/6/27/027.
 */

public class MessageEvent {
    private String message;
    private int mKey;
    private CashBookModel mCashBookModel;
    public MessageEvent(int mKey,CashBookModel mCashBookModel) {
        this.mKey = mKey;
        this.mCashBookModel = mCashBookModel;
    }
    public MessageEvent(String message) {
        this.message = message;
    }
    public MessageEvent(int mKey, String message) {
        this.mKey = mKey;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getmKey() {
        return mKey;
    }

    public void setmKey(int mKey) {
        this.mKey = mKey;
    }

    public CashBookModel getmCashBookModel() {
        return mCashBookModel;
    }

    public void setmCashBookModel(CashBookModel mCashBookModel) {
        this.mCashBookModel = mCashBookModel;
    }
}
