package com.luchongbin.mycashbook.adapter;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.luchongbin.mycashbook.R;
import com.luchongbin.mycashbook.base.RecyclerViewHolder;
import com.luchongbin.mycashbook.databinding.CashbookDetailsItemBinding;
import com.luchongbin.mycashbook.databinding.CashbookFragmentItemBinding;
import com.luchongbin.mycashbook.model.CashBookModel;
import com.luchongbin.mycashbook.model.CashUsersModel;
import com.rmondjone.locktableview.DisplayUtil;

import java.util.ArrayList;
import java.util.List;

public class CashBookDetailsAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    private List<CashBookModel> mList;
    private Activity context;
    public CashBookDetailsAdapter(Activity context, List<CashBookModel> mList) {
        this.mList = mList;
        this.context =context;
//        initDisplayOpinion();
    }
    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }
    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        ViewDataBinding itemMvvmBinding = DataBindingUtil.inflate(layoutInflater, R.layout.cashbook_details_item, viewGroup, false);
        return new RecyclerViewHolder(itemMvvmBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder recyclerViewHolder, int position) {
        CashBookModel mCashBookModel = mList.get(position);
        CashbookDetailsItemBinding itemMvvmBinding = (CashbookDetailsItemBinding)recyclerViewHolder.getBinding();
//        getInitData();
        itemMvvmBinding.setMCashBookModel(mCashBookModel);
//        double mUnpaidAmount = Double.parseDouble(mCashBookModel.getUnpaidAmount());
//        Drawable mDrawable = context.getResources().getDrawable(mUnpaidAmount>0?R.mipmap.project_ing:R.mipmap.project_end);
//        itemMvvmBinding.ivOperTag.setImageDrawable(mDrawable);
//        setItemLister(itemMvvmBinding.getRoot(),mCashBookModel.getUserId(),position);
        //将position保存在itemView的Tag中，以便点击时进行获取
        itemMvvmBinding.getRoot().setTag(position);
        // 立刻执行绑定
        itemMvvmBinding.executePendingBindings();
    }
//    private void getInitData(){
//        ArrayList<ArrayList<String>> mTableDatas = new ArrayList<>();
//        String table context.getResources().getIntArray(R.array.table_title);
//
//        ArrayList<String> mfristData = new ArrayList<>();
//        for (int i = 0; i < 7; i++) {
//            if(i==2){
//                mfristData.add("挖斗时间\n单价(180元)" + i);
//            }else{
//                mfristData.add("挖斗时间" + i);
//            }
//
//        }
//        mTableDatas.add(mfristData);
//    }
//    private void initDisplayOpinion() {
//        DisplayMetrics dm =context.getResources().getDisplayMetrics();
//        DisplayUtil.density = dm.density;
//        DisplayUtil.densityDPI = dm.densityDpi;
//        DisplayUtil.screenWidthPx = dm.widthPixels;
//        DisplayUtil.screenhightPx = dm.heightPixels;
//        DisplayUtil.screenWidthDip = DisplayUtil.px2dip(context.getApplicationContext(), dm.widthPixels);
//        DisplayUtil.screenHightDip = DisplayUtil.px2dip(context.getApplicationContext(), dm.heightPixels);
//    }

}
