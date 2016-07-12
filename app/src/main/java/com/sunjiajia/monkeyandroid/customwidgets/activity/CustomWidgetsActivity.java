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

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.sunjiajia.monkeyandroid.R;

/**
 * Created by monkey on 16-7-11.
 */
public class CustomWidgetsActivity extends AppCompatActivity {

  private Button mBtnRatioIv;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setTitle(getIntent().getStringExtra("title"));
    setContentView(R.layout.activity_custom_widgets);

    initViews();
    configViews();
  }

  private void configViews() {
    BtnClickedListener mClickedListener = new BtnClickedListener();
    mBtnRatioIv.setOnClickListener(mClickedListener);
  }

  private void initViews() {
    mBtnRatioIv = (Button) findViewById(R.id.btn_ratio_imageview);
  }

  private class BtnClickedListener implements View.OnClickListener {
    @Override public void onClick(View view) {
      int btnId = view.getId();
      Intent intent = new Intent(CustomWidgetsActivity.this, ShowWidgetsActivity.class);
      switch (btnId) {
        case R.id.btn_ratio_imageview:
          intent.putExtra("frag", btnId);
          startActivity(intent);
          break;
      }
      intent.removeExtra("frag");
    }
  }
}
