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

package com.sunjiajia.monkeyandroid.customwidgets.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import com.sunjiajia.monkeyandroid.R;
import com.sunjiajia.monkeyandroid.customwidgets.fragment.WidgetFragment;

/**
 * Created by monkey on 16-7-11.
 */
public class ShowWidgetsActivity extends AppCompatActivity {

  private int fragType;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setTitle("自定义控件效果");
    setContentView(R.layout.activity_show_widgets);

    initFragments();
  }

  private void initFragments() {
    fragType = getIntent().getIntExtra("frag", 0);
    if (fragType > 0) {

      FragmentManager manager = getSupportFragmentManager();
      FragmentTransaction transaction = manager.beginTransaction();
      WidgetFragment fragment = WidgetFragment.newInstance(fragType);
      transaction.replace(R.id.frame_widgets, fragment);
      transaction.commit();
    } else {
      throw new IllegalArgumentException("类型错误，初始化Fragment失败。");
    }
  }
}
