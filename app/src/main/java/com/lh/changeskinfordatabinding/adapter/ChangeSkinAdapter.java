package com.lh.changeskinfordatabinding.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.lh.changeskinfordatabinding.BR;
import com.lh.changeskinfordatabinding.R;
import com.lh.changeskinfordatabinding.entety.SkinAttr;
import com.lh.changeskinfordatabinding.entety.User;

import java.util.List;

public class ChangeSkinAdapter extends RecyclerView.Adapter<ChangeSkinAdapter.BindingViewHolder> {

    private final LayoutInflater mLayoutInflater;
    private List<User> mList;
    private SkinAttr mSkinAttr;

    public ChangeSkinAdapter(Context context, List<User> list) {
        mLayoutInflater = LayoutInflater.from(context);
        mList = list;
    }

    @NonNull
    @Override
    public BindingViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ViewDataBinding inflate = DataBindingUtil.inflate(mLayoutInflater, R.layout.item_skin, viewGroup, false);
        return new BindingViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull BindingViewHolder holder, int postion) {
        User user = mList.get(postion);
        if (mSkinAttr != null) {
            holder.getBinding().setVariable(BR.SkinAttr, mSkinAttr);
        }
        holder.getBinding().setVariable(BR.User, user);
        holder.getBinding().executePendingBindings();
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setSkinAttr(SkinAttr skinAttr) {
        mSkinAttr = skinAttr;
    }

    class BindingViewHolder<T extends ViewDataBinding>
            extends RecyclerView.ViewHolder {
        private T mBinding;

        public BindingViewHolder(T binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        public T getBinding() {
            return mBinding;
        }
    }

}


