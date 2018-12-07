package com.luchongbin.mycashbook.viewModel;
import android.content.Intent;
import android.databinding.ViewDataBinding;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.luchongbin.mycashbook.DataBase.DataBaseTool;
import com.luchongbin.mycashbook.R;
import com.luchongbin.mycashbook.activity.AddCashBookActivity;
import com.luchongbin.mycashbook.activity.CashBookDetailsActivity;
import com.luchongbin.mycashbook.base.BaseViewModel;
import com.luchongbin.mycashbook.bean.CashBook;
import com.luchongbin.mycashbook.databinding.ActivityBashbookDetailsBinding;

import com.luchongbin.mycashbook.model.TitleModel;
import com.luchongbin.mycashbook.utils.Constants;
import com.luchongbin.mycashbook.utils.StringUtils;
import com.luchongbin.mycashbook.utils.TimeUtils;
import com.luchongbin.mycashbook.utils.ToastUtils;
import com.rmondjone.locktableview.DisplayUtil;
import com.rmondjone.locktableview.LockTableView;
import com.rmondjone.xrecyclerview.ProgressStyle;
import com.rmondjone.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CashBookDetailsViewModel extends BaseViewModel {
    private ActivityBashbookDetailsBinding mBinding;
    private CashBookDetailsActivity activity;
    private long userId;
    private int position;
    private XRecyclerView mXRecyclerView;
    private LockTableView mLockTableView;
    private List<CashBook> mCashBooks;
    private CashBook cashBook;
    private Set<String> set;
    private ArrayList<String> titles;
    public CashBookDetailsViewModel(CashBookDetailsActivity mActivity, ActivityBashbookDetailsBinding binding) {
        super(mActivity);
        this.activity = mActivity;
        this.mBinding =  binding;
        mBinding.setMCashBookDetailsViewModel(this);
    }

    public void onLoadData2Remote(){
        userId = mActivity.getIntent().getLongExtra(Constants.CashBookDetails.USERID,-1);
        position = mActivity.getIntent().getIntExtra(Constants.CashBookDetails.POSITION,-1);
        TitleModel mTitleModel = new TitleModel();
        mBinding.icTitle.action.setVisibility(View.VISIBLE);
        mTitleModel.setTitle("账户详情");
        mTitleModel.setRightText("添加账本");
        mBinding.setMTitleModel(mTitleModel);
        initDisplayOpinion();
    }
    @Override
    public void onClickRightView(View view){
        Intent mIntent = new Intent(mActivity, AddCashBookActivity.class);
        mIntent.putExtra(Constants.CashBookDetails.USERID,userId);
        mIntent.putExtra(Constants.CashBookDetails.EDITABLE,view!=null?true:false);
        mIntent.putExtra(Constants.CashBookDetails.CASHBOOKID,view!=null?-1:cashBook.getCashBookId());
        mActivity.startActivityForResult(mIntent, Constants.CashBookDetails.QUESTCODE);
    }
    public void onItemSelected(String data){
        mLockTableView.setTableDatas(getTableDatas(data.length()>0?data:null));
    }
    private ArrayList<ArrayList<String>> getTableDatas(String data){
        set = new LinkedHashSet<>();
        ArrayList<ArrayList<String>> mTableDatas = new ArrayList<>();
        ArrayList<String> mfristData = new ArrayList<>();
        String[] mArry = activity.getResources().getStringArray(R.array.table_title);
        for(String mString:mArry){
            mfristData.add(mString);
        }
        mTableDatas.add(mfristData);
        double mDigFlatHour=0;
        double mDigFlatTotalAmount=0.00;
        double mFractureHour=0;
        double mFractureTotalAmount=0.00;
        if(data==null||"全部".equals(data)){
            mCashBooks = DataBaseTool.getInstance().getCashBooksByUserId(userId);
        }else{
            mCashBooks = DataBaseTool.getInstance().getCashBooksByUserIdAndData(userId,data);
        }
        set.add("全部");
        for(CashBook mCashBook:mCashBooks){
            set.add(TimeUtils.convertYMD2YM(mCashBook.getDate()));
            ArrayList<String> mRowDatas = new ArrayList<>();
            mRowDatas.add(mCashBook.getDate());
            mRowDatas.add(StringUtils.formatDouble1(mCashBook.getDigFlatHour()));
            mDigFlatHour+=mCashBook.getDigFlatHour();
            mRowDatas.add(StringUtils.formatDouble(mCashBook.getDigFlatTotalAmount()));
            mDigFlatTotalAmount+=mCashBook.getDigFlatTotalAmount();
            mRowDatas.add(StringUtils.formatDouble1(mCashBook.getFractureHour()));
            mFractureHour += mCashBook.getFractureHour();
            mRowDatas.add(StringUtils.formatDouble(mCashBook.getFractureTotalAmount()));
            mFractureTotalAmount += mCashBook.getFractureTotalAmount();
            mRowDatas.add(mCashBook.getAutograph());
            mRowDatas.add(mCashBook.getRemarks());
            mTableDatas.add(mRowDatas);
        }

        ArrayList<String> mRowDatas1 = new ArrayList<>();
        mRowDatas1.add("统计");
        mRowDatas1.add(StringUtils.formatDouble1(mDigFlatHour));
        mRowDatas1.add(StringUtils.formatDouble(mDigFlatTotalAmount));
        mRowDatas1.add(StringUtils.formatDouble1(mFractureHour));
        mRowDatas1.add(StringUtils.formatDouble(mFractureTotalAmount));
        mTableDatas.add(mRowDatas1);
        return mTableDatas;
    }
    public void getCashBookModels() {
        ArrayList<ArrayList<String>> mTableDatas = getTableDatas(null);
        if(mTableDatas == null){
            return;
        }
        mLockTableView = new LockTableView(activity, mBinding.contentView, mTableDatas);
        titles = new ArrayList<>(set);
        mBinding.spinner.attachDataSource(titles);
        mLockTableView.setLockFristColumn(true) //是否锁定第一列
                .setLockFristRow(true) //是否锁定第一行
                .setMaxColumnWidth(100) //列最大宽度
                .setMinColumnWidth(60) //列最小宽度
//                .setColumnWidth(1,30) //设置指定列文本宽度
//                .setColumnWidth(2,20)
                .setMinRowHeight(20)//行最小高度
                .setMaxRowHeight(60)//行最大高度
                .setTextViewSize(16) //单元格字体大小
                .setFristRowBackGroudColor(R.color.table_head)//表头背景色
                .setTableHeadTextColor(R.color.beijin)//表头字体颜色
                .setTableContentTextColor(R.color.border_color)//单元格字体颜色
                .setCellPadding(15)//设置单元格内边距(dp)
                .setNullableString("") //空值替换值
                .setOnLoadingListener(new LockTableView.OnLoadingListener() {
                    @Override
                    public void onRefresh(final XRecyclerView mXRecyclerView, final ArrayList<ArrayList<String>> mTableDatas) {
                        mBinding.spinner.setSelectedIndex(0);
                        ArrayList<ArrayList<String>> mListTableDatas = getTableDatas(null);
                        mLockTableView.setTableDatas(mListTableDatas);
                        mXRecyclerView.refreshComplete();
                    }
                    @Override
                    public void onLoadMore(final XRecyclerView mXRecyclerView, final ArrayList<ArrayList<String>> mTableDatas) {
                        mXRecyclerView.loadMoreComplete();
                    }
                })
                .setOnItemClickListenter(new LockTableView.OnItemClickListenter() {
                    @Override
                    public void onItemClick(View item, int position) {
                        int size = position-mCashBooks.size();
                        if(size==1){
                            return;
                        }
                        cashBook = mCashBooks.get(position-1);
                        onClickRightView(null);
                    }
                })
                .setOnItemSeletor(R.color.dashline_color)//设置Item被选中颜色
                .show(); //显示表格,此方法必须调用
        mXRecyclerView = mLockTableView.getTableScrollView();
        mXRecyclerView.setPullRefreshEnabled(true);
        mXRecyclerView.setLoadingMoreEnabled(true);
        mXRecyclerView.setRefreshProgressStyle(ProgressStyle.SquareSpin);

    }
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (data == null) {
            return;
        }
        if(requestCode == Constants.CashBookDetails.QUESTCODE && resultCode == Constants.CashBookDetails.RRESULTCODE){
            mXRecyclerView.refresh();
            String dataTime = data.getStringExtra(Constants.AddCashBook.DATATIME);
            if(dataTime != null){//如果是添加则把日期加入搜索中
                String mYM = TimeUtils.convertYMD2YM(dataTime);
                if(titles.indexOf(mYM)==-1){
                    titles.add(mYM);
                }

            }
            return;
        }
    }
    private void initDisplayOpinion() {
        DisplayMetrics dm = activity.getResources().getDisplayMetrics();
        DisplayUtil.density = dm.density;
        DisplayUtil.densityDPI = dm.densityDpi;
        DisplayUtil.screenWidthPx = dm.widthPixels;
        DisplayUtil.screenhightPx = dm.heightPixels;
        DisplayUtil.screenWidthDip = DisplayUtil.px2dip(activity.getApplicationContext(), dm.widthPixels);
        DisplayUtil.screenHightDip = DisplayUtil.px2dip(activity.getApplicationContext(), dm.heightPixels);
    }

}
