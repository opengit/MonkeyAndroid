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

package com.sunjiajia.monkeyandroid.mustlearn.dagger2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.sunjiajia.monkeyandroid.R;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by monkey on 16-4-26.
 */
public class UserAdapter extends BaseAdapter {
  private LayoutInflater mInflater;
  private List<String> mUserList;
  private Context mContext;

  @Inject public UserAdapter(Context context, List<String> list) {
    this.mInflater = LayoutInflater.from(context);
    this.mUserList = list;
    this.mContext = context;
  }

  @Override public int getCount() {
    return mUserList.size();
  }

  @Override public Object getItem(int position) {
    return mUserList.get(position);
  }

  @Override public long getItemId(int position) {
    return position;
  }

  @Override public View getView(final int position, View convertView, ViewGroup parent) {

    MyViewHolder holder;

    if (convertView == null) {
      convertView = mInflater.inflate(R.layout.item_user, parent, false);
      holder = new MyViewHolder(convertView);
      convertView.setTag(holder);
    } else {
      holder = (MyViewHolder) convertView.getTag();
    }

    holder.mTvUser.setText(mUserList.get(position));
    holder.mTvUser.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Toast.makeText(mContext, mUserList.get(position), Toast.LENGTH_SHORT).show();
      }
    });

    return convertView;
  }

  static class MyViewHolder {
    @Bind(R.id.tv_user) TextView mTvUser;

    MyViewHolder(View view) {
      ButterKnife.bind(this, view);
    }
  }
}
