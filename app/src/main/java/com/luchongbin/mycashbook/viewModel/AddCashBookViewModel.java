package com.luchongbin.mycashbook.viewModel;

import android.content.Intent;
import android.databinding.ViewDataBinding;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;

import com.codbking.widget.DatePickDialog;
import com.codbking.widget.OnSureLisener;
import com.codbking.widget.bean.DateType;
import com.luchongbin.mycashbook.DataBase.DataBaseTool;
import com.luchongbin.mycashbook.MainActivity;
import com.luchongbin.mycashbook.R;
import com.luchongbin.mycashbook.activity.AddCashBookActivity;
import com.luchongbin.mycashbook.base.BaseViewModel;
import com.luchongbin.mycashbook.bean.CashBook;
import com.luchongbin.mycashbook.bean.User;
import com.luchongbin.mycashbook.databinding.ActivityAddCashBookBinding;
import com.luchongbin.mycashbook.model.CashBookModel;
import com.luchongbin.mycashbook.model.TitleModel;
import com.luchongbin.mycashbook.utils.Constants;
import com.luchongbin.mycashbook.utils.MLog;
import com.luchongbin.mycashbook.utils.StringUtils;
import com.luchongbin.mycashbook.utils.TimeUtils;
import com.luchongbin.mycashbook.utils.ToastUtils;

import java.util.Date;

public class AddCashBookViewModel extends BaseViewModel {
    private ActivityAddCashBookBinding mBinding;
    private AddCashBookActivity mAddCashBookActivity;
    private CashBook mCashBookBean;
    private boolean isEditable;
    public AddCashBookViewModel(AddCashBookActivity mActivity, ViewDataBinding binding) {
        super(mActivity);
        this.mAddCashBookActivity = mActivity;
        this.mBinding = (ActivityAddCashBookBinding) binding;
        mBinding.setMAddCashBookViewModel(this);
    }

    public void onLoadData2Remote() {
        isEditable = mActivity.getIntent().getBooleanExtra(Constants.CashBookDetails.EDITABLE, false);
        long mCashBookId = mActivity.getIntent().getLongExtra(Constants.CashBookDetails.CASHBOOKID, -1);
        mBinding.icTitle.action.setVisibility(isEditable?View.VISIBLE:View.GONE);
        CashBookModel mCashBookModel = new CashBookModel();
        mCashBookModel.setTitle(isEditable?"添加单条账本信息":"单条账本详情");
        mCashBookModel.setRightText("保存");
        mCashBookModel.setEditable(isEditable);
        if (!isEditable) {
            setBackground(mBinding.etDigFlatHour);
            setBackground(mBinding.etDigFlatAmount);
            setBackground(mBinding.etFractureHour);
            setBackground(mBinding.etFractureAmount);
            setBackground(mBinding.etData);
            setBackground(mBinding.etRemarks);
            mCashBookBean = DataBaseTool.getInstance().getCashBookByCashBookId(mCashBookId);
            mBinding.etAutograph.setBackgroundResource(mCashBookBean.getAutograph()!=null&& mCashBookBean.getAutograph().length() >0?
                    R.drawable.translucent_gray:R.drawable.translucent);
            mCashBookModel.setDigFlatHour(mCashBookBean.getDigFlatHour() + "");
            mCashBookModel.setDigFlatTotalAmount(mCashBookBean.getDigFlatTotalAmount() + "");
            mCashBookModel.setFractureHour(mCashBookBean.getFractureHour() + "");
            mCashBookModel.setFractureTotalAmount(mCashBookBean.getFractureTotalAmount() + "");
            mCashBookModel.setDateTime(mCashBookBean.getDate());
            mCashBookModel.setRemarks(mCashBookBean.getRemarks());
            mCashBookModel.setAutograph(mCashBookBean.getAutograph());
        }
        mBinding.setMCashBookModel(mCashBookModel);
    }
    private void setBackground(View view){
        view.setBackgroundResource(R.drawable.translucent_gray);
    }
    public void deleteCashBook(View view){
        DataBaseTool.getInstance().deleteCashBookById(mCashBookBean.getId());
        dismiss(-1,null);
        ToastUtils.popUpToast("此条记录已被删除");
    }

