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

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.sunjiajia.monkeyandroid.R;

/**
 * Created by monkey on 16-7-1.
 */
public class MyRecyclerHolder extends BaseRecyclerHolder<String> {

  public MyRecyclerHolder(View itemView) {
    super(itemView);
  }

  @Override public void findAndRefreshItemView(final View itemView, final String data) {
    TextView textView = (TextView) itemView.findViewById(R.id.item_textview);
    textView.setText(data);

    itemView.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        Toast.makeText(itemView.getContext(), data + " clicked", Toast.LENGTH_SHORT).show();
      }
    });

    itemView.setOnLongClickListener(new View.OnLongClickListener() {
      @Override public boolean onLongClick(View view) {
        Toast.makeText(itemView.getContext(), data + " long clicked", Toast.LENGTH_SHORT).show();
        return true;
      }
    });
  }
}
