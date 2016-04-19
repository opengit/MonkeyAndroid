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
import android.widget.CompoundButton;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;
import com.sunjiajia.monkeyandroid.R;

/**
 * Created by monkey on 1/2/16.
 */
public class ToggleButtonRadioBarActivity extends BaseActivity
    implements CompoundButton.OnCheckedChangeListener, RatingBar.OnRatingBarChangeListener {
  private ToggleButton mTb;
  private Switch mSwitch;
  private RatingBar mRb;

  @Override public int giveViewResId() {
    return R.layout.activity_togglebutton_radiobar;
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mTb = (ToggleButton) findViewById(R.id.toggle_button);
    mSwitch = (Switch) findViewById(R.id.switch_button);
    mRb = (RatingBar) findViewById(R.id.rating_bar);

    mTb.setOnCheckedChangeListener(this);
    mSwitch.setOnCheckedChangeListener(this);
    mRb.setOnRatingBarChangeListener(this);
  }

  /**
   * ToggleButton和Switch的事件监听
   */
  @Override public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
    switch (buttonView.getId()) {
      case R.id.toggle_button:
        showToast(isChecked);
        break;
      case R.id.switch_button:
        showToast(isChecked);
        break;
    }
  }

  private void showToast(boolean isChecked) {

    if (isChecked) {
      Toast.makeText(ToggleButtonRadioBarActivity.this, "开", Toast.LENGTH_SHORT).show();
    } else {
      Toast.makeText(ToggleButtonRadioBarActivity.this, "关", Toast.LENGTH_SHORT).show();
    }
  }

  /**
   * RatingBar的事件监听方法
   */
  @Override public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
    Toast.makeText(ToggleButtonRadioBarActivity.this, "获得了#" + rating + "#星好评！", Toast.LENGTH_SHORT)
        .show();
  }
}
