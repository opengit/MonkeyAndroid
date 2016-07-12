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
import android.view.View;

/**
 * Created by monkey on 16-7-1.
 */
public abstract class BaseRecyclerHolder<T> extends RecyclerView.ViewHolder {

  private View itemView;
  private T data;

  public BaseRecyclerHolder(View itemView) {
    super(itemView);
    this.itemView = itemView;
  }

  /**
   * 设置数据
   * @param data
   *  单个数据
   */
  public void setData(T data) {
    this.data = data;
    findAndRefreshItemView(itemView, data);
  }

  /**
   * 得到单个数据
   * @return
   * 单个数据
   */
  public T getData() {
    return data;
  }

  /**
   * findViewById每个itemView中的控件，并刷新（设置数据、配置）它们
   * @param itemView
   *  每个item的根视图
   * @param data
   *  需要设置给itemView和它里面控件的单个数据
   */
  public abstract void findAndRefreshItemView(View itemView, T data);
}
