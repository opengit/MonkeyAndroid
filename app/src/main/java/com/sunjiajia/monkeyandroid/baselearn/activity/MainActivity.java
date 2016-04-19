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

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.sunjiajia.monkeyandroid.R;
import com.sunjiajia.monkeyandroid.mustlearn.MustLearnPointActivity;

/**
 * 此Activity容纳了基本控件的用法
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  private Button mBtnLlOnClick;
  private Button mBtnRlTl;
  private Button mBtnFlGl;
  private Button mBtnToast;
  private Button mBtnTvEt;
  private Button mBtnBtn;
  private Button mBtnIv;
  private Button mBtnCbRb;
  private Button mBtnTbRb;
  private Button mBtnSAcTv;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    initViews();
    configViews();
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();
    if (id == R.id.menu_must_learn_point) {
      Intent intent = new Intent(this, MustLearnPointActivity.class);
      intent.putExtra("title", item.getTitle());
      startActivity(intent);
    }
    return super.onOptionsItemSelected(item);
  }

  private void initViews() {
    mBtnLlOnClick = (Button) findViewById(R.id.btn_ll_onclick);
    mBtnRlTl = (Button) findViewById(R.id.btn_rl_tl);
    mBtnFlGl = (Button) findViewById(R.id.btn_fl_gl);
    mBtnToast = (Button) findViewById(R.id.btn_toast);
    mBtnTvEt = (Button) findViewById(R.id.btn_tv_et);
    mBtnBtn = (Button) findViewById(R.id.btn_btn);
    mBtnIv = (Button) findViewById(R.id.btn_imageview);
    mBtnCbRb = (Button) findViewById(R.id.btn_checkbox_radiobutton);
    mBtnTbRb = (Button) findViewById(R.id.btn_togglebutton_radiobar);
    mBtnSAcTv = (Button) findViewById(R.id.btn_spinner_autocompletetextview);
  }

  private void configViews() {
    mBtnLlOnClick.setOnClickListener(this);
    mBtnRlTl.setOnClickListener(this);
    mBtnFlGl.setOnClickListener(this);
    mBtnToast.setOnClickListener(this);
    mBtnTvEt.setOnClickListener(this);
    mBtnBtn.setOnClickListener(this);
    mBtnIv.setOnClickListener(this);
    mBtnCbRb.setOnClickListener(this);
    mBtnTbRb.setOnClickListener(this);
    mBtnSAcTv.setOnClickListener(this);
  }

  @Override public void onClick(View v) {
    String buttonText = (String) ((Button) v).getText();
    myIntent(v, buttonText);
  }

  private void myIntent(View view, String text) {

    Intent intent = null;

    switch (view.getId()) {
      case R.id.btn_ll_onclick:
        intent = new Intent(MainActivity.this, LinearLayoutActivity.class);
        break;
      case R.id.btn_rl_tl:
        intent = new Intent(MainActivity.this, RelativeTableLayoutActivity.class);
        break;
      case R.id.btn_fl_gl:
        intent = new Intent(MainActivity.this, FrameGridLayoutActivity.class);
        break;
      case R.id.btn_toast:
        intent = new Intent(MainActivity.this, ToastActivity.class);
        break;
      case R.id.btn_tv_et:
        intent = new Intent(MainActivity.this, TextViewEditTextActivity.class);
        break;
      case R.id.btn_btn:
        intent = new Intent(MainActivity.this, ButtonActivity.class);
        break;
      case R.id.btn_imageview:
        intent = new Intent(MainActivity.this, ImageViewActivity.class);
        break;
      case R.id.btn_checkbox_radiobutton:
        intent = new Intent(MainActivity.this, CheckBoxRadioButtonActivity.class);
        break;
      case R.id.btn_togglebutton_radiobar:
        intent = new Intent(MainActivity.this, ToggleButtonRadioBarActivity.class);
        break;
      case R.id.btn_spinner_autocompletetextview:
        intent = new Intent(MainActivity.this, SpinnerAutoCompleteTextViewActivity.class);
        break;
    }
    intent.putExtra("title", text);
    startActivity(intent);
  }
}
