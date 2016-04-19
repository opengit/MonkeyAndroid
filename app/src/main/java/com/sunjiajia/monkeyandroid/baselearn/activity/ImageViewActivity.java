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
 * Created by monkey on 12/18/15.
 */
public class ImageViewActivity extends BaseActivity {

  @Override public int giveViewResId() {
    return R.layout.activity_imageview;
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  public void ivClicked(View view) {
    switch (view.getId()) {
      case R.id.imageview_normal:
        Toast.makeText(ImageViewActivity.this, "我是普通ImageView，我没有保持宽高比，我有黑边。", Toast.LENGTH_SHORT)
            .show();
        break;
      case R.id.imageview_super:
        Toast.makeText(ImageViewActivity.this, "我是超级ImageView，我保持了宽高比，我没有黑边。", Toast.LENGTH_SHORT)
            .show();
        break;
    }
  }
}
