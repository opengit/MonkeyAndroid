/*
 *
 *  *
 *  *  * ===================================
 *  *  * Copyright (c) 2016.
 *  *  * 作者：安卓猴
 *  *  * 微博：@安卓猴
 *  *  * 博客：http://sunjiajia.com
 *  *  * Github：https://github.com/opengit
 *  *  *
 *  *  * 注意**：如果您使用或者修改该代码，请务必保留此版权信息。
 *  *  * ===================================
 *  *
 *  *
 *
 */

package com.sunjiajia.monkeyandroid.baselearn.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;
import com.sunjiajia.monkeyandroid.R;

/**
 * Created by monkey on 12/9/15.
 */
public class ButtonActivity extends BaseActivity {

  @Override public int giveViewResId() {
    return R.layout.activity_btn;
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  /**
   * Button的点击事件
   */
  public void btnClicked(View view) {
    switch (view.getId()) {
      case R.id.btn_btn:
        Toast.makeText(ButtonActivity.this, "我是安卓猴", Toast.LENGTH_SHORT).show();
        break;
      case R.id.btn_transparent_btn:
        Toast.makeText(ButtonActivity.this, "透明背景Button", Toast.LENGTH_SHORT).show();
        break;
      case R.id.btn_selector_btn:
        Toast.makeText(ButtonActivity.this, "设置selector的Button", Toast.LENGTH_SHORT).show();
        break;
      case R.id.imagebtn:
        Toast.makeText(ButtonActivity.this, "我是ImageButton", Toast.LENGTH_SHORT).show();
        break;
    }
  }
}
