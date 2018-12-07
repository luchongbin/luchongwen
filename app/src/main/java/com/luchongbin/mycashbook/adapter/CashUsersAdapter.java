package com.luchongbin.mycashbook.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bigkoo.alertview.AlertView;
import com.bigkoo.alertview.OnItemClickListener;
import com.luchongbin.mycashbook.DataBase.DataBaseTool;
import com.luchongbin.mycashbook.R;
import com.luchongbin.mycashbook.activity.CashBookDetailsActivity;
import com.luchongbin.mycashbook.application.MyCashBookApplication;
import com.luchongbin.mycashbook.base.RecyclerViewHolder;
import com.luchongbin.mycashbook.databinding.CashbookFragmentItemBinding;
import com.luchongbin.mycashbook.model.CashBookModel;
import com.luchongbin.mycashbook.model.CashUsersModel;
import com.luchongbin.mycashbook.utils.Constants;
import com.luchongbin.mycashbook.utils.ToastUtils;

import java.util.List;

public class CashUsersAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    private List<CashUsersModel> mList;
    private Activity context;

    public CashUsersAdapter(Activity context, List<CashUsersModel> mList) {
        this.mList = mList;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        ViewDataBinding itemMvvmBinding = DataBindingUtil.inflate(layoutInflater, R.layout.cashbook_fragment_item, viewGroup, false);
        return new RecyclerViewHolder(itemMvvmBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder recyclerViewHolder, int position) {
        CashUsersModel mCashBookModel = mList.get(position);
        CashbookFragmentItemBinding itemMvvmBinding = (CashbookFragmentItemBinding) recyclerViewHolder.getBinding();
        itemMvvmBinding.setMCashUsersModel(mCashBookModel);
//        double mUnpaidAmount = Double.parseDouble(mCashBookModel.getUnpaidAmount());
//        Drawable mDrawable = context.getResources().getDrawable(mUnpaidAmount>0?R.mipmap.project_ing:R.mipmap.project_end);
//        itemMvvmBinding.ivOperTag.setImageDrawable(mDrawable);
        callPhone(itemMvvmBinding.tvMobilePhone, mCashBookModel.getMobilePhone());
        setItemLister(itemMvvmBinding.getRoot(), mCashBookModel, position);
        //将position保存在itemView的Tag中，以便点击时进行获取
        itemMvvmBinding.getRoot().setTag(position);
        // 立刻执行绑定
        itemMvvmBinding.executePendingBindings();
    }

    private void callPhone(View view, final String mobilePhone) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                Uri data = Uri.parse("tel:" + mobilePhone);
                intent.setData(data);
                context.startActivity(intent);
            }
        });
    }

    private void setItemLister(View view, final CashUsersModel mCashBookModel, final int position) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(context, CashBookDetailsActivity.class);
                mIntent.putExtra(Constants.CashBookDetails.USERID, mCashBookModel.getUserId());
                mIntent.putExtra(Constants.CashBookDetails.POSITION, position);
                context.startActivityForResult(mIntent, Constants.CashBookDetails.QUESTCODE);
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                alertShow(mCashBookModel);

                return true;
            }
        });
    }

    public void alertShow(final CashUsersModel mCashBookModel) {
        new AlertView("删除", "您确定要删除此用账户所有的信息？", "取消", new String[]{"确定"}, null, context, AlertView.Style.Alert, new OnItemClickListener() {
            @Override
            public void onItemClick(Object o, int position) {
                if (position == 0) {
                    DataBaseTool.getInstance().deleteCashBookByuserId(mCashBookModel.getUserId());
                    DataBaseTool.getInstance().deleteUserById(mCashBookModel.getId());
                    mList.remove(position);
                    notifyDataSetChanged();
                    ToastUtils.popUpToast( "已删除此用账户所有的信息");
                }


            }
        }).show();
    }


}
