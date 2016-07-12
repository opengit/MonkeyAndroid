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

package com.sunjiajia.monkeyandroid.mustlearn.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/**
 * Created by monkey on 16-7-1.
 */
public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter<BaseRecyclerHolder> {

  private ArrayList<T> list;

  public BaseRecyclerAdapter(ArrayList<T> list) {
    this.list = list;
  }

  @Override public BaseRecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    View itemView =
        LayoutInflater.from(parent.getContext()).inflate(giveItemLayoutResId(), parent, false);

    return getRecyclerHolder(itemView);
  }

  @Override public void onBindViewHolder(BaseRecyclerHolder holder, int position) {
    holder.setData(list.get(position));
  }

  @Override public int getItemCount() {
    return list.size();
  }

  /**
   * 将初始化Holder的任务交给子类
   * @param itemView
   * 单个itemView，只要实现了giveItemLayoutResId方法，此itemView会自动产生
   * @return
   * 返回的是一个封装好的继承自BaseRecyclerHolder的ViewHolder
   */
  public abstract BaseRecyclerHolder getRecyclerHolder(View itemView);

  /**
   *给出Item的布局文件Id，从而产生itemView
   * @return
   * Item的布局文件Id
   */
  public abstract int giveItemLayoutResId();
}
