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

package com.sunjiajia.monkeyandroid.mustlearn.activitydata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.sunjiajia.monkeyandroid.R;

public class FirstActivity extends AppCompatActivity {

  @Bind(R.id.et_male_name) EditText mEtMaleName;
  @Bind(R.id.et_female_name) EditText mEtFemaleName;
  @Bind(R.id.btn_make1) Button mBtnMake;
  @Bind(R.id.btn_make2) Button mBtnMake2;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_first);
    ButterKnife.bind(this);
    ActionBar actionBar = getSupportActionBar();
    actionBar.setTitle("FirstActivity");
  }

  @OnClick({ R.id.btn_make1, R.id.btn_make2 }) public void onClick(View view) {

    switch (view.getId()) {
      case R.id.btn_make1:
        Intent intent = new Intent(this, TwoActivity.class);
        intent.putExtra("malename", "吕布");
        intent.putExtra("femalename", "貂蝉");
        startActivity(intent);
        break;
      case R.id.btn_make2:
        Bundle bundle = new Bundle();
        bundle.putString("malename2", "唐明皇");
        bundle.putString("femalename2", "杨贵妃");
        Intent intent2 = new Intent(this, TwoActivity.class);
        intent2.putExtras(bundle);
        startActivity(intent2);
        break;
    }
  }
}
