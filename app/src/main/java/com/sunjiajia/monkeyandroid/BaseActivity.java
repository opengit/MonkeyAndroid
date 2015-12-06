package com.sunjiajia.monkeyandroid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by monkey on 12/6/15.
 */
public abstract class BaseActivity extends AppCompatActivity {

  public abstract int giveViewResId();

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(giveViewResId());
    setActivityTitle();
  }

  private void setActivityTitle() {
    setTitle(getIntent().getStringExtra("title"));
  }
}
