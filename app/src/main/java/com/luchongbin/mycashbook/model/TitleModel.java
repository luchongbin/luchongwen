package com.luchongbin.mycashbook.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.luchongbin.mycashbook.BR;


/**
 * Created by LUCHONGBIN on 2018/3/9/009.
 */

public class TitleModel extends BaseObservable {
    @Bindable
    private String title;

    @Bindable
    private String rightText;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    public String getRightText() {
        return rightText;
    }

    public void setRightText(String rightText) {
        this.rightText = rightText;
        notifyPropertyChanged(BR.rightText);
    }
}
