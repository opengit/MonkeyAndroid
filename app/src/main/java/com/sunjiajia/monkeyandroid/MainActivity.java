package com.sunjiajia.monkeyandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  private Button mBtnLlOnClick;
  private Button mBtnRlTl;
  private Button mBtnFlGl;
  private Button mBtnToast;
  private Button mBtnTvEt;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    initViews();
    configViews();
  }

  private void initViews() {
    mBtnLlOnClick = (Button) findViewById(R.id.btn_ll_onclick);
    mBtnRlTl = (Button) findViewById(R.id.btn_rl_tl);
    mBtnFlGl = (Button) findViewById(R.id.btn_fl_gl);
    mBtnToast = (Button) findViewById(R.id.btn_toast);
    mBtnTvEt = (Button) findViewById(R.id.btn_tv_et);
  }

  private void configViews() {
    mBtnLlOnClick.setOnClickListener(this);
    mBtnRlTl.setOnClickListener(this);
    mBtnFlGl.setOnClickListener(this);
    mBtnToast.setOnClickListener(this);
    mBtnTvEt.setOnClickListener(this);
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
    }
    intent.putExtra("title", text);
    startActivity(intent);
  }
}
