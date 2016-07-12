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
import com.sunjiajia.monkeyandroid.R;
import java.util.ArrayList;

/**
 * Created by monkey on 16-7-1.
 */
public class MyRecyclerAdapter extends BaseRecyclerAdapter<String> {

  public MyRecyclerAdapter(ArrayList<String> list) {
    super(list);
  }

  @Override public BaseRecyclerHolder getRecyclerHolder(View itemView) {
    return new MyRecyclerHolder(itemView);
  }

  @Override public int giveItemLayoutResId() {
    return R.layout.item_recycler;
  }
}
