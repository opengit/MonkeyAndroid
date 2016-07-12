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

package com.sunjiajia.monkeyandroid.mustlearn.sqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.sunjiajia.monkeyandroid.R;
import java.util.List;

/**
 * Created by monkey on 16-4-27.
 */
public class SqliteListViewAdapter extends BaseAdapter {

  private Context mContext;
  private List<String> mStringList;
  private LayoutInflater mInflater;

  public SqliteListViewAdapter(Context context, List<String> list) {
    mInflater = LayoutInflater.from(context);
    this.mContext = context;
    this.mStringList = list;
  }

  @Override public int getCount() {
    return mStringList.size();
  }

  @Override public Object getItem(int position) {
    return mStringList.get(position);
  }

  @Override public long getItemId(int position) {
    return position;
  }

  @Override public View getView(int position, View convertView, ViewGroup parent) {

    MyViewHolder holder;

    if (convertView == null) {
      convertView = mInflater.inflate(R.layout.item_sqlite, parent, false);
      holder = new MyViewHolder(convertView);
      convertView.setTag(holder);
    } else {
      holder = (MyViewHolder) convertView.getTag();
    }

    holder.mTvItem.setText(mStringList.get(position));

    return convertView;
  }

  static class MyViewHolder {
    @Bind(R.id.tv_item) TextView mTvItem;

    MyViewHolder(View view) {
      ButterKnife.bind(this, view);
    }
  }
}
