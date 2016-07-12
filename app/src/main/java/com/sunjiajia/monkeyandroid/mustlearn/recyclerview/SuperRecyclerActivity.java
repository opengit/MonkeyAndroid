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

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.sunjiajia.monkeyandroid.R;
import com.sunjiajia.monkeyandroid.baselearn.activity.BaseActivity;
import java.util.ArrayList;

/**
 * Created by monkey on 16-6-30.
 */
public class SuperRecyclerActivity extends BaseActivity {

  private RecyclerView mRecyclerView;
  private ArrayList<String> mList;

  @Override public int giveViewResId() {
    return R.layout.activity_super_recycler;
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    initView();
    configView();
  }

  private void configView() {
    mList = new ArrayList<>();
    for (int i = 0; i < 20; i++) {
      mList.add("Jack " + i);
    }

    LinearLayoutManager manager =
        new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
    mRecyclerView.setLayoutManager(manager);
    mRecyclerView.setAdapter(new MyRecyclerAdapter(mList));
  }

  private void initView() {
    mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
  }
}
