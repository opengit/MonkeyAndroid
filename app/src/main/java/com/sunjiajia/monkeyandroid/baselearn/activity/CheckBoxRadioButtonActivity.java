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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.sunjiajia.monkeyandroid.R;

/**
 * Created by monkey on 1/1/16.
 *
 * 实现了CheckButton的接口CompoundButton.OnCheckedChangeListener
 *
 * 实现了RadioGroup的接口RadioGroup.OnCheckedChangeListener
 */
public class CheckBoxRadioButtonActivity extends BaseActivity
    implements CompoundButton.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener {
  private CheckBox mCbXs, mCbYx, mCbDy;
  private RadioGroup mRg;
  private RadioButton mRbBanana, mRbApple, mRbOrange;

  @Override public int giveViewResId() {
    return R.layout.activity_checkbox_radiobutton;
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    initViews();

    configViews();
  }

  /**
   * 配置各种控件，在这里只是设置了绑定了监听事件
   */
  private void configViews() {
    mCbXs.setOnCheckedChangeListener(this);
    mCbYx.setOnCheckedChangeListener(this);
    mCbDy.setOnCheckedChangeListener(this);

    mRg.setOnCheckedChangeListener(this);
  }

  /**
   * init各种控件
   */
  private void initViews() {
    mCbXs = (CheckBox) findViewById(R.id.checkbox_xiaoshuo);
    mCbYx = (CheckBox) findViewById(R.id.checkbox_youxi);
    mCbDy = (CheckBox) findViewById(R.id.checkbox_dianying);

    mRg = (RadioGroup) findViewById(R.id.radio_group);

    mRbBanana = (RadioButton) findViewById(R.id.radiobutton_banana);
    mRbApple = (RadioButton) findViewById(R.id.radiobutton_apple);
    mRbOrange = (RadioButton) findViewById(R.id.radiobutton_orange);
  }

  /**
   * CheckBox的监听事件
   */
  @Override public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    switch (buttonView.getId()) {
      case R.id.checkbox_xiaoshuo:
        checkedShowToast(buttonView, isChecked);
        break;
      case R.id.checkbox_youxi:
        checkedShowToast(buttonView, isChecked);
        break;
      case R.id.checkbox_dianying:
        checkedShowToast(buttonView, isChecked);
        break;
    }
  }

  /**
   * RadioGroup的监听事件
   */
  @Override public void onCheckedChanged(RadioGroup group, int checkedId) {

    switch (checkedId) {
      case R.id.radiobutton_banana:
        radioGroupChecked(mRbBanana);
        break;
      case R.id.radiobutton_apple:
        radioGroupChecked(mRbApple);
        break;
      case R.id.radiobutton_orange:
        radioGroupChecked(mRbOrange);
        break;
    }
  }

  private void radioGroupChecked(RadioButton button) {
    Toast.makeText(CheckBoxRadioButtonActivity.this, "您选中了#" + button.getText().toString() + "#",
        Toast.LENGTH_SHORT).show();
  }

  private void checkedShowToast(CompoundButton buttonView, boolean isChecked) {
    if (isChecked) {
      Toast.makeText(CheckBoxRadioButtonActivity.this,
          "您选中了#" + buttonView.getText().toString() + "#", Toast.LENGTH_SHORT).show();
    } else {
      Toast.makeText(CheckBoxRadioButtonActivity.this,
          "您取消了#" + buttonView.getText().toString() + "#", Toast.LENGTH_SHORT).show();
    }
  }
}