    public void selectData(View view) {
        if(!isEditable){
            return;
        }
        final TextView mTextView = (TextView) view;
        DatePickDialog dialog = new DatePickDialog(mActivity);
        //设置上下年分限制
        dialog.setYearLimt(5);
        //设置标题
        dialog.setTitle("选择日期");
        //设置类型
        dialog.setType(DateType.TYPE_YMD);
        //设置消息体的显示格式，日期格式
        dialog.setMessageFormat("yyyy-MM-dd");
        //设置选择回调
        dialog.setOnChangeLisener(null);
        //设置点击确定按钮回调
        dialog.setOnSureLisener(new OnSureLisener() {
            @Override
            public void onSure(Date date) {
                String data = TimeUtils.getDateYYMMDD(date);
                mTextView.setText(data);
            }
        });
        dialog.show();
    }

    @Override
    public void onClickRightView(View view) {
        if(!isEditable){
            DataBaseTool.getInstance().modifyCashBook(mCashBookBean);//修改数据库
            dismiss(mCashBookBean.getId(),null);
            return;
        }
        String mAutograph = mBinding.etAutograph.getText().toString();//施工签字
        String digFlatHour = mBinding.etDigFlatHour.getText().toString();//挖平时长
        String digFlatTotalAmount = mBinding.etDigFlatAmount.getText().toString();//挖平金额
        String fractureHour = mBinding.etFractureHour.getText().toString();//破碎时长
        String fractureTotalAmount = mBinding.etFractureAmount.getText().toString();//破碎金额
        String data = mBinding.etData.getText().toString();//日期
        String mRemarks = mBinding.etRemarks.getText().toString();//备注

        if (StringUtils.isEmpty(data)) {
            ToastUtils.popUpToast("请输入施工日期");
            return;
        }

        long userId = mActivity.getIntent().getLongExtra(Constants.CashBookDetails.USERID, -1);
        mCashBookBean = new CashBook();
        mCashBookBean.setCashBookId(StringUtils.genItemId());
        mCashBookBean.setDigFlatHour(StringUtils.isEmpty(digFlatHour) ? 0.00 : Double.parseDouble(digFlatHour));
        mCashBookBean.setDigFlatTotalAmount(StringUtils.isEmpty(digFlatTotalAmount) ? 0.00 : Double.parseDouble(digFlatTotalAmount));
        mCashBookBean.setFractureHour(StringUtils.isEmpty(fractureHour) ? 0.00 : Double.parseDouble(fractureHour));
        mCashBookBean.setFractureTotalAmount(StringUtils.isEmpty(fractureTotalAmount) ? 0.00 : Double.parseDouble(fractureTotalAmount));
        mCashBookBean.setRemarks(mRemarks);
        mCashBookBean.setAutograph(mAutograph);
        mCashBookBean.setDate(data);
        mCashBookBean.setUserId(userId);
        long id = DataBaseTool.getInstance().insertCashBook(mCashBookBean);//插入数据库时 返回的自增ID
        dismiss(id,data);

    }
    private void dismiss(long id,String data){
        Intent mIntent = new Intent();
        mIntent.putExtra(Constants.AddCashBook.RESULTCODE, id);
        if(data != null){
            mIntent.putExtra(Constants.AddCashBook.DATATIME, data);
        }
        mActivity.setResult(Constants.CashBookDetails.RRESULTCODE, mIntent);
        mAddCashBookActivity.finish();
    }


    public TextWatcher mTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

        @Override
        public void onTextChanged(CharSequence s, int i, int i1, int i2) {}

        @Override
        public void afterTextChanged(Editable editable) {
            String temp = editable.toString();
            int posDot = temp.indexOf(".");
            if (posDot <= 0) return;
            if (temp.length() - posDot - 1 > 2) {
                editable.delete(posDot + 3, posDot + 4);
            }
        }
    };
    public TextWatcher mTextWatcher1 = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

        @Override
        public void onTextChanged(CharSequence s, int i, int i1, int i2) { }
        @Override
        public void afterTextChanged(Editable editable) {
            String temp = editable.toString();
            if(!isEditable){
                mCashBookBean.setAutograph(temp);
                mBinding.icTitle.action.setVisibility(temp.length() >0?View.VISIBLE:View.GONE);
            }
        }
    };
}
