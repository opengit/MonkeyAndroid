/*
 *
 *  *
 *  *  *
 *  *  *  * ===================================
 *  *  *  * Copyright (c) 2016.
 *  *  *  * 作者：安卓猴
 *  *  *  * 微博：@安卓猴
 *  *  *  * 博客：http://sunjiajia.com
 *  *  *  * Github：https://github.com/opengit
 *  *  *  *
 *  *  *  * 注意**：如果您使用或者修改该代码，请务必保留此版权信息。
 *  *  *  * ===================================
 *  *  *
 *  *  *
 *  *
 *
 */

package com.sunjiajia.monkeyandroid.mustlearn.databinding.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.databinding.library.baseAdapters.BR;
import com.sunjiajia.monkeyandroid.R;
import com.sunjiajia.monkeyandroid.mustlearn.databinding.bean.User;
import java.util.ArrayList;

/**
 * Created by monkey on 16-7-14.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

  private static final int ITEM_COUNT = 50;

  @NonNull private ArrayList<User> mList;

  public RecyclerAdapter() {
    mList = new ArrayList<>(ITEM_COUNT);
    for (int i = 0; i < ITEM_COUNT; i++) {
      User user = new User("Jack # " + i, "123456" + i, 18 + i, "Jack # " + i + "@jack.com", false);
      mList.add(user);
    }
  }

  @Override public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
        R.layout.item_recycler_binding, parent, false);
    MyViewHolder holder = new MyViewHolder(binding.getRoot());
    holder.setBinding(binding);
    return holder;
  }

  @Override public void onBindViewHolder(MyViewHolder holder, int position) {
    User user = mList.get(position);
    System.out.println(user.toString());
    holder.getBinding().setVariable(BR.user, user);
  }

  @Override public int getItemCount() {
    return mList.size();
  }

  class MyViewHolder extends RecyclerView.ViewHolder {

    private ViewDataBinding mBinding;

    public ViewDataBinding getBinding() {
      return mBinding;
    }

    public void setBinding(ViewDataBinding binding) {
      this.mBinding = binding;
    }

    public MyViewHolder(View itemView) {
      super(itemView);
    }
  }
}

